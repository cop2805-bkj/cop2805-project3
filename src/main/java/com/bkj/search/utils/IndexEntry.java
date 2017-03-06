package com.bkj.search.utils;

import java.io.File;
import java.util.Date;

/**
 * Created by bclaus on 3/6/17.
 */
public class IndexEntry {
    private final String filePath;
    private final long lineNumber;
    private String MD5Sum;
    private Date lastModified;

    public IndexEntry(File file, long lineNumber){
        this.filePath = file.toString();
        this.lineNumber = lineNumber;
        File f = new File(filePath);
        MD5Sum = MD5Checksum.getCheckSum(f);
        lastModified = new Date(f.lastModified());
    }

    public IndexEntry(String filePath, long lineNumber) {
        this(new File(filePath), lineNumber);
    }

    public String getFilePath() {
        return filePath;
    }

    public long getLineNumber() {
        return lineNumber;
    }

    public String getMD5Sum() {
        return MD5Sum;
    }

    public Date getLastModified() { return lastModified; }
}
