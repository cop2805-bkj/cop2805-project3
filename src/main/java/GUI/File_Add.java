package GUI;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Jonathan Llaneras
 */
public abstract class File_Add implements Runnable {
    
    static String pathName = " ";
    
    // Returns string pathName for Files_UI
    public String pathName() {
        String pathNameReturn = " ";
        pathNameReturn = pathName.trim();
        return pathNameReturn;
    }
    
    // Creates a JFileChooser and puts the file into a string variable
    @Override
    public void run() {
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new java.io.File("Users"));
        chooser.setDialogTitle("choosertitle");
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        chooser.setAcceptAllFileFilterUsed(false);

        // Approves or unapproves file type
        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            File file;
            file = chooser.getSelectedFile();
            pathName = file.toString();
        } else if (chooser.showOpenDialog(null) == JFileChooser.ERROR_OPTION){
            JOptionPane.showMessageDialog(null,"File not compatible","File Error",JOptionPane.WARNING_MESSAGE);
        }
    }
}
