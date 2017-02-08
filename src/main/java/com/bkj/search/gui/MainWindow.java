package com.bkj.search.gui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by bclaus on 2/7/17.
 */

public class MainWindow implements Runnable {

    public MainWindow() {

    }

    @Override
    public void run() {
        showInterface();
    }

    private void showInterface() {
        JFrame frame = new JFrame("SearchUI");
        JPanel mainPane = new JPanel(new BorderLayout());
        JPanel searchPane = new JPanel(new FlowLayout());
        JPanel resultsPane = new JPanel(new FlowLayout());

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(new Rectangle(640,480));

        JLabel label_hw = new JLabel("Search: ");
        JTextField textBox = new JTextField(20);
        searchPane.add(label_hw);
        searchPane.add(textBox);

        // Display Window
        mainPane.add(searchPane);

        mainPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(mainPane);
        frame.setVisible(true);
    }
}