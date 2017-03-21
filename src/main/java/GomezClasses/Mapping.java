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
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;
/**
 *
 * @author Kelvin
 */
public class Mapping {
    private int file;
    private Scanner reader;
    private TreeMap<String, TreeMap<Integer,Integer>> tmap;
    /**
     * Populates the TreeMap from the passed in file list.
     * @param fileList 
     * @throws java.io.FileNotFoundException 
     */
    public void add(ArrayList fileList) throws FileNotFoundException{
//        String[] files;
//        files = (String[]) fileList.toArray();
        String file;
        for(int index = 0; index < fileList.size(); index++){
            file = fileList.get(index).toString();
            reader = new Scanner(new File(file));
            Scanner in = new Scanner(reader.nextLine());
            while(in.hasNext()){
                String inputText = in.next();
                String[] words = inputText.split("[ \n\t\r,.;:!?*--+(){}}]");
                for(int i = 0; i < words.length; i++){
                    String key = words[i].toLowerCase();                  
                    if(words[i].length() > 1){
                        if(tmap.get(key) == null){
                            tmap.put(key, new TreeMap<>());
                            tmap.get(key).put(index,1);
                        }
                        else{
                            int value = tmap.get(key).get(file);
                            value = value + 1;
                            tmap.get(key).put(index, value);
                        }
                    }
                }
            }
        }
    }
}
