package com.ulpgc.luisbmier.android.cluedologv1.controller;

import android.support.v4.app.Fragment;

import java.util.UUID;

public class LogRoomsActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        UUID gameId=(UUID)getIntent()
                .getSerializableExtra(LogRoomsFragment.GAME_ID);
        return LogRoomsFragment.newInstance(gameId);
    }
}