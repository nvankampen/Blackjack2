package com.example.java;

/**
 * Card class contains all possible cards in a deck by name and suit type.  When instantiated, a random
 * card name (which is associated with a value) and a random suit is chosen
 */
class Card {
    /*
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
    //TODO: Those two arrays could actually be stored in a hashmap.  A hashmap is a key/value pair.  Add like this... mySuit.put("Two", 2)
    private String[] cardSuit = {"Hearts", "Diamonds", "Clubs", "Spades"};
    //TODO: The above could be another hashmap with the suit name as a key and a full suit as the value.
    //TODO: Using the hashmap of hashmaps means you have individually addressable cards which can be removed from the deck as they are consumed in game.
    private int arrayName;
    private int arraySuit;
    private int arrayValue;

    /**
     When a Card object is initialized, it is set with a random arrayName
     and arraySuit integer for selecting appropriate strings from cardName
     and cardSuit
     */
    Card() {
        arrayName = (int) (Math.random() * 13);
        arraySuit = (int) (Math.random() * 3);
        arrayValue = arrayName;
    }

    /**
     Returns the cardName based on the specific value of arrayName
     @return cardName
     */
    String getCardName() {
        return cardName[arrayName];
    }

    /**
     Returns the cardSuit based on the specific value of arraySuit
     @return cardSuit
     */
    String getCardSuit() {
        return cardSuit[arraySuit];
    }

    /**
     * Based on the cardName of the Card, sets "cardValue" to the appropriate integer
     * value.
     * @return cardValue
     */
    int getCardValue() {
        return cardValue[arrayValue];
    }

    /**
     * Sets the value of the card from 11 to 1.  Index position 13 is a value of 1.
     */
    void setAceValue() {
        arrayValue = 13;
    }
}

