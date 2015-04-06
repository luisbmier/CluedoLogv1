package com.ulpgc.luisbmier.android.cluedolog.controller;

import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

public abstract class SingleFragmentActivity extends FragmentActivity {
    protected abstract Fragment createFragment();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.ulpgc.luisbmier.android.cluedolog.R.layout.activity_fragment);
        FragmentManager manager = getSupportFragmentManager();
        Fragment fragment = manager.findFragmentById(com.ulpgc.luisbmier.android.cluedolog.R.id.fragmentContainer);

        if (fragment == null) {
            fragment = createFragment();
            manager.beginTransaction()
                    .add(com.ulpgc.luisbmier.android.cluedolog.R.id.fragmentContainer, fragment)
                    .commit();
        }
    }
}