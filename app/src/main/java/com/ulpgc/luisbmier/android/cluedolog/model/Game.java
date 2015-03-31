package com.ulpgc.luisbmier.android.cluedolog.model;

import android.util.Log;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

public class Game {
    private static final String Tag="Game";
    private UUID mId;
    private Date mDate;

    private final int nSuspects =6;
    private final int nWeapons =6;
    private final int nRooms =9;
    private final int nPlayers =6;

    //Log variables
    private ArrayList<String> mNames;

    private Matrix mSuspectsMatrix;
    private Matrix mWeaponsMatrix;
    private Matrix mRoomsMatrix;


    public Game() {
        mId = UUID.randomUUID();
        mDate = new Date();
        mNames = new ArrayList<>(nPlayers);
        //TODO: Tomar estos strings del controlador.
        //NOTA: Se pude hacer cuando la app incluya la función NEW GAME
        mNames.add("Amapola");
        mNames.add("Rubio");
        mNames.add("Blanco");
        mNames.add("Prado");
        mNames.add("Celeste");
        mNames.add("Mora");

        mSuspectsMatrix=new Matrix(nSuspects, nPlayers);
        mWeaponsMatrix=new Matrix(nWeapons, nPlayers);
        mRoomsMatrix=new Matrix(nRooms, nPlayers);

    }

    public UUID getId() {
        return mId;
    }
    public void setName (String name, int i){
        mNames.set(i, name);
        return;
    }

    public void setName (CharSequence name, Character player){
        switch (player){
            case 's':
                mNames.set(0,(String)name);
                return;
            case 'm':
                mNames.set(1,(String)name);
                return;
            case 'w':
                mNames.set(2,(String)name);
                return;
            case 'g':
                mNames.set(3,(String)name);
                return;
            case 'c':
                mNames.set(4,(String)name);
                return;
            case 'p':
                mNames.set(5,(String)name);
                return;
            default:
                Log.w(Tag, "Name not assigned");
                return;
        }

    }
    public CharSequence getName(int i){
        return mNames.get(i);
    }

    public CharSequence getName (Character player){
        switch (player){
            case 's':
                return mNames.get(0);
            case 'm':
                return mNames.get(1);
            case 'w':
                return mNames.get(2);
            case 'g':
                return mNames.get(3);
            case 'c':
                return mNames.get(4);
            case 'p':
                return mNames.get(5);
            default:
                Log.w(Tag, "Can't get the name");
                return null;
        }
    }

    public ArrayList<String> getNames() {
        return mNames;
    }

    public void setNames(ArrayList<String> names) {
        mNames = names;
    }

    public Date getDate() {
        return mDate;
    }

    public Matrix getSuspectsMatrix() {
        return mSuspectsMatrix;
    }

    public void setSuspectsMatrix(Matrix suspectsMatrix) {
        mSuspectsMatrix = suspectsMatrix;
    }

    public Matrix getWeaponsMatrix() {
        return mWeaponsMatrix;
    }

    public void setWeaponsMatrix(Matrix weaponsMatrix) {
        mWeaponsMatrix = weaponsMatrix;
    }

    public Matrix getRoomsMatrix() {
        return mRoomsMatrix;
    }

    public void setRoomsMatrix(Matrix roomsMatrix) {
        mRoomsMatrix = roomsMatrix;
    }

    public void upDate() {
        mDate = new Date();
    }

    public int getSuspects() {
        return nSuspects;
    }

    public int getWeapons() {
        return nWeapons;
    }

    public int getRooms() {
        return nRooms;
    }

    public int getPlayers() {
        return nPlayers;
    }
}
