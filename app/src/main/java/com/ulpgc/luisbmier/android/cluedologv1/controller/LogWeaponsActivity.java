package com.ulpgc.luisbmier.android.cluedologv1.controller;

import android.support.v4.app.Fragment;

import java.util.UUID;

public class LogWeaponsActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        UUID gameId=(UUID)getIntent()
                .getSerializableExtra(LogWeaponsFragment.GAME_ID);
        return LogWeaponsFragment.newInstance(gameId);
    }
}