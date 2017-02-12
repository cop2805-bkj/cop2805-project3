package com.bkj.search.gui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by bclaus on 2/12/17.
 */
public class MainWindowFrame implements Runnable {
    private MainWindow windowContents;
    private JFrame mainFrame;

    public MainWindowFrame() {
        windowContents = new MainWindow();
        mainFrame = new JFrame("Search UI");
    }

    @Override
    public void run() {
        mainFrame.setContentPane(windowContents.$$$getRootComponent$$$());
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setPreferredSize(new Dimension(500,500));
        mainFrame.pack();
        mainFrame.setVisible(true);
    }
}
