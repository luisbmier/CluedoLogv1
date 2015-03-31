package com.ulpgc.luisbmier.android.cluedolog.controller;

import android.support.v4.app.Fragment;

public class ListActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new GameListFragment();
    }
}