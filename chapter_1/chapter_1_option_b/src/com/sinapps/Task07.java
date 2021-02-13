package com.sinapps;
/*
    Ввести с консоли n целых чисел. На консоль вывести:
    7. Наибольший общий делитель и наименьшее общее кратное этих чисел.
 */

import java.util.Scanner;

public class Task07 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Введите число элементов n: ");
        int n = input.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < a.length; i++) {
            System.out.print((i + 1) + "-й элемент: ");
            a[i] = input.nextInt();
        }

        if (a.length > 0) {
            int max = a[0];
            for (int value : a) {
                if (value > max) {
                    max = value;
                }
            }

            for (int i = max; i > 0; i--) {
                boolean isGreatestCommonDivisor = true;
                for (int value : a) {
                    if (value % i != 0) {
                        isGreatestCommonDivisor = false;
                        break;
                    }
                }
                if (isGreatestCommonDivisor) {
                    System.out.println("НОД: " + i);
                    break;
                }
            }

            for (int i = 1; i <= max; i++) {
                boolean isLeastCommonMultiple = true;
                for (int value : a) {
                    if (i % value != 0) {
                        isLeastCommonMultiple = false;
                        break;
                    }
                }
                if (isLeastCommonMultiple) {
                    System.out.print("НОК: " + i);
                    break;
                }
            }
        }

    }
}
