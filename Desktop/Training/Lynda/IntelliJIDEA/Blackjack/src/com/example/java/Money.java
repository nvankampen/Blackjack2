package com.example.java;

/**
 * Money class used to manage the player's money related to betting
 */
class Money {
    private int moneyTotal = 100;
    private int betAmount = 0;

    Money() {
    }

    /**
     * Sets the amount of money being betted on a hand
     */
    void setBet(int betAmount){
        this.betAmount = betAmount;
    }

    /**
     * Returns total money
     * @return moneyTotal
     */
    int getMoneyTotal(){
        return moneyTotal;
    }

    /**
     * Adds winnings to money total
     */
    void addMoney(){
        moneyTotal = moneyTotal + betAmount;
    }

    /**
     * Subtracts losses from money total
     */
    void subtractMoney(){
        moneyTotal = moneyTotal - betAmount;
    }

}
