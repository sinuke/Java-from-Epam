package com.sinapps;
/*
    Ввести с консоли n целых чисел. На консоль вывести:
    2. Наибольшее и наименьшее число.
 */

import java.util.Scanner;

public class Task02 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Введите число элементов n: ");
        int n = input.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < a.length; i++) {
            System.out.print((i + 1) + "-й элемент: ");
            a[i] = input.nextInt();
        }

        if (n > 0) {
            int min = a[0], max = a[0];
            for (int value : a) {
                if (value > max) {
                    max = value;
                }
                if (value < min) {
                    min = value;
                }
            }

            System.out.println("Максимальное: " + max);
            System.out.println("Минимальное: " + min);
        } else {
            System.out.print("Нет максимального и минимального значения");
        }
    }
}
