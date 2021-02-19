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

    public static Fraction sum(Fraction fractionLeft, Fraction fractionRight) {
        // сумма дробей
        return new Fraction(fractionLeft.getNumerator() * fractionRight.getDenominator() + fractionLeft.getDenominator() * fractionRight.getNumerator(),
                fractionLeft.getDenominator() * fractionRight.getDenominator());
    }

    public static Fraction difference(Fraction fractionLeft, Fraction fractionRight) {
        // разность дробей
        return new Fraction(fractionLeft.getNumerator() * fractionRight.getDenominator() - fractionRight.getNumerator() * fractionLeft.getDenominator(),
                fractionLeft.getDenominator() * fractionRight.getDenominator());
    }

    public static Fraction multiplication(Fraction fractionLeft, Fraction fractionRight) {
        // умножение дробей
        return new Fraction(fractionLeft.getNumerator() * fractionRight.getNumerator(),
                fractionLeft.getDenominator() * fractionRight.getDenominator());
    }

    public static Fraction division(Fraction fractionLeft, Fraction fractionRight) {
        // деление дробей
        return new Fraction(fractionLeft.getNumerator() * fractionRight.getDenominator(),
                fractionLeft.getDenominator() * fractionRight.getNumerator());
    }

    @Override
    public String toString() {
        return "Дробь: " + numerator + " / " + denominator + " = " + String.format("%.3f", getResult());
    }
}
