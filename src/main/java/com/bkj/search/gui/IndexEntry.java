package com.bkj.search.gui;

/**
 * Created by bclaus on 3/6/17.
 */
public class IndexEntry {
    private final String data;
    private final int docID;
    private final long lineNumber;

    public IndexEntry(String data, int docID, long lineNumber) {
        this.data = data;
        this.docID = docID;
        this.lineNumber = lineNumber;
    }

    public String getData() {
        return data;
    }

    public int getDocID() {
        return docID;
    }

    public long getLineNumber() {
        return lineNumber;
    }
}
