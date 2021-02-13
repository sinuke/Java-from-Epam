package com.sinapps;
/*
    Ввести с консоли n целых чисел. На консоль вывести:
    6. Все трехзначные числа, в десятичной записи которых нет одинаковых цифр.
 */

import java.util.Scanner;

public class Task06 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Введите число элементов n: ");
        int n = input.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < a.length; i++) {
            System.out.print((i + 1) + "-й элемент: ");
            a[i] = input.nextInt();
        }

        System.out.println("Числа, в записи которых нет повторяющихся чисел: ");
        for (int value : a) {
            int val = value;
            if (value >= 100 & value < 999) {
                int v1 = val % 10;
                val /= 10;
                int v2 = val % 10;
                val /= 10;
                int v3 = val % 10;

                if (v1 != v2 && v1 != v3 && v2 != v3) {
                    System.out.print(value + " ");
                }
            }
        }
    }
}
