package com.bkj.search.bradSearch;

import com.bkj.search.bradUtils.IFileInvertedIndex;
import com.bkj.search.bradUtils.IInvertedIndexEntry;

import java.util.List;


public interface SearchableFileIndex {

    enum SEARCH_TYPE {
        OR,
        AND,
        PHRASE
    }

    boolean containsTerm(String searchTerm);
    IInvertedIndexEntry getFirstResult(String term, SEARCH_TYPE type);
    List<IInvertedIndexEntry> getAllResults(String term, SEARCH_TYPE type);

}
