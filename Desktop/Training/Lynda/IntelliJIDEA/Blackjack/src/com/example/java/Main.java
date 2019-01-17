/*
  <h1> Blackjack</h1>
  This program is a simple blackjack application used to play
  black jack with user supplied input with a computer dealer
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
    private static Money myMoney = new Money();
    private static boolean myBusted = false;  //TODO: Would probably name isBusted
    private static int gamesWon = 0;
    private static int gamesLost = 0;

    public static void main(String[] args) {
        mainBlackJackGame();
    }

    /**
     * Main method contains calls to methods that run the program
     */
    private static void mainBlackJackGame() {
        myBusted = false;
        checkMoneyTotal();
        out.println("Welcome to Blackjack");
        out.println("You currently have $" + myMoney.getMoneyTotal());
        out.println(); //TODO: you can add + "\r\n" to the previous println statement.
        askBetAmount();
        out.println();
        out.println("The dealer draws first");

        dealerDrawCard();
        out.println("The second card remains hidden");
        out.println();
        out.println("Now your cards are dealt");

        /*
         * The following are method calls related to the user's hand playing black jack.
         */
        myDrawCard();
        myDrawCard();
        checkMyTotal();
        myHandTotal();
        myHitOrStay();
        out.println();

        /*
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

    /**
     * Checks whether player has more than $0, program closes if money = $0
     */
    private static void checkMoneyTotal() {
        if (myMoney.getMoneyTotal() == 0){
            out.print("I'm sorry, you're out of money, Good Bye");
            System.exit(0);
        }
    }

    /**
     * Asks user how much they'd like to bet
     */
    private static void askBetAmount() {
        //TODO:
        //I'd probably re-think this a little.  I would use a loop checking for a correct response rather than using recursion.
        //I would also do some input validation.  An easy way to do so is to record the line as a string and use a regular expression to parse.
        //A pattern of ^[0-9]+$ would only match if there is 1 or more digits and only numbers.  Put a non-numeric and it will not match.
        //Use pattern.matcher to get a boolean result.
        Scanner in = new Scanner(System.in);
        out.println("How much money would you like to bet");
        try {
            int response = in.nextInt();
            if (response > 0) {
                if (response > myMoney.getMoneyTotal()) {
                    out.println("You don't have that much money, please try again");
                    askBetAmount();
                } else myMoney.setBet(response);
            } else if (response < 0) {
                out.println("You can't bet a negative amount of money, please try again");
                askBetAmount();
            } else {
                out.println("$0? Why don't you try betting some money, please try again");

                askBetAmount();
            }
        }
        catch (Exception e){
            out.print("I don't understand that response, please try again");
            out.println();
            askBetAmount();
        }
    }

    /**
     * Method for drawing a new card from the deck and adding it to the user's hand
     */
    private static void myDrawCard() {
        playerHand.drawCard();
        out.println("A " + playerHand.getLastCardName() + " of " + playerHand.getLastCardSuit() +
                " was drawn for a value of: " + playerHand.getLastCardValue());
    }

    /**
     * Prints out user's total hand value
     */
    private static void myHandTotal() {
        out.println("Hand Total = " + playerHand.getHandValue());
    }

    /**
     * Prints out dealer's total hand value
     */
    private static void dealerHandTotal() {
        out.println("Hand Total = " + dealerHand.getHandValue());
    }

    /**
     * While the user hasn't exceeded a hand of 21 (myBusted == true), this method calls itself checking
     * if the user wants to draw another card or stay with their current hand.  Upon
     * exceeding hand value of 21 or response of "Stay" method ends.
     */
    private static void myHitOrStay() {
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

    /**
     * Method to check whether user's hand currently exceeds 21, if so the user loses
     * and the game ends unless they have an Ace card, in which case the value of the Ace
     * is changed from 11 to 1.
     */
    private static void checkMyTotal() {
        if (playerHand.getHandValue() == 21){
            out.println("You got 21, you win!");
            myMoney.addMoney();
            gamesWon++;
            playAgain();
        }
        if (playerHand.getHandValue() > 21) {
            playerHand.checkHandAces();

            /*
             * If hand is greater than 21 and there are no aces, the user loses.
             */
            if (playerHand.getHandValue() > 21){
                out.println("You went over 21, you lose this hand. The Dealer wins!");
                gamesLost++;
                myMoney.subtractMoney();
                myBusted = true;
            }
        }
    }

    /**
     * This method evaluates dealer's current hand. If less than 21 and less than player's hand, the dealer
     * will draw a card.  Upon exceeding 21, method iterates dealer's hand for Aces and converting one at a
     * time to a value of 1 before being re-evaluated.
     */
    private static void checkDealerTotal() {
        if (dealerHand.getHandValue() == 21) {
            out.println("The dealer has " + dealerHand.getHandValue() + ". The dealer wins!");
            gamesLost++;
            myMoney.subtractMoney();
        } else if (dealerHand.getHandValue() < playerHand.getHandValue()) {
            dealerDrawCard();
            checkDealerTotal();
        } else if (dealerHand.getHandValue() > 21) {
            dealerHand.checkHandAces();
            /*
             * If hand is greater than 21 and there are no aces, the user loses.
             */
            out.println("The dealer has " + dealerHand.getHandValue() + " and went over 21. You win!");
            gamesWon++;
            myMoney.addMoney();
        } else if (dealerHand.getHandValue() >= playerHand.getHandValue()) {
            out.println("the dealer has " + dealerHand.getHandValue() + " and beats your " + playerHand.getHandValue() + ". The dealer wins!");
            gamesLost++;
            myMoney.subtractMoney();
        }
    }

    /**
     * Method used to determine if user wants to play another hand of blackjack.  Clears arrays
     * at the end of the game before the start of the next game.
     */
    private static void playAgain() {
        Scanner in = new Scanner(System.in);
        out.println();
        out.println("Your current win:loss ratio is: " + gamesWon + " : " + gamesLost);
        out.println("Would you like to play again? 'y/n'? ");
        String playAgainAnswer = in.nextLine();
        playerHand.clearHand();
        dealerHand.clearHand();

        if (playAgainAnswer.equalsIgnoreCase("y")) {
            mainBlackJackGame();
        } else if (playAgainAnswer.equalsIgnoreCase("n")) {
            out.println();
            out.println("Thanks for playing, good bye.");
        } else {
            out.println("I don't understand the response of " + playAgainAnswer + ". Please check that your response is correct");
            playAgain();
        }
    }

    /**
     * Method for drawing a new card from the deck and adding it to the dealer's hand
     */
    private static void dealerDrawCard() {
        dealerHand.drawCard();
        out.println("A " + dealerHand.getLastCardName() + " of " + dealerHand.getLastCardSuit() +
                " was drawn for a value of: " + dealerHand.getLastCardValue());
    }
}





