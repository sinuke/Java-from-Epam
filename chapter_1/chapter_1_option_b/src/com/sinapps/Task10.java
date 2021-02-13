package com.sinapps;
/*
    Ввести с консоли n целых чисел. На консоль вывести:
    10. Числа в порядке убывания частоты встречаемости чисел.
 */

import java.util.Arrays;
import java.util.Scanner;

public class Task10 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Введите число элементов n: ");
        int n = input.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < a.length; i++) {
            System.out.print((i + 1) + "-й элемент: ");
            a[i] = input.nextInt();
        }

        // сортировка исходного массива
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - i- 1; j++) {
                if (a[j] < a[j + 1]) {
                    int temp = a[j + 1];
                    a[j + 1] = a[j];
                    a[j] = temp;
                }
            }
        }

        // подсчет количества использования элементов
        int[] freq = new int[a.length];
        Arrays.fill(freq, 0);
        for (int i = 0; i < a.length; i++) {
            for (int value : a) {
                if (value == a[i]) {
                    freq[i]++;
                }
            }
        }

        // сортировка массива частот
        for (int i = 0; i < freq.length - 1; i++) {
            for (int j = 0; j < freq.length - i- 1; j++) {
                if (freq[j] < freq[j + 1]) {
                    int temp = freq[j + 1];
                    freq[j + 1] = freq[j];
                    freq[j] = temp;

                    temp = a[j + 1];
                    a[j + 1] = a[j];
                    a[j] = temp;
                }
            }
        }

        System.out.println("Элементы массива в порядке убывания частоты встречаемости чисел:");
        for (int value : a) {
            System.out.print(value + " ");
        }
    }
}
