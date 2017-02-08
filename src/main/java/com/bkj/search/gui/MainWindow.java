package com.bkj.search.gui;

import javax.swing.*;
import java.awt.*;

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
        searchPane.add(querySearchButton);

        // Display Window
        mainPane.add(searchPane);

        mainPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(mainPane);
    }

    @Override
    public void run() {
        showInterface();
    }

    private void showInterface() {

        frame.setVisible(true);
    }
}