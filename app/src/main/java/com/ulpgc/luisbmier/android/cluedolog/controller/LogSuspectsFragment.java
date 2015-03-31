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

public class LogSuspectsFragment extends SingleSWRFragment {
    private static final String Tag="SuspectsFragment";
    private int nSuspects;
    int[][] mImageIds={{R.id.ImageView_sScarlet,
                        R.id.ImageView_mScarlet,
                        R.id.ImageView_wScarlet,
                        R.id.ImageView_gScarlet,
                        R.id.ImageView_cScarlet,
                        R.id.ImageView_pScarlet},
                       {R.id.ImageView_sMustard,
                        R.id.ImageView_mMustard,
                        R.id.ImageView_wMustard,
                        R.id.ImageView_gMustard,
                        R.id.ImageView_cMustard,
                        R.id.ImageView_pMustard},
                       {R.id.ImageView_sWhite,
                        R.id.ImageView_mWhite,
                        R.id.ImageView_wWhite,
                        R.id.ImageView_gWhite,
                        R.id.ImageView_cWhite,
                        R.id.ImageView_pWhite},
                       {R.id.ImageView_sGreen,
                        R.id.ImageView_mGreen,
                        R.id.ImageView_wGreen,
                        R.id.ImageView_gGreen,
                        R.id.ImageView_cGreen,
                        R.id.ImageView_pGreen},
                       {R.id.ImageView_sPeacock,
                        R.id.ImageView_mPeacock,
                        R.id.ImageView_wPeacock,
                        R.id.ImageView_gPeacock,
                        R.id.ImageView_cPeacock,
                        R.id.ImageView_pPeacock},
                       {R.id.ImageView_sPlum,
                        R.id.ImageView_mPlum,
                        R.id.ImageView_wPlum,
                        R.id.ImageView_gPlum,
                        R.id.ImageView_cPlum,
                        R.id.ImageView_pPlum}};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_log_suspects, parent, false);
        Log.d(Tag,"ViewID= " + Integer.toString(v.getId()));
        //mTitlePlayers = (TextView)v.findViewById(R.id.text_view_players);
        nSuspects=mGame.getSuspects();
        mPlayers = new TextView[PLAYERS];
        mImageMatrix = new ImageView[nSuspects][PLAYERS];
        mMatrix=mGame.getSuspectsMatrix();
        for (int i=0;i<PLAYERS;i++){
            mPlayers[i]=((TextView)v.findViewById(mPlayersIds[i]));
            refreshName(i);
            for (int j=0;j<nSuspects;j++){
                mImageMatrix[i][j]=(ImageView)v.findViewById(mImageIds[i][j]);
                refreshImage(i, j,mImageMatrix[i][j]);
                mImageMatrix[i][j].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        updateMatrix(v.getId(),nSuspects,mImageIds,mImageMatrix);
                    }
                });
            }
        }

        return v;
    }

    public static LogSuspectsFragment newInstance(UUID gameId){
        Bundle args= new Bundle();
        args.putSerializable(GAME_ID, gameId);

        LogSuspectsFragment fragment = new LogSuspectsFragment();
        fragment.setArguments(args);

        return fragment;
    }
}
