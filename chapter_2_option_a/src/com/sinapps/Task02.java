package com.sinapps;
/*
    Ввести n чисел с консоли.
    Упорядочить и вывести числа в порядке возрастания (убывания) значений
    их длины.
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

        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - i- 1; j++) {
                if (getDigitsCount(a[j]) > getDigitsCount(a[j + 1])) {
                    int temp = a[j + 1];
                    a[j + 1] = a[j];
                    a[j] = temp;
                }
            }
        }

        System.out.println("Отсортированный массив по возрастанию длины чисел:");
        for (int value : a) {
            System.out.print(value + " ");
        }

        System.out.println("\n***********************************");
        System.out.println("Разработчик: sinapps");
        System.out.println("Задание получено: 2021.01.06 06:37");
        System.out.println("Задание выполнено: 2021.01.06 06:41");
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
