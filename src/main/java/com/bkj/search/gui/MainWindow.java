package com.bkj.search.gui;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Created by bclaus on 2/7/17.
 */

public class MainWindow implements Runnable {
    // TODO: We should make our own versions of these
    JFrame frame;
    JPanel mainPane, searchPane;
    JScrollPane resultsPane;
    JLabel searchFieldLabel;
    JTextField queryTextField;
    JTable  resultsTable;
    JButton querySearchButton;

    String[] tableRowNames = {
        "FILE",
        "QUERY",
        "Results",
        "Line #",
    };

    String[][] testData = {
            {"This", "Is", "Test", "Data"},
            {"file001.txt", "foobar", "2", "23,42"},
            {"file003.txt", "foobar", "0", "Not Found"},
            {"file004.txt", "foobar", "1", "1"}
    };

    public MainWindow() {
        frame = new JFrame("SearchUI");
        mainPane = new JPanel(new BorderLayout());
        searchPane = new JPanel(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(500,500));
        // Search Text Field label
        searchFieldLabel = new JLabel("Query: ");
        searchPane.add(searchFieldLabel);

        // Search Text Field
        queryTextField = new JTextField(20);
        searchPane.add(queryTextField);

        // Search Button
        querySearchButton = new JButton("Begin Search");
        querySearchButton.setActionCommand("doQuery");
        querySearchButton.addActionListener(this::handleActionEvent);
        frame.getRootPane().setDefaultButton(querySearchButton);
        searchPane.add(querySearchButton);


        // Results scroll pane + table
        resultsTable = new JTable(testData,tableRowNames);
        resultsPane = new JScrollPane(resultsTable);
        resultsPane.setBorder(BorderFactory.createLoweredSoftBevelBorder());

        // Display Window
        searchPane.setPreferredSize(new Dimension(450,50));
        resultsPane.setPreferredSize(new Dimension(400,400));

        mainPane.add(searchPane, BorderLayout.PAGE_START);
        mainPane.add(resultsPane);

        mainPane.setOpaque(true); //content panes must be opaque
        frame.pack();
        frame.setContentPane(mainPane);
    }

    /* Private Methods */

    private void showInterface() {

        frame.setVisible(true);
    }

    /* Public Methods */

    @Override
    public void run() {
        showInterface();
    }

    public void handleActionEvent(ActionEvent ae){
        String command = ae.getActionCommand();
        System.out.printf("Received %s action event\n", command);

        switch(command) {
            case "doQuery":
                    // TODO: Add business logic into another package
                    // So we would need to read the current state of the queryTextField
                    // we should also think about multithreading issues such as atomics on the textfields
                break;
            default:
                break;
        }

    }
}