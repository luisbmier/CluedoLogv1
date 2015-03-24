package com.ulpgc.luisbmier.android.cluedologv1.controller;

import java.util.ArrayList;
import java.util.UUID;

import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.ulpgc.luisbmier.android.cluedologv1.R;
import com.ulpgc.luisbmier.android.cluedologv1.model.Game;
import com.ulpgc.luisbmier.android.cluedologv1.model.GameLab;

public class GameListFragment extends android.support.v4.app.ListFragment {
	
	private static final String TAG = "GameListFragment";

    public static final String GAME_ID = "com.ulpgc.luisbmier.android.cluedologv1.game_id";
    private UUID mId;

    private ArrayList<Game> mGames;

    public static GameListFragment newInstance(UUID game_id) {
        GameListFragment fragment = new GameListFragment();
        Bundle args = new Bundle();
        args.putSerializable(GAME_ID,game_id);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setTitle(R.string.players_title);
        mGames = GameLab.get(getActivity()).getGames();
        GameAdapter adapter = new GameAdapter(mGames);
        setListAdapter(adapter);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) { 
        Game g = (Game)(getListAdapter()).getItem(position);
        //Log.d(TAG, c.getTitle() + " was clicked");
        Intent i=new Intent(getActivity(), LogMainActivity.class);
        i.putExtra(LogMainFragment.GAME_ID, g.getId());
        startActivity(i);

        Log.d(TAG, "Game started");

    }

    private class GameAdapter extends ArrayAdapter<Game> {
        public GameAdapter(ArrayList<Game> games) {
            super(getActivity(), android.R.layout.simple_list_item_1, games);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // if we weren't given a view, inflate one
            if (null == convertView) {
                convertView = getActivity().getLayoutInflater()
                    .inflate(com.ulpgc.luisbmier.android.cluedologv1.R.layout.list_item_game, null);
            }

            Game g = getItem(position);

            TextView titleTextView =
                (TextView)convertView.findViewById(com.ulpgc.luisbmier.android.cluedologv1.R.id.game_list_item_titleTextView);
            titleTextView.setText(g.getNames().toString());
            TextView dateTextView =
                (TextView)convertView.findViewById(com.ulpgc.luisbmier.android.cluedologv1.R.id.game_list_item_dateTextView);


            setDate(g,dateTextView);



            return convertView;
        }

    }
    private void setDate(Game g, TextView d){
        //v0
        //d.setText(c.getDate().toString());
        //v1
        CharSequence date= DateFormat.format("E dd/MM/yyyy hh:mm A", g.getDate());
        d.setText(date);
        return;
    }

    @Override
    public void onResume(){
        super.onResume();
        ((GameAdapter)getListAdapter()).notifyDataSetChanged();
    }
}

