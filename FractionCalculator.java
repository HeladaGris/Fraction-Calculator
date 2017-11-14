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
        Scanner input1 = new Scanner(System.in);
        Scanner input2 = new Scanner(System.in);

        System.out.println("This program is a fraction calculator");
        System.out.println("It will add, subtract, multiply and divide fractions until you type Q to quit.");
        System.out.println("Please enter your fractions in the form a/b, where a and b are integers.");
        System.out.println("-------------------------------------------------------------------------------");

        System.out.print("Please enter an operation (+, -, /, *, = or Q to quit): ");
        String userInput1 = input1.nextLine();
        String mathematicalOperation = getOperation(userInput1);

        System.out.print("Please enter a fraction (a/b) or integer (a): ");
        String userInput2 = input1.nextLine();
        boolean validFraction = validFraction(userInput2);

        //Fraction test1 = new Fraction (4, 8);
        //Fraction test2 = new Fraction (2, 4);

        //System.out.println(test1.numerator + " " + test1.denominator);
        //System.out.println(test1.getNumerator());
        //System.out.println(test1.getDenominator());
        //System.out.println(test1.toString());
        //System.out.println(test2.toString());
        //System.out.println(test1.toDouble());
        //System.out.println(test1.add(test2));
        //System.out.println(test1.subtract(test2));
        //System.out.println(test1.multiply(test2));
        //System.out.println(test1.divide(test2));
        //System.out.println("Equals: " + test1.equals(test2));
        //System.out.println(Fraction.gcd(test2.getNumerator(), test2.getDenominator()));
        /*test1.toLowestTerms();
        System.out.println(test1.toString());*/
    }
    /*
    * getOperation() - Asks the user to enter in a valid mathematical operation.
    * If the user enters anything except “+”, “-“, “/”, “*”, “=”, “q”, or “Q” it should re-prompt them until there is valid input.
    */
    public static String getOperation(String uInpt) {
        Scanner input = new Scanner(System.in);

        while (!uInpt.equals("+") && !uInpt.equals("-") && !uInpt.equals("/") && !uInpt.equals("*") && !uInpt.equals("=") && !uInpt.equals("Q")) {
            System.out.print("Invalid input (+, -, /, *, = or Q to quit): ");
            uInpt = input.nextLine();
        }
        return uInpt;
    }
    // validFraction() - returns true if the parameter is in the form "a/b" where a is any int and b is any positive int
    public static boolean validFraction(String uInpt) {
        Scanner input = new Scanner(System.in);
        boolean validFraction = false;

        while (validFraction == false) {
            System.out.print("Invalid input (+, -, /, *, = or Q to quit): ");
            uInpt = input.nextLine();
        }
        /*while (!uInpt.equals("+") && !uInpt.equals("-") && !uInpt.equals("/") && !uInpt.equals("*") && !uInpt.equals("=") && !uInpt.equals("Q")) {
            System.out.print("Invalid input (+, -, /, *, = or Q to quit): ");
            uInpt = input.nextLine();
        }*/

        return validFraction;
    }
}
