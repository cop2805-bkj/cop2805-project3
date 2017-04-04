package com.bkj.search.bradUtils;

import com.bkj.search.bradSearch.SearchableFileIndex;

import java.io.*;
import java.util.*;

import static com.bkj.search.bradUtils.IMD5Checksum.getCheckSum;

/**
 * @see InvertedIndexEntry
 */
public class FileInvertedIndex implements IFileInvertedIndex, SearchableFileIndex {

    public List<Pair<String, InvertedIndexEntry>> invertedIndex;
    private File fileBacking;
    private int docid;
    private String MD5Sum;
    private Date lastModified;

    public FileInvertedIndex(String file, int docid) throws IOException {
        fileBacking = new File(file);
        invertedIndex = new ArrayList<>();
        this.docid = docid;

        if(fileBacking.exists()) {
            MD5Sum = getCheckSum(fileBacking);
            lastModified = new Date(fileBacking.lastModified());
        } else {
            throw new FileNotFoundException();
        }

    }

    @Override
    public String getFilePathString() {
        return fileBacking.toString();
    }
    @Override
    public String getFileName() { return fileBacking.getName(); }

    /**
     * rebuilds the Inverted Index from scratch
     *
     */
    @Override
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
                // Regex search for any letter (a-z) and (A-Z) -> replace everything that is not that with nothing.
                // effectivly removing all symbols from the text (! ? , ; ( ) etc...)
                line.replaceAll("[^a-zA-Z0-9 ]", "");

                // store everything as lower case
                line.toLowerCase();
                for(String word : line.split(" ")){
                    invertedIndex.add(new Pair<>(word, new InvertedIndexEntry(docid, lineCounter)));
                }
                lineCounter++;
            }
            //System.out.printf("Index for %s contains %d entries\n",fileBacking.toString(),invertedIndex.size());
        } catch (IOException e) {
            throw e;
        }
    }

    // TODO: Change MD5 checksuming for equals method -> will not work with MD5
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
    @Override
    @Deprecated
    public List<Pair<String, InvertedIndexEntry>>
    getSet(){
        return invertedIndex;
    }

    @Override
    public String getMD5Sum() {
        return MD5Sum;
    }

    @Override
    public Date getLastModified() {
        return lastModified;
    }

    @Override
    public boolean containsTerm(String term) {
        boolean found = false;
        for(Pair<String, InvertedIndexEntry> p : invertedIndex ) {
            if(p.key == term) {
                found = true;
                break;
            }
        }
        return found;
    }

    @Override
    public IInvertedIndexEntry getFirstResult(String term, SEARCH_TYPE type) {
        return null;
    }

    @Override
    public List<IInvertedIndexEntry> getAllResults(String term, SEARCH_TYPE type) {
        // linked list for fast inserts (at least for head inserts)
        List<IInvertedIndexEntry> matchingEntries = new LinkedList<>();

        for(Pair<String, InvertedIndexEntry> p : invertedIndex) {
            if(p.key == term) matchingEntries.add(p.value);
        }
        return matchingEntries;

    }
}
