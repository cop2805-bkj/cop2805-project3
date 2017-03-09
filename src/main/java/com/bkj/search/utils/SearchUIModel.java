package com.bkj.search.utils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TreeMap;

/**
 * Created by bclaus on 3/8/17.
 */
public class SearchUIModel implements IFileStore {


    @Override
    public TreeMap<String, Date> getOpenFiles() {
        return null;
    }

    @Override
    public ArrayList<FileInvertedIndex> getIndexedFiles() {
        return null;
    }

    @Override
    public void setIndexedFiles(List<FileInvertedIndex> indexedFiles) {

    }

    @Override
    public void addIndexedFile(FileInvertedIndex fii) {

    }

    @Override
    public void removeIndexedFile(int i) {

    }
}
