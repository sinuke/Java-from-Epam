package com.sinapps;
/*
    Ввести с консоли n целых чисел. На консоль вывести:
    12. Числа Фибоначчи: f0 = f1 = 1, f (n) = f (n–1) + f (n–2).
 */

import java.util.Scanner;

public class Task12 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Введите число элементов n: ");
        int n = input.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < a.length; i++) {
            System.out.print((i + 1) + "-й элемент: ");
            a[i] = input.nextInt();
        }

        System.out.println("Числа Фибоначчи: ");
        for (int value : a) {
            if (value == 0 || Math.abs(value) == 1 || isFibonacci(value)) {
                System.out.print(value + " ");
            }
        }
    }

    public static boolean isFibonacci(int value) {
        boolean result = false;
        if (Math.abs(value) > 1) {
            int calculatedValue = 0;
            int F0 = 0;
            int F1;
            F1 = (value >= 0) ? 1 : -1;
            while (Math.abs(calculatedValue) < Math.abs(value)) {
                calculatedValue = F0 + F1;
                if (calculatedValue == value) {
                    result = true;
                }
                F0 = F1;
                F1 = calculatedValue;
            }
        }

        return result;
    }
}
