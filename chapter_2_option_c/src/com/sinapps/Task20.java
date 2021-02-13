package com.sinapps;
/*
    Ввести с консоли n-размерность матрицы a [n] [n].
    Задать значения элементов матрицы в интервале значений
    от -n до n с помощью датчика случайных чисел.

    20. Путем перестановки элементов квадратной вещественной матрицы добиться того,
    чтобы ее максимальный элемент находился в левом верхнем углу,
    следующий по величине — в позиции (2, 2), следующий по величине —
    в позиции (3, 3) и т. д., заполнив таким образом всю главную диагональ.
 */

import java.util.Random;
import java.util.Scanner;

public class Task20 {
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

        for (int k = 0; k < a.length; k++) {
            int maxRow = k;
            int maxColumn = 0;

            for (int i = 0; i < a.length; i++) {
                for (int j = 0; j < a[i].length; j++) {
                    if (a[i][j] > a[maxRow][maxColumn] && i != j) {
                        maxRow = i;
                        maxColumn = j;
                    } else if (a[i][j] > a[maxRow][maxColumn] && i == j) {
                        if (i >= k) {
                            maxRow = i;
                            maxColumn = j;
                        }
                    }
                }
            }

            int temp = a[k][k];
            a[k][k] = a[maxRow][maxColumn];
            a[maxRow][maxColumn] = temp;
        }

        System.out.println("Преобразованная матрица: ");
        for (int[] row : a) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }

        System.out.println("\n***********************************");
        System.out.println("Разработчик: sinapps");
        System.out.println("Задание получено: 2021.01.11 12:35");
        System.out.println("Задание выполнено: 2021.01.11 19:54");
    }
}
