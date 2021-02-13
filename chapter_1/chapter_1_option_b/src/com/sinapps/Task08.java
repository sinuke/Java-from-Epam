package com.sinapps;
/*
    Ввести с консоли n целых чисел. На консоль вывести:
    8. Простые числа.
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

        System.out.println("Простые числа: ");
        for (int i = 0; i < a.length; i++) {
            if (a[i] > 1) {
                boolean isSimple = true;
                for (int j = 2; j < a[i]; j++) {
                    if (a[i] % j == 0) {
                        isSimple = false;
                    }
                }

                if (isSimple) {
                    System.out.print(a[i] + " ");
                }
            }
        }
    }
}
