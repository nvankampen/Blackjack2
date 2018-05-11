/*
 * <h1> Blackjack</h1>
 * This program is a simple blackjack application used to play
 * black jack with user supplied input with a computer dealer
 */
package com.example.java;

import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.*;
/**
 * @author Nathan Van Kampen
 * @version 1.0
 * @since 2018-01-03
 */
public class Main {
    /**
     * Create class variables for Main class.
     * "myHand" represents cards a user draws from a deck from the Card class.
     * "dealerHand" represents cards a dealer draws from a deck from the Card class.
     * "myBusted" used to keep track of when user goes over 21
     * "playAgainAnswer" used to determine if the game should restart
     * "gamesWon" tracks total games won by the user
     * "gamesLost" tracks total games lost by the user
     */
    private static ArrayList<Card> myHand = new ArrayList();
    private static ArrayList<Card> dealerHand = new ArrayList();
    private static boolean myBusted = false;
    private static String playAgainAnswer = "y";
    private static int gamesWon = 0;
    private static int gamesLost = 0;

    public static void main(String[] args) {
        /**
         * Main method contains calls to methods that run the program
         */
        while (playAgainAnswer.equalsIgnoreCase("y")) {
            myBusted = false;
            out.println("Welcome to Blackjack");
            out.println("");
            out.println("The dealer draws first");

            dealerDrawCard();
            out.println("The second card remains hidden");
            out.println("");
            out.println("Now your cards are dealt");
            /**
             * The following are method calls related to the user's hand playing black jack.
             */
            myDrawCard();
            myDrawCard();
            checkMyTotal();
            myHandTotal();
            myHitOrStay();
            out.println("");

            /**
             * The following if statement is for the dealer hand and only occurs if the user didn't already go bust.
             */
            if (myBusted == false) {

                out.println("The Dealer shows his second card");
                dealerDrawCard();
                out.print("Dealer ");
                dealerHandTotal();
                checkDealerTotal();
            }
            playAgain();
        }
        out.println("");
        out.println("Thanks for playing, good bye.");
    }

    private static void myDrawCard() {
        /**
         * Method for drawing a new card from the deck and adding it to the user's hand
         */
        Card myCard = new Card();
        myHand.add(myCard);
        out.println("A " + myCard.getCardName() + " of " + myCard.getCardSuit() +
                " was drawn for a value of: " + myCard.getCardValue());
    }

    private static void myHandTotal() {
        /**
         * Prints out user's total hand value
         */
        out.println("Hand Total = " + iterateUserHandTotal());
    }

    private static void dealerHandTotal() {
        /**
         * Prints out daler's total hand value
         */
        out.println("Hand Total = " + iterateDealerHandTotal());
    }

    private static void myHitOrStay() {
        /**
         * While the user hasn't exceeded a hand of 21 (myBusted == true), this method calls itself checking
         * if the user wants to draw another card or stay with their current hand.  Upon
         * exceeding hand value of 21 or response of "Stay" method ends.
         */
        String response;
        while (myBusted == false) {
            Scanner in = new Scanner(System.in);
            out.println("Would you like to 'Hit' or 'Stay'? ");
            response = in.nextLine();

            if (response.equalsIgnoreCase("Hit")) {
                myDrawCard();
                checkMyTotal();
                myHandTotal();
                myHitOrStay();
            } else if (response.equalsIgnoreCase("Stay")) {
                break;
            } else {
                out.println("I don't understand the the response of " + response + ". Please check that your response is correct");
                myHitOrStay();
            }
            break;
        }
    }

    private static void checkMyTotal() {
        /**
         * Method to check whether user's hand currently exceeds 21, if so the user loses
         * and the game ends unless they have an Ace card, in which case the value of the Ace
         * is changed from 11 to 1.
         */
        if (iterateUserHandTotal() > 21) {
            /**
             * Iterates through the user's hand looking for Aces and changes their value to 1. Recursion used
             * to iterate through and only change one Ace at a time before re-evaluating if hand exceeds 21.
            */
            int searchListLength = myHand.size();
            for (int i = 0; i < searchListLength; i++) {
                if (myHand.get(i).getCardValue() == 11) {
                    myHand.get(i).setAceValue();
                    checkMyTotal();
                }
            }
            /**
             * If hand is greater than 21 and there are no aces, the user loses.
             */
            if (iterateUserHandTotal() > 21){
                out.println("You went over 21, you lose this hand. The Dealer wins!");
                gamesLost++;
                myBusted = true;
            }
        }
    }

    private static void checkDealerTotal() {
        /**
         * This method evaluates dealer's current hand. If less than 21 and less than player's hand, the dealer
         * will draw a card.  Upon exceeding 21, method iterates dealer's hand for Aces and converting one at a
         * time to a value of 1 before being re-evaluated.
         */
        if (iterateDealerHandTotal() == 21) {
            out.println("The dealer has " + iterateDealerHandTotal() + ". The dealer wins!");
            gamesLost++;
        } else if (iterateDealerHandTotal() < iterateUserHandTotal()) {
            dealerDrawCard();
            checkDealerTotal();
        } else if (iterateDealerHandTotal() > 21) {
            /**
             * Iterate through dealer's hand looking for Aces to convert to value of 1. Uses recursion to re-evaluate
             * if additional aces require having their value adjusted to 1.
             */
            int searchListLength = dealerHand.size();
            for (int i = 0; i < searchListLength; i++) {
                if (dealerHand.get(i).getCardValue() == 11) {
                    dealerHand.get(i).setAceValue();
                    checkDealerTotal();
                }
            }
            out.println("The dealer has " + iterateDealerHandTotal() + " and went over 21. You win!");
            gamesWon++;
        } else if (iterateDealerHandTotal() >= iterateUserHandTotal()) {
            out.println("the dealer has " + iterateDealerHandTotal() + " and beats your " + iterateUserHandTotal() + ". The dealer wins!");
            gamesLost++;
        }
    }
    private static void playAgain() {
        /**
         * Method used to determine if user wants to play another hand of blackjack.  Clears arrays
         * at the end of the game before the start of the next game.
         */
        Scanner in = new Scanner(System.in);
        out.println("");
        out.println("Your current win:loss ratio is: " + gamesWon + " : " + gamesLost);
        out.println("Would you like to play again? 'y/n'? ");
        playAgainAnswer = in.nextLine();
        myHand.clear();
        dealerHand.clear();

        if (playAgainAnswer.equalsIgnoreCase("y")) {
        } else if (playAgainAnswer.equalsIgnoreCase("n")) {
        } else {
            out.println("I don't understand the response of " + playAgainAnswer + ". Please check that your response is correct");
            playAgain();
        }
    }
    private static void dealerDrawCard() {
        /**
         * Method for drawing a new card from the deck and adding it to the dealer's hand
         */
        Card myCard = new Card();
        dealerHand.add(myCard);
        out.println("A " + myCard.getCardName() + " of " + myCard.getCardSuit() +
                " was drawn for a value of: " + myCard.getCardValue());
    }
    private static int iterateUserHandTotal(){
        /**
         * Method used to calculate the total value of the user's hand.
         */
        int searchListLength = myHand.size();
        int userHandTotal = 0;
        for (int i = 0; i < searchListLength; i++) {
            userHandTotal = userHandTotal + myHand.get(i).getCardValue();
        }
        return userHandTotal;
    }
    private static int iterateDealerHandTotal(){
        /**
         * Method used to calculate the total value of the dealer's hand.
         */
        int searchListLength = dealerHand.size();
        int dealerHandTotal = 0;
        for (int i = 0; i < searchListLength; i++) {
            dealerHandTotal = dealerHandTotal + dealerHand.get(i).getCardValue();
        }
        return dealerHandTotal;
    }

}


