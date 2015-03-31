package com.ulpgc.luisbmier.android.cluedolog.controller;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ulpgc.luisbmier.android.cluedolog.R;

import java.util.UUID;

public class LogWeaponsFragment extends SingleSWRFragment {
    private static final String Tag="WeaponsFragment";
    private int nWeapons;
    int[][] mImageIds={{R.id.ImageView_sKnife,
                        R.id.ImageView_mKnife,
                        R.id.ImageView_wKnife,
                        R.id.ImageView_gKnife,
                        R.id.ImageView_cKnife,
                        R.id.ImageView_pKnife},
                       {R.id.ImageView_sCandelabrum,
                        R.id.ImageView_mCandelabrum,
                        R.id.ImageView_wCandelabrum,
                        R.id.ImageView_gCandelabrum,
                        R.id.ImageView_cCandelabrum,
                        R.id.ImageView_pCandelabrum},
                       {R.id.ImageView_sGun,
                        R.id.ImageView_mGun,
                        R.id.ImageView_wGun,
                        R.id.ImageView_gGun,
                        R.id.ImageView_cGun,
                        R.id.ImageView_pGun},
                       {R.id.ImageView_sPoison,
                        R.id.ImageView_mPoison,
                        R.id.ImageView_wPoison,
                        R.id.ImageView_gPoison,
                        R.id.ImageView_cPoison,
                        R.id.ImageView_pPoison},
                       {R.id.ImageView_sRope,
                        R.id.ImageView_mRope,
                        R.id.ImageView_wRope,
                        R.id.ImageView_gRope,
                        R.id.ImageView_cRope,
                        R.id.ImageView_pRope},
                       {R.id.ImageView_sDumbbell,
                        R.id.ImageView_mDumbbell,
                        R.id.ImageView_wDumbbell,
                        R.id.ImageView_gDumbbell,
                        R.id.ImageView_cDumbbell,
                        R.id.ImageView_pDumbbell}};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_log_weapons, parent, false);
        Log.d(Tag,"ViewID= " + Integer.toString(v.getId()));
        //mTitlePlayers = (TextView)v.findViewById(R.id.text_view_players);
        nWeapons=mGame.getWeapons();
        mPlayers = new TextView[PLAYERS];
        mImageMatrix = new ImageView[nWeapons][PLAYERS];
        mMatrix=mGame.getWeaponsMatrix();
        for (int i=0;i<PLAYERS;i++){
            mPlayers[i]=((TextView)v.findViewById(mPlayersIds[i]));
            refreshName(i);
            for (int j=0;j<nWeapons;j++){
                mImageMatrix[i][j]=(ImageView)v.findViewById(mImageIds[i][j]);
                if (mImageMatrix[i][j]==null){
                    Log.d(Tag,"mImage is null");
                }
                refreshImage(i, j, mImageMatrix[i][j]);
                mImageMatrix[i][j].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        updateMatrix(v.getId(),nWeapons,mImageIds,mImageMatrix);
                    }
                });
            }
        }

        return v;
    }

    public static LogWeaponsFragment newInstance(UUID gameId){
        Bundle args= new Bundle();
        args.putSerializable(GAME_ID, gameId);

        LogWeaponsFragment fragment = new LogWeaponsFragment();
        fragment.setArguments(args);

        return fragment;
    }
}
