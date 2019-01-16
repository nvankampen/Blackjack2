package com.example.java;

import java.util.ArrayList;

class Hand {

    private ArrayList<Card> myHand = new ArrayList();

    Hand() {
    }

    void drawCard() {
        /**
         * Draws a card and adds it to the hand
         */
        Card myCard = new Card();
        myHand.add(myCard);
    }

    String getLastCardSuit() {
        /**
         * Returns the card suit of the last card added to the hand
         * @return lastCardSuit
         */
        String lastCardSuit = myHand.get(myHand.size()-1).getCardSuit();
        return lastCardSuit;
    }

    String getLastCardName() {
        /**
         * Returns the card name of the last card added to the hand
         * @return lastCardName
         */
        String lastCardName = myHand.get(myHand.size()-1).getCardName();
        return lastCardName;
    }

    int getLastCardValue() {
        /**
         * Returns the card value of the last card added to the hand
         * @return lastCardValue
         */
        int lastCardValue = myHand.get(myHand.size()-1).getCardValue();
        return lastCardValue;
    }

    int getHandValue() {
        /**
         * Returns the total hand value of all cards in the hand
         * @return handValue;
         */
        int handValue = 0;
        int searchListLength = myHand.size();
        for (int i = 0; i < searchListLength; i++) {
            handValue = handValue + myHand.get(i).getCardValue();
        }
        return handValue;
    }

    void checkHandAces() {
        /**
         * Iterates through the hand converting Aces from value 11 to value 1
         */
        int searchListLength = myHand.size();
        for (int i = 0; i < searchListLength; i++) {
            if (myHand.get(i).getCardValue() == 11) {
                myHand.get(i).setAceValue();
            }
        }
    }

    void clearHand() {
        /**
         * Clears the hand at the start of a new round
         */
                myHand.clear();
            }
}
