package com.sinapps.task05;

public class ISBN {
    private final int num1 = 5;
    private final int num2;
    private final int num3;
    private final int num4;

    public ISBN(int num2, int num3) {
        this.num2 = num2;
        this.num3 = num3;
        this.num4 = calculateNum5();
    }

    private int calculateNum5() {
        int sum = 10 * num1;
        int index = 9;
        String[] digits = String.valueOf(num2).split("");
        for (String digit : digits) {
            sum += Integer.parseInt(digit) * index;
            index--;
        }

        digits = String.valueOf(num3).split("");
        for (String digit : digits) {
            sum += Integer.parseInt(digit) * index;
            index--;
        }

        return 11 - sum % 11;
    }

    @Override
    public String toString() {
        String result = num1 + "-" + num2 + "-" + num3 + "-";
        if (num4 == 10) {
            result += "X";
        } else {
            result = result + num4;
        }
        return result;
    }
}
