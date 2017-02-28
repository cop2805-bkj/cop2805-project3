package com.bkj.search.gui;

import javax.swing.*;
import java.awt.*;
import java.io.File;

/**
 * @see Runnable
 * @since 0.1
 */
public class MainWindow implements Runnable {
    private JPanel topPanel;
    private JButton searchButton;
    private JTextField searchTextField;
    private JTabbedPane tabbedPane1;
    private JTable resultsTable;
    private JProgressBar progressBar1;
    private JButton chooseFilesButton;
    private JList<String> searchFilesList;
    private JButton removeSelectedFileButton;
    private JButton selectDBButton;
    private JButton aboutButton;
    private JTextField databaseFileTextField;
    private JCheckBox saveDatabaseCheckbox;
    private JButton adminPageButton;
    private JComboBox searchComboBox;
    private JPanel searchPanel;
    private JPanel mainPanel;
    private JPanel toolbarPanel;
    private JPanel resultsPanel;
    private JPanel filesListPanel;
    private JPanel settingsPagePanel;
    private JCheckBox checkBox3;

    private DefaultListModel<String> listModel;
    private JFileChooser searchFilesChooser;
    private JFrame mainFrame;

    /*
        Settable settings.
            Window dimensions
            Open Files
            (T/F) should we save?
            where is the database located
     */

    private Dimension windowDimensions;
    private boolean saveOnExit;
    private boolean useDatabase;
    private String databasePath;

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
        defaultComboBoxModel1.addElement("AND");
        defaultComboBoxModel1.addElement("OR");
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
        tabbedPane1.addTab("Files", filesListPanel);
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new BorderLayout(0, 0));
        filesListPanel.add(panel1, BorderLayout.NORTH);
        chooseFilesButton = new JButton();
        chooseFilesButton.setText("Choose Files...");
        panel1.add(chooseFilesButton, BorderLayout.CENTER);
        filesListPanel.add(searchFilesList, BorderLayout.CENTER);
        removeSelectedFileButton = new JButton();
        removeSelectedFileButton.setHorizontalAlignment(0);
        removeSelectedFileButton.setText("Remove Selected File");
        filesListPanel.add(removeSelectedFileButton, BorderLayout.SOUTH);
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
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.VERTICAL;
        settingsPagePanel.add(spacer1, gbc);
        aboutButton = new JButton();
        aboutButton.setText("About...");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 4;
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
        saveDatabaseCheckbox = new JCheckBox();
        saveDatabaseCheckbox.setText("Save database to disk");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        settingsPagePanel.add(saveDatabaseCheckbox, gbc);
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
    public static class MainWindowBuilder {
        private DefaultListModel<String> listModel;
        private Dimension windowDimensions;
        private boolean saveOnExit;
        private boolean useDatabase;
        private String databasePath;

        public MainWindowBuilder() {
            listModel = new DefaultListModel<>();
            windowDimensions = new Dimension(600, 600);
            saveOnExit = false;
            useDatabase = false;
            databasePath = "";
        }

        public MainWindowBuilder
        setDatabasePath(String path) {
            databasePath = path;
            return this;
        }

        public MainWindowBuilder
        setUseDatabase(boolean b) {
            useDatabase = b;
            return this;
        }

        public MainWindowBuilder
        setSaveOnExit(boolean b) {
            saveOnExit = b;
            return this;
        }

        public MainWindowBuilder
        setWindowDimensions(int width, int height) {
            windowDimensions.setSize(width, height);
            return this;
        }

        public MainWindowBuilder
        setOpenFiles(String[] files) {
            for (String f : files) {
                listModel.addElement(f);
            }
            return this;
        }

        public MainWindow
        build() {
            return new MainWindow(this);
        }

    }

    /**
     * creates a new main window frame along with content
     * <p>
     * Calls IntelliJ 'entry point' $$$setupUI$$$() and creates actionEvents for buttons
     * UI components
     * </p>
     */
    private MainWindow(MainWindowBuilder builder) {
        $$$setupUI$$$(); // This must be first

        searchButton.addActionListener(actionEvent -> {
            NotImplementedDialog d = new NotImplementedDialog("Not Implemented", "Searching does not work yet");
        });

        selectDBButton.addActionListener(actionEvent -> {
            NotImplementedDialog d = new NotImplementedDialog("Not Implemented", "Database path does not work yet");
        });

        aboutButton.addActionListener(actionEvent -> SwingUtilities.invokeLater(new AboutDialog()));

        chooseFilesButton.addActionListener(actionEvent -> {
            int fcRetVal = searchFilesChooser.showOpenDialog(topPanel);
            if (fcRetVal == JFileChooser.APPROVE_OPTION) {
                File file = searchFilesChooser.getSelectedFile();
                //This is where a real application would open the file.
                // TODO: Handle multiple files and recursive searching by selecting directories
                listModel.addElement(file.toPath().toString());
            }
        });

        // Removes selected file in file list
        removeSelectedFileButton.addActionListener(actionEvent -> {
            try {
                listModel.remove(searchFilesList.getSelectedIndex());
            } catch (ArrayIndexOutOfBoundsException aie) {
                NotImplementedDialog d = new NotImplementedDialog("Whoops!", "Select a file to remove");
            }
        });

        // Opens Admin Page
        adminPageButton.addActionListener(actionEvent -> {
            AdministrationWindow win = new AdministrationWindow();
            SwingUtilities.invokeLater(win);
        });


        // The last thing we do is set the content panel and some frame specifics
        // TODO: should we check the return value of $$$getRootComponent$$$() for NULL?
        mainFrame.setContentPane($$$getRootComponent$$$());
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setPreferredSize(windowDimensions);


    }

    /**
     * constructs a MainWindow from a builder object
     *
     * @param b Builder object for mainWindow
     */
    private void constructMainWindow(MainWindowBuilder b) {
        this.windowDimensions = b.windowDimensions;
        this.listModel = b.listModel;
        this.saveOnExit = b.saveOnExit;
        this.useDatabase = b.useDatabase;
        this.databasePath = b.databasePath;
    }

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
     * For UI components marked 'Custom Create'
     * <p>
     * Intellij generates the $$$setupUI$$$() method and calls createUIComponents()
     * this allows greater control over how objects are made instead of the default
     * parameter-less constructor
     * </p>
     */
    private void createUIComponents() {
        mainFrame = new JFrame("Search UI");
        searchFilesChooser = new JFileChooser();

        // TODO: place custom component creation code here
        // Note that this is not the place for NEW components
        // It is only to setup components that have been marked custom

        listModel = new DefaultListModel<String>();
        searchFilesList = new JList<>(listModel);


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

}
