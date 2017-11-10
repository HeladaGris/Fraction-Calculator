/*
* Microsoft: DEV277x Object Oriented Programming in Java
* Module 2 Project - Fraction Calculator
* by Serhii Moroz
* FractionCalculator.java - Client Class
 */

import java.util.Scanner;
// The FractionCalculator class is a class that will allow the user to enter in fractions and operations, calculating and displaying the result
// It will run until the user tells it to quit
public class FractionCalculator {
    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);

        Fraction test1 = new Fraction (-1, 2);

        //System.out.println(test1.numerator + " " + test1.denominator);
        System.out.println(test1.getNumerator());
        System.out.println(test1.getDenominator());
        System.out.println(test1.toString());
        System.out.println(test1.toDouble());

    }
}
