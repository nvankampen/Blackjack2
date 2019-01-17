package com.example.java;

import java.util.ArrayList;

/**
 * Hand class used to hold cards in a player's hand
 */
class Hand {

    private ArrayList<Card> myHand = new ArrayList();

    Hand() {
    }

    /**
     * Draws a card and adds it to the hand
     */
    void drawCard() {
        Card myCard = new Card();
        myHand.add(myCard);
    }

    /**
     * Returns the card suit of the last card added to the hand
     * @return lastCardSuit
     */
    String getLastCardSuit() {
        String lastCardSuit = myHand.get(myHand.size()-1).getCardSuit();
        return lastCardSuit;
    }

    /**
     * Returns the card name of the last card added to the hand
     * @return lastCardName
     */
    String getLastCardName() {
        String lastCardName = myHand.get(myHand.size()-1).getCardName();
        return lastCardName;
    }

    /**
     * Returns the card value of the last card added to the hand
     * @return lastCardValue
     */
    int getLastCardValue() {
        int lastCardValue = myHand.get(myHand.size()-1).getCardValue();
        return lastCardValue;
    }

    /**
     * Returns the total hand value of all cards in the hand
     * @return handValue;
     */
    int getHandValue() {
        int handValue = 0;
        for (Card aMyHand : myHand) {
            handValue = handValue + aMyHand.getCardValue();
        }
        return handValue;
    }

    /**
     * Iterates through the hand converting Aces from value 11 to value 1
     */
    void checkHandAces() {
        int searchListLength = myHand.size();
        //Commented for loop below left in for education/reference purposes
//        for (int i = 0; i < searchListLength; i++) {
//            if (myHand.get(i).getCardValue() == 11) {
//                myHand.get(i).setAceValue();
        for (Card aMyHand : myHand) {
            if (aMyHand.getCardValue() == 11) {
                aMyHand.setAceValue();
            }
        }
    }

    /**
     * Clears the hand at the start of a new round
     */
    void clearHand() {
                myHand.clear();
            }
}
