package com.sinapps.task01;

public class FractionsChanger {
    public static Fraction[] change(Fraction[] fractions) {
        final int LENGTH = fractions.length;
        Fraction[] result = new Fraction[LENGTH];
        for (int i = 0; i < LENGTH; i++) {
            if (i % 2 == 0 && i < LENGTH - 1) {
                Fraction fraction = new Fraction(fractions[i].getNumerator() * fractions[i + 1].getDenominator() +
                        fractions[i + 1].getNumerator() * fractions[i].getDenominator(),
                        fractions[i].getDenominator() * fractions[i + 1].getDenominator());
                result[i] = fraction;
            } else {
                result[i] = fractions[i];
            }
        }
        return result;
    }
}
