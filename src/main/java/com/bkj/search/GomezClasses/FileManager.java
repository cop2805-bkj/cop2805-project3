/*
 * This version of the project contains my approach for the Search Engine 
 * project. Anything that is useful will be integrated into the main project.
 * This is not to be used as the main project submission. -Kelvin
 */
/**
 *
 * @author Kelvin
 */
package com.bkj.search.GomezClasses;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.*;
/**
 * This class holds the adding files logic.
 * @author Kelvin
 */
public class FileManager {
    public String pathname;
    public ArrayList<String> list = new ArrayList<>();
    /**
     * Allows for search and selection of file and
     * returns the pathname as a string. It also
     * appends the string to the ArrayList. 
     * @return 
     */
    public int getPathStr(){
        JFileChooser chooser = new JFileChooser();
        File file;
        String str;
	chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int results = chooser.showOpenDialog(chooser);
       	if(results == JFileChooser.APPROVE_OPTION){
            file = chooser.getSelectedFile();
            str = file.toPath().toString();
            pathname = str;
            list.add(pathname);
        }  
        int opRes;
        if(results == JFileChooser.APPROVE_OPTION){
            opRes = 0;
        }else{
            opRes = 1;
        }
        return opRes;
    }
    /**
     * Writes the pathname of the selected file to the embedded text file ("InFile.txt").
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
    /**
     * Reads data from a file and appends it to the ArrayList.
     * @throws java.io.IOException
     */
    public void readFile() throws IOException{
        try (BufferedReader br = new BufferedReader(new FileReader("InFile.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
               list.add(line);
            }
        }
    }
    /**
     * Reads all data from the ArrayList.
     */
    public void readList(){
        int contents = list.size();
        String str;
        for(int i = 0; i < contents; i++){
            str = list.get(i);
        }
    }
    /**
     * Deletes data from InFile
     * @throws java.io.FileNotFoundException
     */
    public void clearFile() throws FileNotFoundException, IOException{
        File file = new File("InFile.txt");
        file.delete();
        file.createNewFile();
    }
}