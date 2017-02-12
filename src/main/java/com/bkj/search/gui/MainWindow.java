package com.bkj.search.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by bclaus on 2/9/17.
 */
public class MainWindow {
    private JPanel mainPane;
    private JButton button1;
    private JTextField textField1;
    private JTabbedPane tabbedPane1;
    private JTable resultsTable;
    private JProgressBar progressBar1;


    public MainWindow() {


        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                NotImplementedDialog dialog = new NotImplementedDialog("Not Implemented", "Searching does not work yet");
            }
        });


    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        mainPane = new JPanel();
        mainPane.setLayout(new BorderLayout(0, 0));
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        mainPane.add(panel1, BorderLayout.NORTH);
        panel1.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), null));
        final JLabel label1 = new JLabel();
        label1.setText("Search ");
        panel1.add(label1);
        textField1 = new JTextField();
        textField1.setColumns(20);
        panel1.add(textField1);
        button1 = new JButton();
        button1.setText("Button");
        panel1.add(button1);
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new BorderLayout(0, 0));
        mainPane.add(panel2, BorderLayout.CENTER);
        tabbedPane1 = new JTabbedPane();
        panel2.add(tabbedPane1, BorderLayout.CENTER);
        final JPanel panel3 = new JPanel();
        panel3.setLayout(new BorderLayout(0, 0));
        tabbedPane1.addTab("Search Results", panel3);
        final JScrollPane scrollPane1 = new JScrollPane();
        panel3.add(scrollPane1, BorderLayout.CENTER);
        resultsTable = new JTable();
        scrollPane1.setViewportView(resultsTable);
        final JPanel panel4 = new JPanel();
        panel4.setLayout(new BorderLayout(0, 0));
        tabbedPane1.addTab("Settings", panel4);
        final JPanel panel5 = new JPanel();
        panel5.setLayout(new BorderLayout(0, 0));
        mainPane.add(panel5, BorderLayout.SOUTH);
        final JToolBar toolBar1 = new JToolBar();
        panel5.add(toolBar1, BorderLayout.CENTER);
        progressBar1 = new JProgressBar();
        toolBar1.add(progressBar1);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return mainPane;
    }
}
