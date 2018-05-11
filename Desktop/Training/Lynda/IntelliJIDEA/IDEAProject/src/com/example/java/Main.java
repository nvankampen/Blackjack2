package com.example.java;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
    	String firstValue;
	    String secondValue;
	    String operationType;
		double firstDouble = 0;
		double secondDouble = 0;
		double doubleTotal = 0;

		Scanner in = new Scanner(System.in);
		System.out.println("Enter in two numbers to add together");
		System.out.println("Enter first number");
		firstValue = in.nextLine();
		System.out.println("Enter a second number");
		secondValue = in.nextLine();
		System.out.println("Pick an operation: + - * / ");
		operationType = in.nextLine();

		try {
			firstDouble = Double.parseDouble(firstValue);
		} catch (NumberFormatException e) {
			System.out.println("The first value of " + firstValue + " is not a valid value");
			System.exit(0);
		}
		try {
			secondDouble = Double.parseDouble(secondValue);
		} catch (NumberFormatException e) {
			System.out.println("The second value of " + secondValue + " is not a valid value");
			System.exit(0);
		}



		switch(operationType){
			case "+": doubleTotal = firstDouble + secondDouble;
					break;
			case "-": doubleTotal = firstDouble - secondDouble;
					break;
			case "*": doubleTotal = firstDouble * secondDouble;
					break;
			case "/": doubleTotal	= firstDouble / secondDouble;
					break;
			default: System.out.println("The operator of " + operationType + " is an incorrect value");
					System.exit(0);
					break;
		}
		System.out.println("The result is " + Math.round(doubleTotal * 100.0)/100.0);

	}
}
