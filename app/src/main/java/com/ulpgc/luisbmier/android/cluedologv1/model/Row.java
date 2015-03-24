package com.ulpgc.luisbmier.android.cluedologv1.model;

import java.util.ArrayList;

public class Row {
    private final int fPlayers;
    private ArrayList<Cell> mRow;

    public Row(int players) {
        fPlayers=players;
        mRow=new ArrayList<>(players);
        for (int i=0; i<players; i++){
            mRow.add(new Cell());
        }
    }

    public Cell getCell(int n){
        return mRow.get(n);
    }

    public void setCell(int n, Cell cell){
        mRow.set(n,cell);
    }

}
