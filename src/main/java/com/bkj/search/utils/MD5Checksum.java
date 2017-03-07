package com.bkj.search.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Provides a wrapper around generating MD5 sums from files
 */
public class MD5Checksum {
    private String MD5Sum;
    private String path;

    MD5Checksum(String filePath) {
        this(new File(filePath));
    }

    MD5Checksum(File f) {
        if(f.exists() && f.canRead()) {
            MD5Sum = getCheckSum(f);
        } else {
            MD5Sum = "NULL";
        }
        path = f.toString();
    }

    /**
     * This method should be used when you don't care about storing the result
     * @param f File object for a file to generate a checksum
     * @return String containing the MD5 checksum of the file
     */
    public static String getCheckSum(File f) {
        String MD5Sum = null;
        try (FileInputStream fis = new FileInputStream(f))
        {
            MD5Sum = org.apache.commons.codec.digest.DigestUtils.md5Hex(fis);

        } catch (FileNotFoundException e) {
            System.out.printf("Could not find file %s\n", f.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (MD5Sum == null) {
                MD5Sum = "NULL";
            }
        }

        return MD5Sum;
    }

    public String get() { return MD5Sum; }

    @Override
    public String toString() {
        return path + " -> " + MD5Sum;
    }
}
