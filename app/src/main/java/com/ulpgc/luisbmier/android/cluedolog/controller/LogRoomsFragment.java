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

public class LogRoomsFragment extends SingleSWRFragment {
    private static final String Tag="RoomsFragment";
    private int nRooms;
    int[][] mImageIds={{R.id.ImageView_sKitchen,
                        R.id.ImageView_mKitchen,
                        R.id.ImageView_wKitchen,
                        R.id.ImageView_gKitchen,
                        R.id.ImageView_cKitchen,
                        R.id.ImageView_pKitchen},
                       {R.id.ImageView_sPatio,
                        R.id.ImageView_mPatio,
                        R.id.ImageView_wPatio,
                        R.id.ImageView_gPatio,
                        R.id.ImageView_cPatio,
                        R.id.ImageView_pPatio},
                       {R.id.ImageView_sSpa,
                        R.id.ImageView_mSpa,
                        R.id.ImageView_wSpa,
                        R.id.ImageView_gSpa,
                        R.id.ImageView_cSpa,
                        R.id.ImageView_pSpa},
                       {R.id.ImageView_sTheatre,
                        R.id.ImageView_mTheatre,
                        R.id.ImageView_wTheatre,
                        R.id.ImageView_gTheatre,
                        R.id.ImageView_cTheatre,
                        R.id.ImageView_pTheatre},
                       {R.id.ImageView_sLivingRoom,
                        R.id.ImageView_mLivingRoom,
                        R.id.ImageView_wLivingRoom,
                        R.id.ImageView_gLivingRoom,
                        R.id.ImageView_cLivingRoom,
                        R.id.ImageView_pLivingRoom},
                       {R.id.ImageView_sObservatory,
                        R.id.ImageView_mObservatory,
                        R.id.ImageView_wObservatory,
                        R.id.ImageView_gObservatory,
                        R.id.ImageView_cObservatory,
                        R.id.ImageView_pObservatory},
					   {R.id.ImageView_sHall,
                        R.id.ImageView_mHall,
                        R.id.ImageView_wHall,
                        R.id.ImageView_gHall,
                        R.id.ImageView_cHall,
                        R.id.ImageView_pHall},
					   {R.id.ImageView_sGuestRoom,
                        R.id.ImageView_mGuestRoom,
                        R.id.ImageView_wGuestRoom,
                        R.id.ImageView_gGuestRoom,
                        R.id.ImageView_cGuestRoom,
                        R.id.ImageView_pGuestRoom},
					   {R.id.ImageView_sDinningRoom,
                        R.id.ImageView_mDinningRoom,
                        R.id.ImageView_wDinningRoom,
                        R.id.ImageView_gDinningRoom,
                        R.id.ImageView_cDinningRoom,
                        R.id.ImageView_pDinningRoom}};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_log_rooms, parent, false);
        Log.d(Tag,"ViewID= " + Integer.toString(v.getId()));
        //mTitlePlayers = (TextView)v.findViewById(R.id.text_view_players);
        nRooms=mGame.getRooms();
        mPlayers = new TextView[PLAYERS];
        mImageMatrix = new ImageView[nRooms][PLAYERS];
        mMatrix=mGame.getRoomsMatrix();
        for (int i=0;i<PLAYERS;i++){
            mPlayers[i]=((TextView)v.findViewById(mPlayersIds[i]));
            refreshName(i);
            for (int j=0;j<nRooms;j++){
                Log.d(Tag,"mImageIds length=" + Integer.toString(mImageIds.length));
                Log.d(Tag,"mImageMatrix length=" + Integer.toString(mImageMatrix.length));
                mImageMatrix[j][i]=(ImageView)v.findViewById(mImageIds[j][i]);
                if (mImageMatrix[j][i]==null){
                    Log.d(Tag,"mImage is null");
                }
                refreshImage(j, i, mImageMatrix[j][i]);
                mImageMatrix[j][i].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        updateMatrix(v.getId(),nRooms,mImageIds,mImageMatrix);
                    }
                });
            }
        }

        return v;
    }

    public static LogRoomsFragment newInstance(UUID gameId){
        Bundle args= new Bundle();
        args.putSerializable(GAME_ID, gameId);

        LogRoomsFragment fragment = new LogRoomsFragment();
        fragment.setArguments(args);

        return fragment;
    }
}
