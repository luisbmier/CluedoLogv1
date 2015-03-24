package com.ulpgc.luisbmier.android.cluedologv1.model;

import java.util.ArrayList;

public class Matrix {
    private final int nRows;
    private final int nPlayers;
    private ArrayList<Row> mMatrix;

    public Matrix(int row, int col) {
        nRows =row;
        nPlayers =col;
        mMatrix =new ArrayList<>(row);
        for(int i=0; i<row; i++){
            mMatrix.add(new Row(col));
        }
    }

    public Row getRow(int r) {
        return mMatrix.get(r);
    }

    public void setRow(int r, Row row) {
        mMatrix.set(r, row);
        return;
    }

    //Acceso rápido a la cell
    public Cell getCell(int r, int c){
        return mMatrix.get(r).getCell(c);
    }

    public void setCell(int r, int c, Cell cell){
        mMatrix.get(r).setCell(c, cell);
        return;
    }
}
