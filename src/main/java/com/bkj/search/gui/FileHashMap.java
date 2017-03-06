package com.bkj.search.gui;

import java.util.HashMap;

/**
 *
 * @param <K> The key value, most likely you want a string
 * @param <IndexEntry> The value, which will always be a IndexEntry
 *
 * @see IndexEntry
 */
public class FileHashMap<K,IndexEntry>{
    private HashMap<K, IndexEntry> map;

    public FileHashMap() {
        map = new HashMap<>();
    }

    // This is here if it is required to retreive the map
    @Deprecated
    public HashMap<K, IndexEntry> getMap(){
        return map;
    }
}
