package com.sinapps;
/*
    Ввести n чисел с консоли.
    Вывести на консоль те числа, длина которых меньше (больше) средней,
    а также длину.
 */

import java.util.Scanner;

public class Task03 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Введите число элементов n: ");
        int n = input.nextInt();
        int[] a = new int[n];
        int[] lengths = new int[a.length];
        double averageDigitsLength = 0;

        for (int i = 0; i < a.length; i++) {
            System.out.print((i + 1) + "-й элемент: ");
            a[i] = input.nextInt();
        }

        for (int i = 0; i < a.length; i++) {
           lengths[i] = getDigitsCount(a[i]);
           averageDigitsLength += lengths[i];
        }
        averageDigitsLength = averageDigitsLength / a.length;


        System.out.println("Элементы, длина которых больше средней:");
        for (int i = 0; i < a.length; i++) {
            if (lengths[i] > averageDigitsLength) {
                System.out.print(a[i] + " ");
            }
        }

        System.out.println("\n***********************************");
        System.out.println("Разработчик: sinapps");
        System.out.println("Задание получено: 2021.01.06 06:42");
        System.out.println("Задание выполнено: 2021.01.06 06:52");
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
