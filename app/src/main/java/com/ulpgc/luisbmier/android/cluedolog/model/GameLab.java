package com.ulpgc.luisbmier.android.cluedolog.model;

import java.util.ArrayList;
import java.util.UUID;

import android.content.Context;
import android.util.Log;

public class GameLab {
    private ArrayList<Game> mGames;
    private static String LogTag="GameLab";

    private static GameLab sGameLab;
    private Context mAppContext;

    private GameLab(Context appContext) {
        mAppContext = appContext;
        mGames = new ArrayList<>();
        Game g = new Game();
        mGames.add(g);
    }

    public static GameLab get(Context c) {
        if (sGameLab == null) {
            sGameLab = new GameLab(c.getApplicationContext());
        }
        return sGameLab;
    }

    public ArrayList<Game> getGames() {
        return mGames;
    }

    public Game getGame(UUID gameID) {
        for (int i = 0; i < 100; i++) {
            Game g=mGames.get(i);
            if (gameID.equals(g.getId())) {
                Log.d(LogTag,"Game #" + Integer.toString(i) + " gotten");
                return g;
            }
        }
        return null;
    }
}

