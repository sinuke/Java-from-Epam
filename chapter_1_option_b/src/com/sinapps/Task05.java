package com.sinapps;
/*
    Ввести с консоли n целых чисел. На консоль вывести:
    5. Элементы, расположенные методом пузырька по убыванию модулей.
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

        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - i- 1; j++) {
                if (Math.abs(a[j]) < Math.abs(a[j + 1])) {
                    int temp = a[j + 1];
                    a[j + 1] = a[j];
                    a[j] = temp;
                }
            }
        }

        System.out.println("Отсортированный массив по убыванию модулей элементов:");
        for (int value : a) {
            System.out.print(value + " ");
        }
    }
}
