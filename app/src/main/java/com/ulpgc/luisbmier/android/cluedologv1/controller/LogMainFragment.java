package com.ulpgc.luisbmier.android.cluedologv1.controller;

import android.content.Intent;
import android.net.Uri;
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


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link LogMainFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link LogMainFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LogMainFragment extends Fragment {
    private static final String Tag="LogMainFragment";
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    public static final String GAME_ID=
            "com.ulpgc.luisbmier.android.cluedologv1.game_id";


    // TODO: Rename and change types of parameters
    private Game mGame;

    private Button mSuspectsButton;
    private Button mWeaponsButton;
    private Button mRoomsButton;

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
        mSuspectsButton=new Button(getActivity());
        mSuspectsButton=(Button)v.findViewById(R.id.SuspectsButton);
        mSuspectsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), LogSuspectsActivity.class);
                i.putExtra(LogSuspectsFragment.GAME_ID, mGame.getId());
                startActivity(i);
            }
        });
        mWeaponsButton=new Button(getActivity());
        mWeaponsButton=(Button)v.findViewById(R.id.WeaponsButton);
        mWeaponsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), LogWeaponsActivity.class);
                i.putExtra(LogWeaponsFragment.GAME_ID, mGame.getId());
                startActivity(i);
            }
        });
        mRoomsButton=new Button(getActivity());
        mRoomsButton=(Button)v.findViewById(R.id.RoomsButton);
        mRoomsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), LogRoomsActivity.class);
                i.putExtra(LogRoomsFragment.GAME_ID, mGame.getId());
                startActivity(i);
            }
        });
        return v;
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
