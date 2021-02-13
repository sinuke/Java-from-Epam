package com.sinapps;
/*
    Ввести с консоли n-размерность матрицы a [n] [n].
    Задать значения элементов матрицы в интервале значений
    от -n до n с помощью датчика случайных чисел.

    4. Найти сумму элементов матрицы, расположенных между первым и
    вторым положительными элементами каждой строки.
 */

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Task04 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n;
        do {
            System.out.print("Введите размер матрицы n: ");
            n = input.nextInt();
        } while (n < 1);

        System.out.println("Матрица: ");
        int[][] a = new int[n][n];
        int[][] positiveIndexes = new int[n][2];

        Random random = new Random();
        for (int i = 0; i < a.length; i++) {
            int index = -1;
            Arrays.fill(positiveIndexes[i], -1);
            for (int j = 0; j < a[i].length; j++) {
                a[i][j] = n - random.nextInt(2 * n + 1);
                System.out.print(a[i][j] + " ");
                if (a[i][j] > 0 && index < 1) {
                    index++;
                    positiveIndexes[i][index] = j;
                }
            }
            System.out.println();
        }

        int totalSum = 0;
        for (int i = 0; i < a.length; i++) {
            int lineSum = 0;
            for (int j = 0; j < a[i].length; j++) {
                if (j > positiveIndexes[i][0] && j < positiveIndexes[i][1]) {
                    lineSum += a[i][j];
                }
            }
            totalSum += lineSum;
        }

        System.out.print("Сумма элементов, расположенных между 1-м и 2-м положительными элементами каждой строки: " + totalSum);

        System.out.println("\n***********************************");
        System.out.println("Разработчик: sinapps");
        System.out.println("Задание получено: 2021.01.08 11:44");
        System.out.println("Задание выполнено: 2021.01.08 14:02");
    }
}
