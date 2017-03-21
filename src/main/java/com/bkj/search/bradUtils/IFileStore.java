package com.bkj.search.bradUtils;

import java.util.*;

/**
 * Created by bclaus on 3/8/17.
 */
public interface IFileStore {
    List<String> getOpenFiles();

    List<FileInvertedIndex> getIndexedFiles();

    void setIndexedFiles(List<FileInvertedIndex> indexedFiles);

    void addIndexedFile(FileInvertedIndex fii);

    void removeIndexedFile(int i);
}
