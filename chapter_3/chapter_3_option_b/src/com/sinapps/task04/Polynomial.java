package com.sinapps.task04;

public class Polynomial {
    private double[] polynomial;

    public Polynomial(double[] polynomial) {
        setPolynomial(polynomial);
    }

    public int getPow() {
        return polynomial.length - 1;
    }

    public double[] getPolynomial() {
        return polynomial;
    }

    public void setPolynomial(double[] polynomial) {
        this.polynomial = polynomial;
    }

    public static Polynomial sum(Polynomial left, Polynomial right) {
        final int LENGTH = Math.max(left.getPolynomial().length, right.getPolynomial().length);
        double[] arr = new double[LENGTH];

        if (left.getPow() == right.getPow()) {
            for (int i = 0; i < LENGTH; i++) {
                arr[i] = left.getPolynomial()[i] + right.getPolynomial()[i];
            }
        } else if (left.getPow() > right.getPow()) {
            for (int i = 0; i < LENGTH; i++) {
                arr[i] = left.getPolynomial()[i];
                if (i >= LENGTH - right.getPolynomial().length) {
                    arr[i] += right.getPolynomial()[i - LENGTH + right.getPolynomial().length];
                }
            }
        } else {
            for (int i = 0; i < LENGTH; i++) {
                arr[i] = right.getPolynomial()[i];
                if (i >= LENGTH - left.getPolynomial().length) {
                    arr[i] += left.getPolynomial()[i - LENGTH + left.getPolynomial().length];
                }
            }
        }

        return new Polynomial(arr);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < polynomial.length; i++) {
            result.append(String.format("%.3f", polynomial[i]));
            if (getPow() - i != 0) {
                result.append("x^").append(getPow() - i);
            }

            if (i < polynomial.length - 1) {
                result.append(" + ");
            }
        }
        return result.toString();
    }
}
