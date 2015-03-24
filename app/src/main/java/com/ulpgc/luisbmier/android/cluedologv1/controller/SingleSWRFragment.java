package com.ulpgc.luisbmier.android.cluedologv1.controller;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.widget.ImageView;
import android.widget.TextView;

import com.ulpgc.luisbmier.android.cluedologv1.R;
import com.ulpgc.luisbmier.android.cluedologv1.model.Cell;
import com.ulpgc.luisbmier.android.cluedologv1.model.Game;
import com.ulpgc.luisbmier.android.cluedologv1.model.GameLab;
import com.ulpgc.luisbmier.android.cluedologv1.model.Matrix;

import java.util.UUID;

/**
 * Created by user on 20/03/2015.
 */
public abstract class SingleSWRFragment extends Fragment{
    public static final String GAME_ID=
            "com.ulpgc.luisbmier.android.cluedologv1.game_id";
    protected Game mGame;
    protected final int nPlayers=mGame.getPlayers();
    protected TextView[] mPlayers;
    protected int[] mPlayersIds={   R.id.TextView_Scarlet,
                                    R.id.TextView_Mustard,
                                    R.id.TextView_White,
                                    R.id.TextView_Green,
                                    R.id.TextView_Peacock,
                                    R.id.TextView_Plum};
    protected int[][] mImageIds;
    protected ImageView[][] mImageMatrix;
    protected Matrix mMatrix;


    protected void refreshName(int i) {
        mPlayers[i].setText(mGame.getName(i));
    }

    protected void updateName() {
        for (int i=0;i<nPlayers;i++){
            mGame.setName(mPlayers[i].getText().toString(),i);
        }
    }

    //TODO: corregir los gráficos de la imagen
    protected void refreshImage(int f, int c, ImageView imageView) {
        switch (mMatrix.getCell(f, c).getState()) {
            case "blank":
                imageView.setImageResource(R.drawable.lupa);
                break;
            case "discard":
                imageView.setImageResource(R.drawable.ex);
                break;
            case "have":
                imageView.setImageResource(R.drawable.tick);
                break;
            case "asked":
                imageView.setImageResource(R.drawable.question);
                break;
            case "target":
                imageView.setImageResource(R.drawable.surprise);
                break;
            default:
                break;
        }
    }

    protected void updateMatrix(int viewId, int nRows, int[][] IVids, ImageView[][] imageView){
        int[] i=identifyCell(viewId, nRows, IVids);
        updateCell(i[0], i[1],imageView[i[0]][i[1]]);
    }

    protected int[] identifyCell(int id, int nRows, int[][] IVid) {
        int[] i={0,0};
        for(i[0]=0;i[0]<nRows;i[0]++){
            for(i[1]=0;i[1]<nPlayers;i[1]++){
                if(IVid[i[0]][i[1]]==id){
                    return i;
                }
            }
        }
        i[0]=-1;
        i[1]=-1;
        return i;
    }
    protected void updateCell(int f, int c, ImageView imageView) {
        Cell cell= mMatrix.getCell(f, c);
        cell.updateState();
        refreshImage(f, c, imageView);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UUID gameID=(UUID)getArguments().getSerializable(GAME_ID);
        mGame= GameLab.get(getActivity()).getGame(gameID);
    }

    @Override
    public void onResume(){
        super.onResume();
        mGame.upDate();
    }
}