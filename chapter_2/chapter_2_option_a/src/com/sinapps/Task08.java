package com.sinapps;
/*
    Ввести n чисел с консоли.
    Среди чисел найти число-палиндром. Если таких чисел больше одного,
    найти второе.
 */

import java.util.Scanner;

public class Task08 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Введите число элементов n: ");
        int n = input.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < a.length; i++) {
            System.out.print((i + 1) + "-й элемент: ");
            a[i] = input.nextInt();
        }

        int palindromesCount = 0;
        for (int value : a) {
            if (isPalindrome(value)) {
                palindromesCount++;
                System.out.println(palindromesCount + ". Число-палиндром: " + value);
            }

            if (palindromesCount == 2) {
                break;
            }
        }

        System.out.println("\n***********************************");
        System.out.println("Разработчик: sinapps");
        System.out.println("Задание получено: 2021.01.06 20:49");
        System.out.println("Задание выполнено: 2021.01.06 20:52");
    }

    public static boolean isPalindrome(int value) {
        return value == reverseNumber(value);
    }

    public static int reverseNumber(int number) {
        int value = number;
        int total = 0;
        while (value > 0) {
            total = total * 10 + value % 10;
            value /= 10;
        }
        return total;
    }
}
