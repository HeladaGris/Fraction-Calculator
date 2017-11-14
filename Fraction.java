/*
* Microsoft: DEV277x Object Oriented Programming in Java
* Module 2 Project - Fraction Calculator
* by Serhii Moroz
* Fraction.java - Object Class
 */

// Class will have several constructors and both private and public methods implementing the behavior of a fraction
public class Fraction { // is an object that holds information about a fraction (numerator and denominator)

    // The STATE of an object (fields declaration, object's fields)
    private int numerator; // числитель
    private int denominator;// знаменатель

    // CONSTRUCTORS
    // two parameter constructor that initializes the numerator and demoninator
    // Fraction frac = new Fraction(4, 5) would create a Fraction with numerator equal to 4 and denominator equal to 5
    public Fraction (int nmrtr, int dnmntr) {
        // This constructor should throw an IllegalArgumentException if the denominator is zero!
        if(dnmntr == 0) throw new IllegalArgumentException(); // Makes Exception in thread "main" java.lang.IllegalArgumentException, Process will finish with exit code 1
        // If the user enters a negative denominator bump the negative sign to the numerator. For example, -3/-2 should be converted to 3/2. Likewise, 5/-3 should be converted to -5/3.
        if(dnmntr < 0) {
            this.numerator = -1 * nmrtr;
            this.denominator = -1 * dnmntr;
        } else {
            this.numerator = nmrtr;
            this.denominator = dnmntr;
        }
    }

    // one parameter constructor that initializes the object equal in value to the integer parameter
    // Fraction frac = new Fraction(3) would create a Fraction with numerator equal to 3 and denominator equal to 1.
    public Fraction (int nmrtr) {
        this(nmrtr, 1);
    }

    // zero parameter constructor that initializes the object to 0, meaning the numerator is 0 and the denominator is 1
    // Equivalent to new Fraction(0);
    public Fraction () {
        this(0, 1);
    }

    // METHODS
    // getNumerator - exposes the value of the numerator field to the user
    public int getNumerator() {return this.numerator;}
    // getDenominator - exposes  the value of the denominator field to the user
    public int getDenominator() {return this.denominator;}
    // toString() - "numerator/denominator", a String representation of the Fraction
    public String toString() {return this.numerator + "/" + this.denominator;}
    // toDouble() - the result of numerator / denominator
    public double toDouble() {
        return (double)this.numerator / (double)this.denominator;}
    // add() - returns a new Fraction that is the sum of other and this fractions
    public Fraction add(Fraction fractionOther) {
        this.numerator = this.numerator + fractionOther.numerator;
        this.denominator = this.denominator + fractionOther.denominator;
        Fraction adding = new Fraction (this.numerator, this.denominator);
        return adding;
    }
    // subtract() - returns a new Fraction that is the difference between the other and this fraction
    public Fraction subtract(Fraction fractionOther) {
        this.numerator = this.numerator - fractionOther.numerator;
        this.denominator = this.denominator - fractionOther.denominator;
        Fraction subtracting = new Fraction (this.numerator, this.denominator);
        return subtracting;
    }
    // multiply() - returns a new Fraction that is the product of the other and this fraction
    public Fraction multiply(Fraction fractionOther) {
        this.numerator = this.numerator * fractionOther.numerator;
        this.denominator = this.denominator * fractionOther.denominator;
        Fraction multipling = new Fraction (this.numerator, this.denominator);
        return multipling;
    }
    // divide() - returns a new Fraction that is the division of the other and this fraction, throw an IllegalArgumentException() if the user askes you to divide by 0
    public Fraction divide(Fraction fractionOther) {
        this.numerator = this.numerator * fractionOther.denominator;
        this.denominator = this.denominator * fractionOther.numerator;
        Fraction dividing = new Fraction (this.numerator, this.denominator);
        return dividing;
    }
    // equals() - must take in an "Object" to properly override the Obect class's equals method, but should ultimately check if two fractions are equal
    public boolean equals(Fraction fractionOther) {
        if(this.toDouble() == fractionOther.toDouble()) {
            return true;
        } else {
            return false;
        }
    }
    // toLowestTerms() - converts the current fraction to the lowest terms
    public Fraction toLowestTerms() {
        int gcd = gcd(this.numerator, this.denominator);
        this.numerator = this.numerator / gcd;
        this.denominator = this.denominator / gcd;
        return new Fraction(this.numerator, this.denominator);
        }
    // gcd() - takes in two ints and determines the greatest common divisor of the two ints, should be a static method
    // greatest common divisor - наибольший общий делитель
    // реализовано при помощи Алгоритма Евклида (Euclidean Algorithm)
    public static int gcd(int nmrtr, int dnmntr) {
        while (dnmntr != 0) {
            int storage = nmrtr % dnmntr;
            nmrtr = dnmntr;
            dnmntr = storage;
        }
        return nmrtr;
    }
}
