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
        String userInput = "";
        boolean operationEquals;

        Scanner input1 = new Scanner(System.in);
        Scanner input2 = new Scanner(System.in);

        System.out.println("This program is a fraction calculator");
        System.out.println("It will add, subtract, multiply and divide fractions until you type Q to quit.");
        System.out.println("Please enter your fractions in the form a/b, where a and b are integers.");
        System.out.println("-------------------------------------------------------------------------------");

        userInput = getOperation(userInput);
        while (userInput.equalsIgnoreCase("Q") != true) {
            System.out.print("Please enter a fraction (a/b) or integer (a): ");
            String userInput1 = input1.nextLine();
            Fraction first = getFraction(userInput1);

            System.out.print("Please enter a fraction (a/b) or integer (a): ");
            String userInput2 = input2.nextLine();
            Fraction second = getFraction(userInput2);

            if (userInput.equals("+")) {
                System.out.println(first.getNumerator() + "/" + first.getDenominator() + " " + userInput + " " + second.getNumerator() + "/" + second.getDenominator() + " = " + (first.add(second)).toLowestTerms());
            }
            if (userInput.equals("-")) {
                System.out.println(first.getNumerator() + "/" + first.getDenominator() + " " + userInput + " " + second.getNumerator() + "/" + second.getDenominator() + " = " + (first.subtract(second)).toLowestTerms());
            }
            if (userInput.equals("/")) {
                System.out.println(first.getNumerator() + "/" + first.getDenominator() + " " + userInput + " " + second.getNumerator() + "/" + second.getDenominator() + " = " + (first.divide(second)).toLowestTerms());
            }
            if (userInput.equals("*")) {
                System.out.println(first.getNumerator() + "/" + first.getDenominator() + " " + userInput + " " + second.getNumerator() + "/" + second.getDenominator() + " = " + (first.multiply(second)).toLowestTerms());
            }
            if (userInput.equals("=")) {
                operationEquals = first.equals(second);
                System.out.println(first.getNumerator() + "/" + first.getDenominator() + " " + userInput + " " + second.getNumerator() + "/" + second.getDenominator() + " is " + operationEquals);
            }
            System.out.println("-------------------------------------------------------------------------------");
            userInput = getOperation(userInput);
        }

        //System.out.println(isNumber("01 23456789"));

        /*System.out.print("Please enter a fraction (a/b) or integer (a): ");
        String userInput2 = input1.nextLine();
        Fraction test4 = getFraction(userInput2);
        System.out.println(test4.getNumerator());
        System.out.println(test4.getDenominator());*/

        //boolean validFraction = validFraction(userInput2);
        //System.out.println("validFraction is: " + validFraction);

        /*if (validFraction == true) {
            Fraction test4 = getFraction(userInput2);
            System.out.println(test4.getNumerator());
            System.out.println(test4.getDenominator());
        } else {
            while (validFraction == false);
        }*/

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
    /* getOperation() - Asks the user to enter in a valid mathematical operation.
    * If the user enters anything except “+”, “-“, “/”, “*”, “=”, “q”, or “Q” it should re-prompt them until there is valid input */
    public static String getOperation(String uInpt) {
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter an operation (+, -, /, *, = or Q to quit): ");
        uInpt = input.nextLine();

        while (!uInpt.equals("+") && !uInpt.equals("-") && !uInpt.equals("/") && !uInpt.equals("*") && !uInpt.equals("=") && !uInpt.equals("Q") && !uInpt.equals("q")) {
            System.out.print("Invalid input (+, -, /, *, = or Q to quit): ");
            uInpt = input.nextLine();
        }
        return uInpt;
    }
    // validFraction() - returns true if the parameter is in the form "a/b" where a is any int and b is any positive int
    public static boolean validFraction(String uInpt) {
        /* The first character may or may not be a ‘-‘ character.
        * If a negative shows up anywhere else, then it is not a valid fraction. */
        if (!uInpt.contains("/-")) {
            uInpt = uInpt.replaceAll("-", ""); // It may be helpful to remove the ‘-‘ character if there is one
            //System.out.println(uInpt);
            if (uInpt.contains("/")) {
                // If there is a ‘/’ character, then it may be helpful to create substrings for the numerator and denominator
                String subNumerator = uInpt.substring(0, uInpt.indexOf("/"));
                //System.out.println(subNumerator);
                String subDenominator = uInpt.substring(uInpt.indexOf("/") + 1, uInpt.length());;
                //System.out.println(subDenominator);
                // Both substrings must be non-empty, The denominator cannot be “0”
                if (subNumerator.equals("") || subDenominator.equals("") || subDenominator.equals("0")) {
                    return false;
                } else {
                    // Both must be entirely made of numbers
                    if (isNumber(subNumerator) == true && isNumber(subDenominator) == true) {
                        return true;
                    } else {
                        return false;
                    }
                }
            } else {
                // If there is no ‘/’ character, then every character in the string must be a number (if you removed the ‘-‘ sign)
                if (uInpt.equals("")) {
                    return false;
                } else {
                    if (isNumber(uInpt) == true) {
                        return true;
                    } else {
                        return  false;
                    }
                }
            }
        } else {return false;}
    }
    /* It may be useful to create a helper method isNumber() that takes a String as input and returns true if -
    * every character in the String is a number 0-9 and false otherwise.
    * This method can also check for empty strings */
    public static boolean isNumber(String numbers) {
        for (int i = 0; i < numbers.length(); i++) {
            for (int j = 0; j < 10; j++) {
                if (numbers.charAt(i) != '0' && numbers.charAt(i) != '1' && numbers.charAt(i) != '2' && numbers.charAt(i) != '3' && numbers.charAt(i) != '4' && numbers.charAt(i) != '5' && numbers.charAt(i) != '6' && numbers.charAt(i) != '7' && numbers.charAt(i) != '8' && numbers.charAt(i) != '9') {
                    return false;
                }
            }
        }
        return true;
    }
    /* getFraction() - It prompts the user for a String that is a validFraction.
    * If they enter any thing that is not a valid Fraction, it should re-prompt them until it is valid */
    public static Fraction getFraction(String uInpt) {
        Scanner input = new Scanner(System.in);

        while (validFraction(uInpt) == false) {
            System.out.print("Invalid fraction. Please enter (a/b) or (a), where a and b are integers and b is not zero: ");
            uInpt = input.nextLine();
            validFraction(uInpt);
        }
        if (uInpt.contains("/")) {
            // If there is a ‘/’ character, then it may be helpful to create substrings for the numerator and denominator
            String subNumerator = uInpt.substring(0, uInpt.indexOf("/"));
            String subDenominator = uInpt.substring(uInpt.indexOf("/") + 1, uInpt.length());
            int parseNumerator = Integer.parseInt(subNumerator);
            int parseDenominator = Integer.parseInt(subDenominator);
            return new Fraction(parseNumerator, parseDenominator);
        } else {
            // If there is no ‘/’ character, then every character in the string must be a number (if you removed the ‘-‘ sign)
            String subNumerator = uInpt;
            int parseNumerator = Integer.parseInt(subNumerator);
            int parseDenominator = 1;
            return new Fraction(parseNumerator, parseDenominator);
        }
    }
}
