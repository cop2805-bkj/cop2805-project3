package com.bkj.search.bradSearch;

import com.bkj.search.bradUtils.IInvertedIndexEntry;
import com.bkj.search.bradUtils.Pair;

import java.util.List;


public interface SearchableFile {
    boolean hasTerm(String searchTerm);
    List<Pair<String, IInvertedIndexEntry>> getTerms(String searchTerm);
}
