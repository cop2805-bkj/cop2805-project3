package com.bkj.search.gui;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Created by bclaus on 2/7/17.
 */

public class MainWindow implements Runnable {
    // TODO: We should make our own versions of these
    JFrame frame;
    JPanel mainPane, searchPane, resultsPane;
    JLabel searchFieldLabel;
    JTextField queryTextField;
    JButton querySearchButton;

    public MainWindow() {
        frame = new JFrame("SearchUI");
        mainPane = new JPanel(new BorderLayout());
        searchPane = new JPanel(new FlowLayout());
        resultsPane = new JPanel(new FlowLayout());

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(new Rectangle(640,480));

        searchFieldLabel = new JLabel("Query: ");
        searchPane.add(searchFieldLabel);

        queryTextField = new JTextField(20);
        searchPane.add(queryTextField);

        querySearchButton = new JButton("Begin Search");
        querySearchButton.setActionCommand("doQuery");
        querySearchButton.addActionListener(this::handleActionEvent);
        searchPane.add(querySearchButton);

        // Display Window
        mainPane.add(searchPane);

        mainPane.setOpaque(true); //content panes must be opaque
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