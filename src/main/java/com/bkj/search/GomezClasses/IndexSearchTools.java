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

import java.util.ArrayList;
import java.util.TreeMap;

/**
 * This class will be used to build the OR, AND, and Phrase search functions.
 * @author Kelvin
 */
public class IndexSearchTools {
    private final ArrayList<Integer> results = new ArrayList<>();
    /**
     * Returns ArrayList of integers. These values represent the index location
     * of the words within the TreeMap that has the files indexed.
     * @param index
     * @param arg
     * @return 
     */
    public ArrayList searchOR(TreeMap<Integer, ArrayList<String>> index, String arg){
        results.removeAll(results);
        for(int key = 0; key < index.size(); key++){
            if(index.get(key).contains(arg)){
                results.add(key);
            }
        }
        return results;
    }
}
