package com.bkj.search.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by bclaus on 3/8/17.
 */
public interface IMD5Checksum {
    /**
     * This method should be used when you don't care about storing the result
     * @param f File object for a file to generate a checksum
     * @return String containing the MD5 checksum of the file
     */
    static String getCheckSum(File f) throws IOException {
        String MD5Sum = null;
        try (FileInputStream fis = new FileInputStream(f))
        {
            MD5Sum = org.apache.commons.codec.digest.DigestUtils.md5Hex(fis);

        } catch (FileNotFoundException e) {
            throw e;
        } catch (IOException e) {
            throw e;
        } finally {
            if (MD5Sum == null) {
                MD5Sum = "NULL";
            }
        }

        return MD5Sum;
    }

    String get();
}
