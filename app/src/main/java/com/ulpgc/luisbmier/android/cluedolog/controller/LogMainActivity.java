package com.ulpgc.luisbmier.android.cluedolog.controller;

import android.support.v4.app.Fragment;

import java.util.UUID;

public class LogMainActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        UUID gameId=(UUID)getIntent()
                .getSerializableExtra(LogMainFragment.GAME_ID);
        return LogMainFragment.newInstance(gameId);
    }
}