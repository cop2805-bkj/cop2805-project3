package com.bkj.search.utils;

import com.google.gson.Gson;

import java.io.FileReader;

/**
 * Created by bclaus on 3/9/17.
 */
public interface IBuildable<C,T> {
    C build();
    T makeFromJson(FileReader fr);
}
