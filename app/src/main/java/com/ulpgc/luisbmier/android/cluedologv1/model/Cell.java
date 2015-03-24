package com.ulpgc.luisbmier.android.cluedologv1.model;

import android.util.Log;

import java.util.UUID;

/**
 * Created by user on 06/03/2015.
 *
 * Es cada celda marcada por simbolos que están TODO asociados a una imagen
 */
public class Cell {
    private static final String Tag="Cell";
    //TODO: Optimizar la variable mState para que sea un char
    private String mState;
    private UUID mId;

    public Cell() {
        mId = UUID.randomUUID();
        mState = "blank";
    }

    public String getState() {
        return mState;
    }

    public void setState(String state) {
        mState = state;
    }

    public UUID getId() {
        return mId;
    }

    public void updateState(){
        Log.d(Tag, mState + " -> ");
        switch (mState){
            case "blank":
                mState="discard";
                break;
            case "discard":
                mState="have";
                break;
            case "have":
                mState="asked";
                break;
            case "asked":
                mState="target";
                break;
            case "target":
                mState="blank";
                break;
            default:
                Log.w(Tag, "Unnexpected State");
                break;
        }
        Log.d(Tag, mState);
        return;
    }
}
