package com.bkj.search.utils;

import java.io.File;

/**
 * Created by bclaus on 3/6/17.
 */
public class InvertedIndexEntry implements IInvertedIndexEntry {
    private final int docID;
    private final long lineNumber;


    public InvertedIndexEntry(int documentIndex, long lineNumber){
        this.docID = documentIndex;
        this.lineNumber = lineNumber;
    }

    @Override
    public int getDocID() {
        return docID;
    }

    @Override
    public long getLineNumber() {
        return lineNumber;
    }

}
