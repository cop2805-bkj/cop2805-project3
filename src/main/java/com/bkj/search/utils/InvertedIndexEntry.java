package com.bkj.search.utils;

import java.io.File;

/**
 * Created by bclaus on 3/6/17.
 */
public class InvertedIndexEntry implements IInvertedIndexEntry {
    private final String fileName;
    private final long lineNumber;


    public InvertedIndexEntry(File file, long lineNumber){
        this.fileName = file.toString();
        this.lineNumber = lineNumber;
        File f = new File(fileName);
    }

    public InvertedIndexEntry(String filePath, long lineNumber) {
        this(new File(filePath), lineNumber);
    }

    @Override
    public String getFilePath() {
        return fileName;
    }

    @Override
    public long getLineNumber() {
        return lineNumber;
    }

}
