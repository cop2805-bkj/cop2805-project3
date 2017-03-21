package GUI;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Jonathan Llaneras
 */
public class File_Add {
    
    public ArrayList<String> list = new ArrayList<>();
    static String pathName = " ";
    
    // Returns string pathName for Files_UI
    public String pathName() {
        @SuppressWarnings("UnusedAssignment")
        String pathNameReturn = " ";
        pathNameReturn = pathName;
        return pathNameReturn;
    }
    
    public void readFile() throws IOException {
        try (
            BufferedReader reader = new BufferedReader(new FileReader("list.txt"))){
            String s;
            while ((s = reader.readLine())!= null) {
                list.add(s);
            }  
        }
    }
    
    public void writeToFile(String s) throws IOException {
         File file = new File("list.txt");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            writer.write(s);
            writer.newLine();
            writer.flush();
            writer.close();
        }
    }
    
    // Creates a JFileChooser and puts the file into a string variable
    public void getFileString() {
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new java.io.File("Users"));
        chooser.setDialogTitle("choosertitle");
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        chooser.setAcceptAllFileFilterUsed(false);

        // Approves or unapproves file type
        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            File file;
            file = chooser.getSelectedFile();
            pathName = file.toPath().toString();
            list.add(pathName);
        } else if (chooser.showOpenDialog(null) == JFileChooser.ERROR_OPTION){
            JOptionPane.showMessageDialog(null,"File not compatible","File Error",JOptionPane.WARNING_MESSAGE);
        }
    }
}
