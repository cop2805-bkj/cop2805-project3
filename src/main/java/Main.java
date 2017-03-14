/*
 * This version of the project contains my approach for the Search Engine 
 * project. Anything that is useful will be integrated into the main project.
 * This is not to be used as the main project submission. -Kelvin
 */

/**
 *
 * @author Kelvin
 */
import GomezGUI.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JOptionPane;
public class Main {
    public static void main(String[] args) throws IOException{
        MainInterface loadingData = new MainInterface();
        try{
            loadingData.Load();
        }catch(FileNotFoundException e){
            JOptionPane.showMessageDialog(null, "Load data not found.");
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainInterface().setVisible(true);
            }
        });    
    }
}
