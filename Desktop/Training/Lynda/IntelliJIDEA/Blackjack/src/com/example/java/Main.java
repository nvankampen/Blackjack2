/*
 * <h1> Blackjack</h1>
 * This program is a simple blackjack application used to play
 * black jack with user supplied input with a computer dealer
 */
package com.example.java;

import java.util.Scanner;

import static java.lang.System.*;
/**
 * @author Nathan Van Kampen
 * @version 1.1
 * @since 2018-01-03
 */
public class Main {
    /**
     * Create class variables for Main class.
     * "playerHand" represents cards in the player's hand.
     * "dealerHand" represents cards in a dealer's hand.
     * "myBusted" used to keep track of when user goes over 21
     * "playAgainAnswer" used to determine if the game should restart
     * "gamesWon" tracks total games won by the user
     * "gamesLost" tracks total games lost by the user
     */

    private static Hand playerHand = new Hand();
    private static Hand dealerHand = new Hand();
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
            out.println();
            out.println("The dealer draws first");

            dealerDrawCard();
            out.println("The second card remains hidden");
            out.println();
            out.println("Now your cards are dealt");
            /**
             * The following are method calls related to the user's hand playing black jack.
             */
            myDrawCard();
            myDrawCard();
            checkMyTotal();
            myHandTotal();
            myHitOrStay();
            out.println();

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
        out.println();
        out.println("Thanks for playing, good bye.");
    }

    private static void myDrawCard() {
        /**
         * Method for drawing a new card from the deck and adding it to the user's hand
         */
        playerHand.drawCard();
        out.println("A " + playerHand.getLastCardName() + " of " + playerHand.getLastCardSuit() +
                " was drawn for a value of: " + playerHand.getLastCardValue());
    }

    private static void myHandTotal() {
        /**
         * Prints out user's total hand value
         */
        out.println("Hand Total = " + playerHand.getHandValue());
    }

    private static void dealerHandTotal() {
        /**
         * Prints out dealer's total hand value
         */
        out.println("Hand Total = " + dealerHand.getHandValue());
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
        if (playerHand.getHandValue() > 21) {
            playerHand.checkHandAces();

            /**
             * If hand is greater than 21 and there are no aces, the user loses.
             */
            if (playerHand.getHandValue() > 21){
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
        if (dealerHand.getHandValue() == 21) {
            out.println("The dealer has " + dealerHand.getHandValue() + ". The dealer wins!");
            gamesLost++;
        } else if (dealerHand.getHandValue() < playerHand.getHandValue()) {
            dealerDrawCard();
            checkDealerTotal();
        } else if (dealerHand.getHandValue() > 21) {
            /**
             * Iterate through dealer's hand looking for Aces to convert to value of 1. Uses recursion to re-evaluate
             * if additional aces require having their value adjusted to 1.
             */

                    dealerHand.checkHandAces();

            out.println("The dealer has " + dealerHand.getHandValue() + " and went over 21. You win!");
            gamesWon++;
        } else if (dealerHand.getHandValue() >= playerHand.getHandValue()) {
            out.println("the dealer has " + dealerHand.getHandValue() + " and beats your " + playerHand.getHandValue() + ". The dealer wins!");
            gamesLost++;
        }
    }
    private static void playAgain() {
        /**
         * Method used to determine if user wants to play another hand of blackjack.  Clears arrays
         * at the end of the game before the start of the next game.
         */
        Scanner in = new Scanner(System.in);
        out.println();
        out.println("Your current win:loss ratio is: " + gamesWon + " : " + gamesLost);
        out.println("Would you like to play again? 'y/n'? ");
        playAgainAnswer = in.nextLine();
        playerHand.clearHand();
        dealerHand.clearHand();

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
        dealerHand.drawCard();
        out.println("A " + dealerHand.getLastCardName() + " of " + dealerHand.getLastCardSuit() +
                " was drawn for a value of: " + dealerHand.getLastCardValue());
    }
}


