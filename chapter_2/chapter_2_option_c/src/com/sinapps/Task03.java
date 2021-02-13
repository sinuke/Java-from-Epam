package com.sinapps;
/*
    Ввести с консоли n-размерность матрицы a [n] [n].
    Задать значения элементов матрицы в интервале значений
    от -n до n с помощью датчика случайных чисел.

    3. Найти и вывести наибольшее число возрастающих (убывающих)
    элементов матрицы, идущих подряд.
 */

import java.util.Random;
import java.util.Scanner;

public class Task03 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n;
        do {
            System.out.print("Введите размер матрицы n: ");
            n = input.nextInt();
        } while (n < 1);

        System.out.println("Матрица: ");
        int[][] a = new int[n][n];
        Random random = new Random();
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                a[i][j] = n - random.nextInt(2 * n + 1);
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }

        int risingCountMax = 1;
        int risingCount = 1;
        int lastValue = a[0][0];
        for (int[] row : a) {
            for (int value : row) {
                if (value > lastValue) {
                    risingCount++;
                } else {
                    if (risingCount > risingCountMax) {
                        risingCountMax = risingCount;
                    }
                    risingCount = 1;
                }
                lastValue = value;
            }
        }

        if (risingCount > risingCountMax) {
            risingCountMax = risingCount;
        }

        System.out.print("Максимальное число возрастающих подряд элементов: " + risingCountMax);

        System.out.println("\n***********************************");
        System.out.println("Разработчик: sinapps");
        System.out.println("Задание получено: 2021.01.07 22:25");
        System.out.println("Задание выполнено: 2021.01.07 22:44");
    }
}
