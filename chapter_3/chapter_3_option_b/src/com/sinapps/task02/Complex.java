package com.sinapps.task02;

public class Complex {
    private double real;
    private double imaginary;

    public Complex(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public double getReal() {
        return real;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public double getImaginary() {
        return imaginary;
    }

    public void setImaginary(double imaginary) {
        this.imaginary = imaginary;
    }

    public static Complex sum(Complex left, Complex right) {
        return new Complex(left.getReal() + right.getReal(), left.getImaginary() + right.getImaginary());
    }

    public static Complex difference(Complex left, Complex right) {
        return new Complex(left.getReal() - right.getReal(), left.getImaginary() - right.getImaginary());
    }

    public static Complex multiplication(Complex left, Complex right) {
        return new Complex(left.getReal() * right.getReal() - left.getImaginary() * right.getImaginary(),
                left.getReal() * right.getImaginary() + right.getReal() * left.getImaginary());
    }

    public static Complex division(Complex left, Complex right) {
        double newReal = (left.getReal() * right.getReal() + left.getImaginary() * right.getImaginary()) / (Math.pow(right.getReal(), 2) + Math.pow(right.getImaginary(), 2));
        double newImaginary = (right.getReal() * left.getImaginary() - left.getReal() * right.getImaginary()) / (Math.pow(right.getReal(), 2) + Math.pow(right.getImaginary(), 2));
        return new Complex(newReal, newImaginary);
    }

    @Override
    public String toString() {
        return String.format("%.3f", real) + ((imaginary >= 0) ? " + " : " - ") + String.format("%.3f", Math.abs(imaginary)) + "i";
    }
}
