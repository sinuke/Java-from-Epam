package com.sinapps;
/*
    Ввести n чисел с консоли.
    Найти количество чисел, содержащих только четные цифры, а среди них —
    количество чисел с равным числом четных и нечетных цифр.
    !!!! ВОЗМОЖНО ОШИБКА В УСЛОВИИ. ДАЛЕЕ РЕШЕНИЕ ДЛЯ УСЛОВИЯ:
    Найти количество чисел, содержащих только четные цифры, среди чисел, состоящих из четных и нечетных —
    количество чисел с равным числом четных и нечетных цифр.
 */

import java.util.Scanner;

public class Task05 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Введите число элементов n: ");
        int n = input.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < a.length; i++) {
            System.out.print((i + 1) + "-й элемент: ");
            a[i] = input.nextInt();
        }

        int evenDigitsValuesCount = 0;
        int countEvenAndUnEvenDigits = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] % 2 == 0 && isEvenDigits(a[i])) {
                evenDigitsValuesCount++;
            } else if (getEvenDigitsCount(a[i]) == getUnevenDigitsCount(a[i])) {
                countEvenAndUnEvenDigits++;
            }
        }
        System.out.println("Количество чисел, состоящих из только из четных цифр: " + evenDigitsValuesCount);
        System.out.println("Количество чисел, с равным количеством четных и нечетных чисел: " + countEvenAndUnEvenDigits);
        System.out.println("\n***********************************");
        System.out.println("Разработчик: sinapps");
        System.out.println("Задание получено: 2021.01.06 08:54");
        System.out.println("Задание выполнено: 2021.01.06 09:27");
    }

    public static boolean isEvenDigits(int value) {
        boolean result = true;
        while (result && value > 0) {
            int digit = value % 10;

            if (digit % 2 != 0) {
                result = false;
            }
            value /= 10;
        }
        return result;
    }

    public static int getEvenDigitsCount(int value) {
        int result = 0;
        while (value > 0) {
            int digit = value % 10;
            if (digit % 2 == 0) {
                result++;
            }
            value /= 10;
        }
         return result;
    }

    public static int getUnevenDigitsCount(int value) {
        int result = 0;
        while (value > 0) {
            int digit = value % 10;
            if (digit % 2 != 0) {
                result++;
            }
            value /= 10;
        }
        return result;
    }
}
