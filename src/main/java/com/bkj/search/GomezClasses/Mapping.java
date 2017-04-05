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
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;
/**
 * This Class has all the indexing tools
 * @author Kelvin
 */
public class Mapping{
    public final TreeMap<Integer, ArrayList<String>> map = new TreeMap<>();
    private Scanner reader;
    private String word;
    /**
     * Stores every word in each file into the TreeMap
     * @param files
     * @throws IOException 
     */
    public void map(ArrayList<String> files) throws IOException{
        for(int i = 0; i < files.size(); i++){
                ArrayList<String> list =  new ArrayList<>();
                try{
                    reader = new Scanner(new FileReader(files.get(i)));
                }catch(FileNotFoundException e){
                    System.err.println(e);
                    return;
                }
                while(reader.hasNext()){
                    word = reader.next();
                    word = word.toLowerCase();
                    word = word.replaceAll("[^a-zA-Z0-9\\s]", "");
                    list.add(word);
                }
                map.put(i, list);
        }        
    }
}
