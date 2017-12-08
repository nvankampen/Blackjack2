package com.example.java;

import javax.xml.bind.SchemaOutputResolver;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
    	String firstValue;
	    String secondValue;

		Scanner in = new Scanner(System.in);
		System.out.println("Enter in two numbers to add together");
		System.out.println("Enter first number");
		firstValue = in.nextLine();
		System.out.println("Enter a second number");
		secondValue = in.nextLine();

		int firstInt = Integer.parseInt(firstValue);
		int secondInt = Integer.parseInt(secondValue);

		int intTotal = firstInt + secondInt;
		System.out.println("The total is " + intTotal);

	}
}
