package com.ulpgc.luisbmier.android.cluedologv1.controller;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.ulpgc.luisbmier.android.cluedologv1.R;
import com.ulpgc.luisbmier.android.cluedologv1.model.Game;
import com.ulpgc.luisbmier.android.cluedologv1.model.GameLab;

import java.util.UUID;


public class LogMainFragment extends Fragment {
    private static final String Tag="LogMainFragment";
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    public static final String GAME_ID=
            "com.ulpgc.luisbmier.android.cluedologv1.game_id";
    private static final Float ALPHA =0.8f;

    // TODO: Rename and change types of parameters
    private Game mGame;

    private Button mLogButton;
    private Button mRenamePlayersButton;
    private Button mQuestion;

    private UUID mgameID;

    // TODO: Rename and change types and number of parameters
    public static LogMainFragment newInstance(UUID id) {
        LogMainFragment fragment = new LogMainFragment();
        Bundle args = new Bundle();
        args.putSerializable(GAME_ID,id);
        fragment.setArguments(args);
        return fragment;
    }

    public LogMainFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mgameID=(UUID)getArguments().getSerializable(GameListFragment.GAME_ID);
            mGame= GameLab.get(getActivity()).getGame(mgameID);
        } else {
            Log.w(Tag, "Arguments not found");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_log_main, container, false);
        mLogButton =new Button(getActivity());
        mLogButton =(Button)v.findViewById(R.id.logButton);
        mLogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), LogActivity.class);
                i.putExtra(LogSuspectsFragment.GAME_ID, mGame.getId());
                i.putExtra(LogWeaponsFragment.GAME_ID, mGame.getId());
                i.putExtra(LogRoomsFragment.GAME_ID, mGame.getId());
                startActivity(i);
            }
        });
        mRenamePlayersButton =new Button(getActivity());
        mRenamePlayersButton =(Button)v.findViewById(R.id.renamePlayersButton);
        mRenamePlayersButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO RenombrarJugadores
            }
        });
        mQuestion=new Button (getActivity());
        mQuestion =(Button)v.findViewById(R.id.questionButton);
        mQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO Funcion Question
            }
        });
        if (Build.VERSION.SDK_INT>Build.VERSION_CODES.GINGERBREAD) {
            transparent();
        }
        return v;
    }

    @TargetApi(11)
    private void transparent(){
        mLogButton.setAlpha(ALPHA);
        mRenamePlayersButton.setAlpha(ALPHA);
        mQuestion.setAlpha(ALPHA);
    }

//    @Override
//    public void onAttach(Activity activity) {
//        super.onAttach(activity);
//        try {
//            mListener = (OnFragmentInteractionListener) activity;
//        } catch (ClassCastException e) {
//            throw new ClassCastException(activity.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
//    }


    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */

    @Override
    public void onResume(){
        super.onResume();
        Log.d(Tag,"onResume called");
        mGame.upDate();
    }

}
