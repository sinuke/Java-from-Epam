package com.sinapps;
/*
    Ввести с консоли n целых чисел. На консоль вывести:
    4. Числа, которые делятся на 5 и на 7.
 */

import java.util.Scanner;

public class Task04 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Введите число элементов n: ");
        int n = input.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < a.length; i++) {
            System.out.print((i + 1) + "-й элемент: ");
            a[i] = input.nextInt();
        }

        System.out.println("Числа, которые делятся на 5 и 7:");
        for (int value : a) {
            if (value % 5 == 0 && value % 7 == 0) {
                System.out.print(value + " ");
            }
        }
    }
}
