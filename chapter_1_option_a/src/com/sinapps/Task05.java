package com.sinapps;
/*
    Ввести целые числа как аргументы командной строки, подсчитать их суммы (произведения) и вывести результат на консоль.
 */

public class Task05 {
    public static void main(String[] args) {
        int summ = 0;
        int proizv = 1;

        for (String arg: args) {
            int value = Integer.parseInt(arg);
            summ += value;
            proizv *= value;
        }

        System.out.println("Сумма = " + summ);
        System.out.println("Произведение = " + proizv);
    }
}
