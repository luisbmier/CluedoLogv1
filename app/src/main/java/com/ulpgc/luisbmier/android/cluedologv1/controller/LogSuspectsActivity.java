package com.ulpgc.luisbmier.android.cluedologv1.controller;

import android.support.v4.app.Fragment;

import java.util.UUID;

public class LogSuspectsActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        UUID gameId=(UUID)getIntent()
                .getSerializableExtra(LogSuspectsFragment.GAME_ID);
        return LogSuspectsFragment.newInstance(gameId);
    }
}