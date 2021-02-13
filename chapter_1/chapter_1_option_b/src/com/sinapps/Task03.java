package com.sinapps;
/*
    Ввести с консоли n целых чисел. На консоль вывести:
    3. Числа, которые делятся на 3 или на 9.
 */

import java.util.Scanner;

public class Task03 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Введите число элементов n: ");
        int n = input.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < a.length; i++) {
            System.out.print((i + 1) + "-й элемент: ");
            a[i] = input.nextInt();
        }

        System.out.println("Числа, которые делятся на 3 или 9:");
        for (int value : a) {
            if (value % 3 == 0) {
                System.out.print(value + " ");
            }
        }
    }
}
