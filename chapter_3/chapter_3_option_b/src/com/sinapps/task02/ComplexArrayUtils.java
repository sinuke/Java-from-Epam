package com.sinapps.task02;

public class ComplexArrayUtils {
    public static Complex calculateSum(Complex[] arr) {
        Complex result = arr[0];
        for (int i = 1; i < arr.length; i++) {
            result = Complex.sum(result, arr[i]);
        }
        return result;
    }

    public static Complex calculateMultiplication(Complex[] arr) {
        Complex result = arr[0];
        for (int i = 1; i < arr.length; i++) {
            result = Complex.multiplication(result, arr[i]);
        }
        return result;
    }
}
