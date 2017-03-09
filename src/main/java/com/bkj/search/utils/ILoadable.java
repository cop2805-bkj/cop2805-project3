package com.bkj.search.utils;

import com.bkj.search.gui.MainWindow;

/**
 * Created by bclaus on 3/8/17.
 */
public interface ILoadable<C> {
    void loadFromJson(C b);
}
