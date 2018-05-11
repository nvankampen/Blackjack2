package com.example.java;

/**
 * Card class contains all possible cards in a deck by name and suit type.  When instantiated, a random
 * card name (which is associated with a value) and a random suit is chosen
 */
public class Card {
    /**
     * List of all class variables
     * "cardName" is an array of all possible card names represented as strings
     * "cardSuit" is an array of all possible card suits
     * "cardValue" holds the value associated with the specific cardName.  It lines up with indexes of cardName. The "1"
     *      final position use the second value of an Ace (11 or 1)
     * "arrayName" used to pick value in CardName array
     * "arraySuit" used to pick value in cardSuit array
     */
    private String[] cardName = {"Two", "Three", "Four", "Five", "Six", "Seven", "Eight",
            "Nine", "Ten", "Ace", "Jack", "Queen", "King"};
    private int[] cardValue = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 10, 10, 10, 1};
    private String[] cardSuit = {"Hearts", "Diamonds", "Clubs", "Spades"};
    private int arrayName;
    private int arraySuit;
    private int arrayValue;

    public Card() {
        /**
         * When a Card object is initalized, it is set with a random arrayName
         * and arraySuit integer for selecting appropriate strings from cardName
         * and cardSuit
         */
        arrayName = (int) (Math.random() * 13);
        arraySuit = (int) (Math.random() * 3);
        arrayValue = arrayName;
    }

    public String getCardName() {
        /**
         * Returns the cardName based on the specific value of arrayName
         * @return cardName
         */
        return cardName[arrayName];
    }

    public String getCardSuit() {
        /**
         * Returns the cardSuit based on the specific value of arraySuit
         * @return cardSuit
         */
        return cardSuit[arraySuit];
    }


    public int getCardValue() {
        /**
         * Based on the cardName of the Card, sets "cardValue" to the appropriate integer
         * value.
         * @return cardValue
         */

        return cardValue[arrayValue];
    }

    public void setAceValue() {
        /**
         * Sets the value of the card from 11 to 1.  Index position 13 is a value of 1.
         */
        arrayValue = 13;
    }
}
