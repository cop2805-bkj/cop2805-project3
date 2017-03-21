package com.bkj.search.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Provides a wrapper around generating MD5 sums from files
 */
public class MD5Checksum implements IMD5Checksum {
    private String MD5Sum;
    private String path;

    MD5Checksum(String filePath) throws IOException {
        this(new File(filePath));
    }

    MD5Checksum(File f) throws IOException {
        if(f.exists() && f.canRead()) {
            MD5Sum = IMD5Checksum.getCheckSum(f);
        } else {
            MD5Sum = "NULL";
        }
        path = f.toString();
    }

    @Override
    public String get() { return MD5Sum; }

    @Override
    public String toString() {
        return path + " -> " + MD5Sum;
    }
}
