package com.ulpgc.luisbmier.android.cluedologv1.model;

import java.util.ArrayList;

/**
 * Created by user on 25/03/2015.
 */
public class MatrixCard extends Matrix {
    ArrayList<RowCard> mRowCards;
    public MatrixCard(int row, int col, String[] names, int[] images) {
        super(row, col);
        mRowCards =new ArrayList<>(row);
        for(int i=0; i<row; i++){
            mRowCards.add(new RowCard(col,names[i],images[i]));
        }
    }
}
