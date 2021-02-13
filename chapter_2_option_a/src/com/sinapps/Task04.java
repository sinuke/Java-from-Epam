package com.sinapps;
/*
    Ввести n чисел с консоли.
    Найти число, в котором число различных цифр минимально. Если таких
    чисел несколько, найти первое из них.
 */

import java.util.Scanner;

public class Task04 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Введите число элементов n: ");
        int n = input.nextInt();
        int[] a = new int[n];
        int[] difDigitsCount = new int[a.length];
        int minDifDigitsCountIndex;

        for (int i = 0; i < a.length; i++) {
            System.out.print((i + 1) + "-й элемент: ");
            a[i] = input.nextInt();
        }

        if (a.length > 0) {
            minDifDigitsCountIndex = 0;
            for (int i = 0; i < a.length; i++) {
                difDigitsCount[i] = getDifferentDigitsCount(a[i]);
                if (difDigitsCount[i] < difDigitsCount[minDifDigitsCountIndex]) {
                    minDifDigitsCountIndex = i;
                }
            }

            System.out.println("Первое число с минимальным количеством разных цифр: " + a[minDifDigitsCountIndex]);
            System.out.print("Количество разных цифр: " + difDigitsCount[minDifDigitsCountIndex]);
        }

        System.out.println("\n***********************************");
        System.out.println("Разработчик: sinapps");
        System.out.println("Задание получено: 2021.01.06 07:42");
        System.out.println("Задание выполнено: 2021.01.06 06:57");
    }

    public static int getDifferentDigitsCount(int value) {
        int[] digitsCount = new int[8];
        int result = 0;
        while (value > 0) {
            int digit = value % 10;
            digitsCount[digit - 1]++;
            value /= 10;
        }
        for (int digit : digitsCount) {
            if (digit > 0) {
                result++;
            }
        }
        return result;
    }
}
