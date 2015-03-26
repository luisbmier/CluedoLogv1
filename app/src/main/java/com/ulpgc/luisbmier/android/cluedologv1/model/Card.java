package com.ulpgc.luisbmier.android.cluedologv1.model;

/**
 * Created by user on 25/03/2015.
 */
public class Card {
    private String mName;
    private int mImage;

    public Card(String name, int image) {
        mName = name;
        mImage = image;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public int getImage() {
        return mImage;
    }

    public void setImage(int image) {
        mImage = image;
    }
}
