package com.sinapps.task01;

public class FractionsChanger {
    public static Fraction[] change(Fraction[] fractions) {
        final int LENGTH = fractions.length;
        Fraction[] result = new Fraction[LENGTH];
        for (int i = 0; i < LENGTH; i++) {
            if (i % 2 == 0 && i < LENGTH - 1) {
                Fraction fraction = Fraction.sum(fractions[i], fractions[i + 1]);
                result[i] = fraction;
            } else {
                result[i] = fractions[i];
            }
        }
        return result;
    }
}
