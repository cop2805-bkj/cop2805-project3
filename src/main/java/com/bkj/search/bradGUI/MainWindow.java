package com.bkj.search.bradGUI;

import com.bkj.search.bradSearch.SearchableFileIndex;
import com.bkj.search.bradUtils.*;
import com.google.gson.Gson;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.lang.reflect.Array;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;

/**
 * @see Runnable
 * @since 0.1
 */
public class MainWindow implements Runnable, Saveable, Loadable<MainWindow.MainWindowBuilder> {
    private JPanel topPanel;
    private JButton searchButton;
    private JTextField searchTextField;
    private JTabbedPane tabbedPane1;
    private JTable resultsTable;
    private JProgressBar progressBar1;
    private JButton chooseFilesButton;
    private JButton removeSelectedFileButton;
    private JButton selectDBButton;
    private JButton aboutButton;
    private JTextField databaseFileTextField;
    private JCheckBox useDatabaseCheckbox;
    private JButton adminPageButton;
    private JComboBox searchComboBox;
    private JPanel searchPanel;
    private JPanel mainPanel;
    private JPanel toolbarPanel;
    private JPanel resultsPanel;
    private JPanel filesListPanel;
    private JPanel settingsPagePanel;
    private JCheckBox saveSettingsOnExitCheckBox;
    private JTable openFilesTable;
    private JButton importListButton;
    private JFileChooser searchFilesChooser;

    private JFrame mainFrame;
    private DefaultTableModel openFilesTableModel;

    private Dimension windowDimensions;
    private boolean saveOnExit;
    private boolean useDatabase;
    private String databasePath;
    private final String builderJsonString;

    public SearchUIModel dataModel;

    /**
     * calls JDialog::pack and sets the dialog visible
     *
     * @see Runnable
     */
    @Override
    public void run() {
        mainFrame.pack();
        mainFrame.setVisible(true);
    }

    /**
     * creates a new main window frame along with content
     * <p>
     * Calls IntelliJ 'entry point' $$$setupUI$$$() and creates actionEvents for buttons
     * UI components
     * </p>
     */
    private MainWindow(MainWindowBuilder b, SearchUIModel dm) {
        this.dataModel = dm;
        $$$setupUI$$$();        // This must be first
        loadFromJson(b);        // This must be second

        builderJsonString = b.toString();
        System.out.printf("JSON Builder: %s \n\n", builderJsonString);

        saveSettingsOnExitCheckBox.addItemListener(e -> {
            saveOnExit = (e.getStateChange() == ItemEvent.SELECTED);
        });

        useDatabaseCheckbox.addItemListener(e -> {
            useDatabase = (e.getStateChange() == ItemEvent.SELECTED);
        });

        searchButton.addActionListener(actionEvent -> {
            String[] searchTerms = searchTextField
                    .getText()                      // Get text from field
                    .toLowerCase()                  // TODO: make code more robust for upper and lower case
                    .replaceAll("[^a-z0-9 ]", "")   // remove all non-alpha-numerics
                    .split(" ");             // split into strings separated by a space i.e {"The", "Quick", "Red", ...}

            String selectedSearchType = (String) searchComboBox.getSelectedItem();
            SearchableFileIndex.SEARCH_TYPE searchType = SearchableFileIndex.SEARCH_TYPE.OR; // default to OR search

            switch (selectedSearchType) {
                case "OR":
                    searchType = SearchableFileIndex.SEARCH_TYPE.OR;
                    break;
                case "AND":
                    searchType = SearchableFileIndex.SEARCH_TYPE.AND;
                    break;
                case "PHRASE":
                    searchType = SearchableFileIndex.SEARCH_TYPE.PHRASE;
                    break;
                default:
                    // This should be impossible because the values in the combobox are set at compile time
                    break;
            }

            System.out.printf("Performing %s search on \"%s\" %n", selectedSearchType, String.join(" ", searchTerms));

            //TODO: move search logic out of the thread the UI is running on
            // for a "proof of concept" the search logic is contained here
            if (dm.getIndexedFiles().size() <= 0 || dm.getOpenFiles().size() <= 0 || searchTerms.length <= 0) {
                System.out.printf("No indexed files OR no open files OR no search terms given%n");
            } else {
                List<IInvertedIndexEntry> resultList = new ArrayList<>();

                // for each indexed file
                for (FileInvertedIndex fii : dm.getIndexedFiles()) {
                    // for each supplied search term
                    for (String term : searchTerms) {
                        // if the file contains AT LEAST one of the term we want
                        if (fii.containsTerm(term)) {
                            resultList.addAll(fii.getAllResults(term, searchType));
                        } else {
                            System.out.printf("File %s does not contain term...skipping%n", fii.getFileName());
                        }
                    }
                }
                // TODO: Put this in the results table
                System.out.printf("Found %d results for search term %s %n", resultList.size(), String.join(" ", searchTerms));
                for (IInvertedIndexEntry result : resultList) {
                    System.out.printf("DocID: %d \t\t LineNumber: %d %n", result.getDocID(), result.getLineNumber());
                }
            }
        });

        selectDBButton.addActionListener(actionEvent -> {
            //TODO: implement database ability
        });

        aboutButton.addActionListener(actionEvent -> SwingUtilities.invokeLater(new AboutDialog()));

        // Adds slected file to file table
        chooseFilesButton.addActionListener(actionEvent -> {
            searchFilesChooser.setFileFilter(new FileNameExtensionFilter("Plain Text Files", "txt"));
            int fcRetVal = searchFilesChooser.showOpenDialog(topPanel);
            if (fcRetVal == JFileChooser.APPROVE_OPTION) {
                File file = searchFilesChooser.getSelectedFile();
                // TODO: Handle multiple files and recursive searching by selecting directories
                dataModel.getOpenFiles().add(file.toString());


                Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String dateString = formatter.format(new Date(file.lastModified()));

                openFilesTableModel.addRow(new Object[]{file.getName(), dateString});
            }
        });

        // Imports a list of files vs a single file at a time
        importListButton.addActionListener(actionEvent -> {
            //TODO: implement the ability to import a file list
        });

        // Removes selected file in file table
        removeSelectedFileButton.addActionListener(actionEvent -> {
            System.out.printf("Removing index: %d\n", openFilesTable.getSelectedRow());
            try {
                int currentRow = openFilesTable.getSelectedRow();
                String fileName = openFilesTable.getModel().getValueAt(currentRow, 0).toString();

                dataModel.getOpenFiles().remove(fileName);
                ((DefaultTableModel) openFilesTable.getModel()).removeRow(currentRow);

            } catch (ArrayIndexOutOfBoundsException aie) {
                NotImplementedDialog d = new NotImplementedDialog("Whoops!", "Select a file to remove");
            }
        });

        // Opens Admin Page
        adminPageButton.addActionListener(actionEvent -> {
            AdministrationWindow win = new AdministrationWindow(this);
            SwingUtilities.invokeLater(win);
        });

        // So we can implement save on exit we override and insert our save function
        // and then call the original method
        mainFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        mainFrame.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent we) {
                if (saveOnExit) {
                    System.out.println("Saving and exiting...");
                    saveToJson();
                } else {
                    System.out.println("Saving without exiting...");
                }
                mainFrame.dispose();
            }
        });

        // The last thing we do is set the content panel and some frame specifics
        mainFrame.setContentPane($$$getRootComponent$$$());
        mainFrame.setPreferredSize(windowDimensions);
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void saveToJson() {
        MainWindowBuilder b = new MainWindow.MainWindowBuilder();
        b.setDatabasePath(databasePath);

        b.setSaveOnExit(saveOnExit);
        b.setUseDatabase(useDatabase);

        b.setWindowDimensions(windowDimensions.width, windowDimensions.height);

        File settingsFile = new File("settings.json");
        if (settingsFile.exists() && settingsFile.canWrite()) settingsFile.delete();

        try (FileWriter fw = new FileWriter(settingsFile)) {
            System.out.printf("SAVING: %s%n", b.toString());
            fw.write(b.toString());
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        dataModel.saveToJson();
    }

    /**
     * constructs a MainWindow from a builder object
     *
     * @param b Builder object for mainWindow
     */
    @Override
    public void loadFromJson(MainWindowBuilder b) {

        windowDimensions = b.settings.windowDimensions;

        saveSettingsOnExitCheckBox.setSelected(b.settings.saveOnExit);
        saveOnExit = b.settings.saveOnExit;

        useDatabaseCheckbox.setSelected(b.settings.useDatabase);
        useDatabase = b.settings.useDatabase;

        this.databasePath = b.settings.databasePath;
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
        // Note that this is not the place for NEW components
        // It is only to setup components that have been marked custom
        mainFrame = new JFrame("Search UI");
        searchFilesChooser = new JFileChooser();

        openFilesTableModel = makeTableModel(dataModel.getOpenFiles());
        openFilesTable = new JTable(openFilesTableModel);

        // This is just test data so the table shows up
        // everything here is subject to change
        String[] columnNames = {"File",
                "Line Number"};

        Object[][] data = {
                {"testdata1.txt", "23"},
                {"testdata4.txt", "107"},
                {"testdata5.txt", "8"},
                {"testdata11.txt", "34"},
                {"testdata15.txt", "20"}
        };

        resultsTable = new JTable(data, columnNames);
    }

    /**
     * Makes a sutible DefaultTableModel for a JTable from a Map
     *
     * @param files A list containing path's to files
     * @return
     */
    private DefaultTableModel makeTableModel(List<String> files) {
        DefaultTableModel model = new DefaultTableModel(
                new Object[]{"File Name", "Last Modified"}, 0
        );
        for (String s : files) {
            File f = new File(s);
            if (f.exists())
                model.addRow(new Object[]{f.getName(), f.lastModified()});
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
        searchPanel = new JPanel();
        searchPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        topPanel.add(searchPanel, BorderLayout.NORTH);
        searchPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), null));
        final JLabel label1 = new JLabel();
        label1.setText("Search ");
        searchPanel.add(label1);
        searchTextField = new JTextField();
        searchTextField.setColumns(20);
        searchPanel.add(searchTextField);
        searchButton = new JButton();
        searchButton.setText("Go");
        searchPanel.add(searchButton);
        searchComboBox = new JComboBox();
        final DefaultComboBoxModel defaultComboBoxModel1 = new DefaultComboBoxModel();
        defaultComboBoxModel1.addElement("OR");
        defaultComboBoxModel1.addElement("AND");
        defaultComboBoxModel1.addElement("PHRASE");
        searchComboBox.setModel(defaultComboBoxModel1);
        searchPanel.add(searchComboBox);
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(0, 0));
        topPanel.add(mainPanel, BorderLayout.CENTER);
        tabbedPane1 = new JTabbedPane();
        mainPanel.add(tabbedPane1, BorderLayout.CENTER);
        resultsPanel = new JPanel();
        resultsPanel.setLayout(new BorderLayout(0, 0));
        tabbedPane1.addTab("Search Results", resultsPanel);
        final JScrollPane scrollPane1 = new JScrollPane();
        resultsPanel.add(scrollPane1, BorderLayout.CENTER);
        resultsTable.putClientProperty("Table.isFileList", Boolean.FALSE);
        scrollPane1.setViewportView(resultsTable);
        filesListPanel = new JPanel();
        filesListPanel.setLayout(new BorderLayout(0, 0));
        tabbedPane1.addTab("Indexed Files", filesListPanel);
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new BorderLayout(0, 0));
        filesListPanel.add(panel1, BorderLayout.NORTH);
        chooseFilesButton = new JButton();
        chooseFilesButton.setText("Choose Files...");
        panel1.add(chooseFilesButton, BorderLayout.CENTER);
        importListButton = new JButton();
        importListButton.setText("Import...");
        panel1.add(importListButton, BorderLayout.EAST);
        removeSelectedFileButton = new JButton();
        removeSelectedFileButton.setHorizontalAlignment(0);
        removeSelectedFileButton.setText("Remove Selected File");
        filesListPanel.add(removeSelectedFileButton, BorderLayout.SOUTH);
        final JScrollPane scrollPane2 = new JScrollPane();
        filesListPanel.add(scrollPane2, BorderLayout.CENTER);
        scrollPane2.setViewportView(openFilesTable);
        settingsPagePanel = new JPanel();
        settingsPagePanel.setLayout(new GridBagLayout());
        tabbedPane1.addTab("Settings", settingsPagePanel);
        final JLabel label2 = new JLabel();
        label2.setText("Database path");
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        settingsPagePanel.add(label2, gbc);
        selectDBButton = new JButton();
        selectDBButton.setText("Select DB");
        gbc = new GridBagConstraints();
        gbc.gridx = 5;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        settingsPagePanel.add(selectDBButton, gbc);
        final JPanel spacer1 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.VERTICAL;
        settingsPagePanel.add(spacer1, gbc);
        aboutButton = new JButton();
        aboutButton.setText("About...");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        settingsPagePanel.add(aboutButton, gbc);
        databaseFileTextField = new JTextField();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        settingsPagePanel.add(databaseFileTextField, gbc);
        final JPanel spacer2 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.VERTICAL;
        settingsPagePanel.add(spacer2, gbc);
        useDatabaseCheckbox = new JCheckBox();
        useDatabaseCheckbox.setText("Use database for indexes");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        settingsPagePanel.add(useDatabaseCheckbox, gbc);
        saveSettingsOnExitCheckBox = new JCheckBox();
        saveSettingsOnExitCheckBox.setText("Save settings on exit");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        settingsPagePanel.add(saveSettingsOnExitCheckBox, gbc);
        toolbarPanel = new JPanel();
        toolbarPanel.setLayout(new BorderLayout(0, 0));
        topPanel.add(toolbarPanel, BorderLayout.SOUTH);
        final JToolBar toolBar1 = new JToolBar();
        toolbarPanel.add(toolBar1, BorderLayout.CENTER);
        adminPageButton = new JButton();
        adminPageButton.setText("Admin");
        toolBar1.add(adminPageButton);
        progressBar1 = new JProgressBar();
        toolBar1.add(progressBar1);
        label1.setLabelFor(searchTextField);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return topPanel;
    }


    /**
     * Builder for MainWindow
     */
    public static class MainWindowBuilder implements IBuildable<MainWindow, MainWindowBuilder> {

        MainWindowSettings settings = new MainWindowSettings();

        public MainWindowBuilder() {
            settings.windowDimensions = new Dimension(500, 650);
            settings.saveOnExit = false;
            settings.useDatabase = false;
            settings.databasePath = "";
        }

        /**
         * set the path that the database will be located at
         *
         * @param path
         * @return
         */
        public MainWindowBuilder
        setDatabasePath(String path) {
            settings.databasePath = path;
            return this;
        }

        /**
         * true or false if we should use a database
         *
         * @param b
         * @return
         */
        public MainWindowBuilder
        setUseDatabase(boolean b) {
            settings.useDatabase = b;
            return this;
        }

        /**
         * true or false if we should save when exiting
         *
         * @param b
         * @return
         */
        public MainWindowBuilder
        setSaveOnExit(boolean b) {
            settings.saveOnExit = b;
            return this;
        }

        /**
         * @param width  X value of dimension
         * @param height Y value of dimension
         * @return
         */
        public MainWindowBuilder
        setWindowDimensions(int width, int height) {
            settings.windowDimensions.setSize(width, height);
            return this;
        }

        /**
         * Terminates the builder and returns a configured MainWindow
         *
         * @return MainWindow
         */
        public MainWindow
        build() {
            FileReader fr = null;
            SearchUIModel dm = null;
            try {
                fr = new FileReader("model.json");
                dm = new SearchUIModel.SearchUIModelBuilder().makeFromJson(fr).build();
            } catch (FileNotFoundException e) {
                dm = new SearchUIModel.SearchUIModelBuilder().build();
            }

            return new MainWindow(this, dm);
        }

        /**
         * Method to use JSON input to construct a builder
         *
         * @param fr a FileReader to a settings.json file for this builder object
         * @return
         */
        public MainWindowBuilder
        makeFromJson(FileReader fr) {
            Gson gson = new Gson();
            settings = gson.fromJson(fr, MainWindowSettings.class);
            return this;
        }

        /**
         * @return JSON string of configurable settings
         */
        @Override
        public String toString() {
            Gson gson = new Gson();
            return gson.toJson(settings);
        }

        private class MainWindowSettings {
            Dimension windowDimensions;
            boolean saveOnExit;
            boolean useDatabase;
            String databasePath;
        }

    }

}
