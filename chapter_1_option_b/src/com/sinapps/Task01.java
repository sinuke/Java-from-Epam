package com.sinapps;
/*
    Ввести с консоли n целых чисел. На консоль вывести:
    1. Четные и нечетные числа.
 */

import java.util.Scanner;

public class Task01 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Введите число элементов n: ");
        int n = input.nextInt();
        int[] a = new int[n];
        int[] even = new int[n];
        int[] uneven = new int[n];
        int evenCount = 0, unevenCount = 0;

        for (int i = 0; i < a.length; i++) {
            System.out.print((i + 1) + "-й элемент: ");
            a[i] = input.nextInt();

            if (a[i] % 2 == 0) {
                even[evenCount] = a[i];
                evenCount++;
            } else {
                uneven[unevenCount] = a[i];
                unevenCount++;
            }
        }

        System.out.println("Четные числа: ");
        for (int i = 0; i < evenCount; i++) {
            System.out.print(even[i] + " ");
        }

        System.out.println("Нечетные числа: ");
        for (int i = 0; i < unevenCount; i++) {
            System.out.print(uneven[i] + " ");
        }
    }
}
