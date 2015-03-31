package com.ulpgc.luisbmier.android.cluedolog.model;

/**
 * Created by user on 25/03/2015.
 */
public class RowCard extends Row{
    private Card mCard;
    public RowCard(int players, String name, int image) {
        super(players);
        mCard=new Card(name, image);
    }

    public Card getCard() {
        return mCard;
    }

    public void setCard(Card card) {
        mCard = card;
    }
}
