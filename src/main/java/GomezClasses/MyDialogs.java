/*
 * This version of the project contains my approach for the Search Engine 
 * project. Anything that is useful will be integrated into the main project.
 * This is not to be used as the main project submission. -Kelvin
 */
/**
 *
 * @author Kelvin
 */
package GomezClasses;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
/**
 * This class holds all my dialog info, and can be
 * edited from here.
 * @author Kelvin
 */
public class MyDialogs {
    /**
     * Shows the About dialog for this application. -Kelvin
     */
    public void showAbout(){   
        JFrame frame = new JFrame();        
        JOptionPane.showMessageDialog(frame,
            "\tSearch Engine Project (Gomez-Version)\n"
            +"Developed by: Bradley Claus, Jonathan Llaners, Kelvin Gomez\n"
            +"COP 2805 (JAVA Advanced).",
            "Search Engine",
            JOptionPane.PLAIN_MESSAGE);
    }
    /**
     * Shows the Temporary Out-of-Service dialog. -Kelvin
     */
    public void showTempOut(){
        JFrame frame = new JFrame(); 
        String message = "Operation not supported at this time.", label = "Warning";
        JOptionPane.showMessageDialog(frame,message,label,
            JOptionPane.PLAIN_MESSAGE);
    }
}