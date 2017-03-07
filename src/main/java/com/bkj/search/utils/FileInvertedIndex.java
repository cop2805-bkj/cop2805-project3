package com.bkj.search.utils;

import java.io.*;
import java.util.*;

/**
 * @see InvertedIndexEntry
 */
public class FileInvertedIndex {
    public List<Pair<String, InvertedIndexEntry>> invertedIndex;
    private File fileBacking;
    private String MD5Sum;
    private Date lastModified;

    public FileInvertedIndex(String file) throws FileNotFoundException {
        fileBacking = new File(file);
        invertedIndex = new ArrayList<>();
        if(fileBacking.exists()) {
            MD5Sum = MD5Checksum.getCheckSum(fileBacking);
            lastModified = new Date(fileBacking.lastModified());
        } else {
            throw new FileNotFoundException();
        }

    }

    public String getFilePathString() {
        return fileBacking.toString();
    }
    public String getFileName() { return fileBacking.getName(); }

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

    @Override
    public boolean equals(Object o) {
        // if they are exactly the same object then they are equal
        if (this == o) return true;

        // if the object passed in is null or not the same class as this
        // then it is impossible for them to be equal
        if (o == null || getClass() != o.getClass()) return false;

        // while MD5 is not cryptographically secure, it provides us with a reasonable
        // way to detect file changes or detect identical files
        // Hash collisions are not a concern due to the fact we are using MD5 for checksuming
        // and due to the speed of the MD5 algorithim compared to alternatives (SHA1/SHA256 etc)
        FileInvertedIndex that = (FileInvertedIndex) o;
        return Objects.equals(getMD5Sum(), that.getMD5Sum());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMD5Sum());
    }

    // This is here if it is required to retrieve the set
    // Don't use this please
    @Deprecated
    public List<Pair<String, InvertedIndexEntry>>
    getSet(){
        return invertedIndex;
    }

    public String getMD5Sum() {
        return MD5Sum;
    }

    public Date getLastModified() {
        return lastModified;
    }
}
