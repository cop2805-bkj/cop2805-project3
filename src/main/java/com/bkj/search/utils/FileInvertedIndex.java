package com.bkj.search.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/**
 * @see InvertedIndexEntry
 */
public class FileInvertedIndex {
    public List<Pair<String, InvertedIndexEntry>> invertedIndex;
    private File fileBacking;

    public FileInvertedIndex(String file) {
        fileBacking = new File(file);
        invertedIndex = new ArrayList<>();
    }

    public String getFileString() {
        return fileBacking.toString();
    }

    /**
     * rebuilds the Inverted Index from scratch
     * @return True if successful, false if the method fails to rebuild the index
     */
    public void
    rebuildIndex() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(fileBacking))) {
            List<String> strings = new LinkedList<>();
            while(br.ready()) {
                strings.add(br.readLine());
            }
            //System.out.printf("Read %d lines\n", strings.size());
            long lineCounter = 0;
            for(String line: strings) {
                line.replaceAll("[^a-zA-Z ]", "");
                line.toLowerCase();
                for(String word : line.split(" ")){
                    invertedIndex.add(new Pair<>(word, new InvertedIndexEntry(fileBacking, lineCounter)));
                }
                lineCounter++;
            }
        } catch (IOException e) {
            throw e;
        }

        //System.out.printf("Index for %s contains %d entries\n",fileBacking.toString(),invertedIndex.size());
    }

    /**
     * Searches file for the first occurrence(!) of searchString
     * @param searchString string to search for
     * @return true if found
     */
    public boolean
    containsTerm(String searchString) {
        boolean found = false;
        for(Pair<String, InvertedIndexEntry> p : invertedIndex ) {
            if(p.key == searchString) {
                found = true;
                break;
            }
        }
        return found;
    }

    /**
     * Returns *all* occurrences of search string
     * @param searchString
     * @return
     */
    public List<InvertedIndexEntry>
    getOccurrences(String searchString) {
        // linked list for fast inserts (at least for head inserts)
        List<InvertedIndexEntry> matchingEntries = new LinkedList<>();

        for(Pair<String, InvertedIndexEntry> p : invertedIndex) {
            if(p.key == searchString) matchingEntries.add(p.value);
        }
        return matchingEntries;
    }

    // This is here if it is required to retrieve the set
    @Deprecated
    public List<Pair<String, InvertedIndexEntry>>
    getSet(){
        return invertedIndex;
    }
}
