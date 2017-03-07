package com.bkj.search.gui;

import com.bkj.search.utils.FileInvertedIndex;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

/**
 * @see Runnable
 * @since 0.1
 */
public class AdministrationWindow implements Runnable {
    private JPanel topPanel;
    private JPanel optionsPanel;
    private JPanel indexedFilesPanel;
    private JTable indexedFilesTable;
    private JButton removeIndexButton;
    private JButton updateIndexButton;
    private JButton addIndexButton;
    private JButton closeFormButton;

    private JFrame mainFrame;
    private final MainWindow mw;
    private final TreeMap<String, Date> openFiles;
    private DefaultTableModel indexedFilesTableModel;

    /**
     * Creates a default Administration Window to manage index files
     */
    public AdministrationWindow(MainWindow mw) {
        this.mw = mw;
        openFiles = mw.getOpenFiles();
        $$$setupUI$$$();


        closeFormButton.addActionListener(actionEvent -> mainFrame.dispose());

        addIndexButton.addActionListener(actionEvent -> {
            // TODO: Should we include the ability to add indexes manually?
            // It sounds like it would only break things without adding functionality
        });
        removeIndexButton.addActionListener(actionEvent -> {
            // TODO: should we be able to remove indexed files?
            // because so far the only way to add a file is by adding it to the MainWindow
        });
        updateIndexButton.addActionListener(actionEvent -> {
            int selectedIndex = indexedFilesTable.getSelectedRow();

        });

        mainFrame.setContentPane($$$getRootComponent$$$());
        mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        mainFrame.setPreferredSize(new Dimension(850, 250));
    }

    /**
     * calls JDialog::pack and sets the dialog visible
     *
     * @see Runnable
     */
    @Override
    public void run() {

        // TODO: Best case, this should run is a seperate thread and fire a event when it is done
        if (openFiles.size() > 0) {
            System.out.printf("Opening %d files for indexing%n", openFiles.size());
            for (String s : openFiles.keySet()) {
                try {
                    mw.addIndexedFile(new FileInvertedIndex(s));
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }

            System.out.printf("Rebuilding %d indexes%n", mw.getIndexedFiles().size());
            long currentTimeMillis;
            long totalTimeMillis;
            for (FileInvertedIndex fii : mw.getIndexedFiles()) {
                currentTimeMillis = System.currentTimeMillis();
                System.out.printf("\t> Rebuilding %s [MD5:%s]%n", fii.getFileName(), fii.getMD5Sum());
                try {
                    fii.rebuildIndex();
                } catch (IOException e) {
                    System.out.printf("\t> !!!Failed to index %s!!!%n", fii.getFilePathString());
                    e.printStackTrace();
                }
                totalTimeMillis = System.currentTimeMillis() - currentTimeMillis;
                System.out.printf("Indexed %s in %d Milliseconds%n", fii.getFilePathString(), totalTimeMillis);
            }
        }
        mainFrame.pack();
        mainFrame.setVisible(true);
    }

    /**
     * For UI components marked 'Custom Create'
     * <p>
     * Intellij generates the $$$setupUI$$$() method and calls createUIComponents()
     * this allows greater control over how objects are made instead of the default
     * parameter-less constructor
     * </p>
     */
    private void createUIComponents() {
        // TODO: place custom component creation code here
        mainFrame = new JFrame("Index Administration");
        TreeMap<String, Boolean> indexedFilesMap = new TreeMap<>();
        // we create the default state here, which is everything is *not* indexed
        for (String file : openFiles.keySet()) {
            indexedFilesMap.put(file, false);
        }
        indexedFilesTableModel = makeTableModel(indexedFilesMap);
        indexedFilesTable = new JTable(indexedFilesTableModel);
    }

    private DefaultTableModel makeTableModel(Map<String, Boolean> map) {
        DefaultTableModel model = new DefaultTableModel(
                new Object[]{"File", "Indexed?"}, 0
        );
        for (Map.Entry<String, Boolean> entry : map.entrySet()) {
            model.addRow(new Object[]{entry.getKey(), entry.getValue()});
        }
        return model;
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        createUIComponents();
        topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout(0, 0));
        optionsPanel = new JPanel();
        optionsPanel.setLayout(new GridBagLayout());
        topPanel.add(optionsPanel, BorderLayout.NORTH);
        removeIndexButton = new JButton();
        removeIndexButton.setText("Remove Index");
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        optionsPanel.add(removeIndexButton, gbc);
        final JPanel spacer1 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        optionsPanel.add(spacer1, gbc);
        final JPanel spacer2 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.VERTICAL;
        optionsPanel.add(spacer2, gbc);
        final JPanel spacer3 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.VERTICAL;
        optionsPanel.add(spacer3, gbc);
        final JPanel spacer4 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        optionsPanel.add(spacer4, gbc);
        updateIndexButton = new JButton();
        updateIndexButton.setText("Update Index");
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        optionsPanel.add(updateIndexButton, gbc);
        addIndexButton = new JButton();
        addIndexButton.setText("Add Index");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        optionsPanel.add(addIndexButton, gbc);
        indexedFilesPanel = new JPanel();
        indexedFilesPanel.setLayout(new BorderLayout(0, 0));
        topPanel.add(indexedFilesPanel, BorderLayout.CENTER);
        closeFormButton = new JButton();
        closeFormButton.setText("Close");
        indexedFilesPanel.add(closeFormButton, BorderLayout.SOUTH);
        final JScrollPane scrollPane1 = new JScrollPane();
        indexedFilesPanel.add(scrollPane1, BorderLayout.CENTER);
        scrollPane1.setViewportView(indexedFilesTable);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return topPanel;
    }
}
