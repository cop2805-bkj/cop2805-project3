package com.bkj.search.utils;

import com.bkj.search.gui.MainWindow;

public interface Loadable<C> {
    void loadFromJson(C b);
}
