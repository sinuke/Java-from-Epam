package com.sinapps;
/*
    Ввести n чисел с консоли.
    Найти число, цифры в котором идут в строгом порядке возрастания. Если
    таких чисел несколько, найти первое из них.
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

        for (int value : a) {
            if (isRisingDigits(value)) {
                System.out.println("Число, цифры которого строго возрастают: " + value);
                break;
            }
        }

        System.out.println("\n***********************************");
        System.out.println("Разработчик: sinapps");
        System.out.println("Задание получено: 2021.01.06 21:01");
        System.out.println("Задание выполнено: 2021.01.06 21:22");
    }

    public static boolean isRisingDigits(int value) {
        boolean result = true;
        int digitsCount = getDigitsCount(value);
        int[] digits = new int[digitsCount];
        int digitIndex = digitsCount - 1;
        while (value > 0) {
            digits[digitIndex] = value % 10;
            if (digitIndex < digitsCount - 1 && digits[digitIndex] >= digits[digitIndex + 1]) {
                result = false;
                break;
            }
            digitIndex--;
            value /= 10;
        }
        return result;
    }

    public static int getDigitsCount(int value) {
        int digitsCount = 0;
        while (value > 0) {
            digitsCount++;
            value /= 10;
        }
        return digitsCount;
    }
}
