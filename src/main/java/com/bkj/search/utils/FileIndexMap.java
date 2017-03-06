package com.bkj.search.utils;

import java.io.*;
import java.util.*;

/**
 * @see IndexEntry
 */
public class FileIndexMap {
    List<Pair<String, IndexEntry>> invertedIndex;
    private File fileBacking;

    public FileIndexMap(String file) {
        fileBacking = new File(file);
        invertedIndex = new ArrayList<>();
    }

    /**
     * rebuilds the Inverted Index from scratch
     * @return True if successful, false if the method fails to rebuild the index
     */
    public boolean
    rebuildIndex() {
        try (BufferedReader br = new BufferedReader(new FileReader(fileBacking))) {
            List<String> strings = new LinkedList<>();
            while(br.ready()) {
                strings.add(br.readLine());
            }

            long lineCounter = 0;
            for(String line: strings) {
                line.replaceAll("[^a-zA-Z ]", "");
                line.toLowerCase();
                for(String word : line.split(" ")){
                    invertedIndex.add(new Pair<>(word, new IndexEntry(fileBacking, lineCounter)));
                }
                lineCounter++;
            }
        } catch (IOException e) {
            return false;
        }
        return true;
    }

    public boolean
    containsTerm(String searchString) {
        boolean found = false;
        for(Pair<String, IndexEntry> p : invertedIndex ) {
            if(p.key == searchString) {
                found = true;
                break;
            }
        }
        return found;
    }

    public List<IndexEntry>
    getOccurrences(String searchString) {
        // linked list for fast inserts (at least for head inserts)
        List<IndexEntry> matchingEntries = new LinkedList<>();

        for(Pair<String, IndexEntry> p : invertedIndex) {
            if(p.key == searchString) {
                matchingEntries.add(p.value);
            }
        }
        return matchingEntries;
    }

    // This is here if it is required to retrieve the set
    @Deprecated
    public List<Pair<String, IndexEntry>>
    getSet(){
        return invertedIndex;
    }
}
