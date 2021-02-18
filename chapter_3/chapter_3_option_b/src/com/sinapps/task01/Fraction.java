package com.sinapps.task01;

public class Fraction {
    private int numerator; // числитель
    private int denominator; // знаменатель

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    public double getResult () {
        return (double) numerator / (double) denominator;
    }

    public static double getResult(int numerator, int denominator) {
        return (double) numerator / (double) denominator;
    }

    @Override
    public String toString() {
        return "Дробь: " + numerator + " / " + denominator + " = " + String.format("%.3f", getResult());
    }
}
