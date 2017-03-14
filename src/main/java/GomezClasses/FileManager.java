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
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.*;
/**
 * This class holds the adding files logic.
 * @author Kelvin
 */
public class FileManager {
    /**
     * Allows for search and selection of file and
     * returns the pathname as a string
     * @return 
     */
    public String getPathStr(){
        JFileChooser chooser = new JFileChooser();
        File file;
        String str = ".";
        
	chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int results = chooser.showOpenDialog(chooser);
       	if(results == JFileChooser.APPROVE_OPTION){
            file = chooser.getSelectedFile();
            str = file.toPath().toString();
        }
	return str;
    }
    /**
     * Writes the pathname of the selected file to the embedded text file.
     * @param str
     * @throws IOException 
     */
    public void writeToFile(String str)throws IOException {
        File file = new File("InFile.txt");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            writer.write(str);
            writer.newLine();
            writer.flush();
            writer.close();
        }
    }  
}
