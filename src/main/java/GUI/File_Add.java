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
    
    public String pathName() {
        String pathNameReturn = " ";
        pathNameReturn = pathName.trim();
        return pathNameReturn;
    }
    
    @Override
    public void run() {
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new java.io.File("Users"));
        chooser.setDialogTitle("choosertitle");
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        chooser.setAcceptAllFileFilterUsed(false);

        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            File file;
            file = chooser.getSelectedFile();
            pathName = file.toString();
            System.out.println(pathName);
            //Files_UI.filesTextArea.append(pathName + "\n");
        } else if (chooser.showOpenDialog(null) == JFileChooser.ERROR_OPTION){
            JOptionPane.showMessageDialog(null,"ALERT MESSAGE","TITLE",JOptionPane.WARNING_MESSAGE);
        }
    }
}
