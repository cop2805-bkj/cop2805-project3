package com.bkj.search.gui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by bclaus on 2/12/17.
 */
public class MainWindowFrame implements Runnable {
    private MainWindow windowContents;
    private JFrame mainFrame;
    
    // Creating JFrame
    public MainWindowFrame() {
        windowContents = new MainWindow();
        mainFrame = new JFrame("Search UI");
    }
    // Runs JFrame
    @Override
    public void run() {
        mainFrame.setContentPane(windowContents.$$$getRootComponent$$$());
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setPreferredSize(new Dimension(600,600));
        mainFrame.pack();
        mainFrame.setVisible(true);
    }
}
