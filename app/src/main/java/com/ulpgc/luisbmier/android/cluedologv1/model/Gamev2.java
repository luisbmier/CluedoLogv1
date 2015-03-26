package com.ulpgc.luisbmier.android.cluedologv1.model;


import android.app.Activity;

import com.ulpgc.luisbmier.android.cluedologv1.R;

/**
 * Created by user on 25/03/2015.
 */
public class Gamev2 extends Game {
    private MatrixCard mSuspectsMatrixCard;
    private MatrixCard mWeaponsMatrixCard;
    private MatrixCard mRoomsMatrixCard;
    private String[] mSuspectsNames;
    private String[] mWeaponsNames;
    private String[] mRoomsNames;
    private int[] mSuspectsImages;
    private int[] mWeaponsImages;
    private int[] mRoomsImages;

    public Gamev2() {
        super();
        mSuspectsMatrixCard=new MatrixCard(super.getSuspects(),super.getPlayers()
                ,mSuspectsNames,mSuspectsImages);
    }
}
