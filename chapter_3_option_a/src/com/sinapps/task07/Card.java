package com.sinapps.task07;

public class Card {
    private final int[] number = new int[4];

    public Card(int number1, int number2, int number3, int number4) throws IllegalArgumentException {
        if ((number1>= 0 && number1 <= 9999) && (number2 >= 0 && number2 <= 9999) &&
                (number3 >= 0 && number3 <= 9999) && (number4 >= 0 && number4 <= 9999)) {
            this.number[0] = number1;
            this.number[1] = number2;
            this.number[2] = number3;
            this.number[3] = number4;
        } else {
            throw new IllegalArgumentException("Блок номера кредитной карты не может быть меньше 0000 и больше 9999");
        }
    }

    public Boolean inInterval(int number1, int number4) {
        return (this.number[0] >= number1 && this.number[3] <= number4);
    }

    @Override
    public String toString() {
        return String.format("%04d", number[0]) + "-" + String.format("%04d", number[1]) + "-" +
                String.format("%04d", number[2]) + "-" + String.format("%04d", number[3]);
    }
}
