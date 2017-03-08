package com.bkj.search.utils;

import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * Created by bclaus on 3/8/17.
 */
public interface IFileInvertedIndex {
    String getFilePathString();

    String getFileName();

    /**
     * rebuilds the Inverted Index from scratch
     * @return True if successful, false if the method fails to rebuild the index
     */
    void
    rebuildIndex() throws IOException;

    /**
     * Searches file for the first occurrence(!) of searchString
     * @param searchString string to search for
     * @return true if found
     */
    boolean
    containsTerm(String searchString);

    /**
     * Returns *all* occurrences of search string
     * @param searchString
     * @return
     */
    List<InvertedIndexEntry>
    getOccurrences(String searchString);

    // TODO: Change MD5 checksuming for equals method -> will not work with MD5
    @Override
    boolean equals(Object o);

    @Override
    int hashCode();

    // This is here if it is required to retrieve the set
    // Don't use this please
    @Deprecated
    List<Pair<String, InvertedIndexEntry>>
    getSet();

    String getMD5Sum();

    Date getLastModified();
}
