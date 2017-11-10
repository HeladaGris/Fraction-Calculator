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

    // to do
}
