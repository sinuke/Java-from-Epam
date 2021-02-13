package com.sinapps;
/*
    Ввести с консоли n-размерность матрицы a [n] [n].
    Задать значения элементов матрицы в интервале значений
    от -n до n с помощью датчика случайных чисел.

    8. Вычислить определитель матрицы.
 */

import java.util.Random;
import java.util.Scanner;

public class Task08 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        /*
        Тестовая матрица. Опредилитель = -1918
        int[][] a = {{-3, -2, -1,  2, -3},
                     { 0, -5,  3,  0, -2},
                     { 1,  5,  0,  4,  3},
                     { 4, -5,  5, -5, -4},
                     { 1,  2,  4, -3,  4}};
         */
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

        System.out.println("Определитель матрицы: " + determinant(a));

        System.out.println("\n***********************************");
        System.out.println("Разработчик: sinapps");
        System.out.println("Задание получено: 2021.01.10 10:10");
        System.out.println("Задание выполнено: 2021.01.10 16:36");
    }

    public static double determinant(int[][] matrix) {
        double result = 1;
        int exchangesCount = 0;
        int maxValueColumn = 1;
        int size = matrix.length;

        double[][] a = new double[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                a[i][j] = matrix[i][j];
            }
        }

        for (int i = 0; i < size - 1; i++) {
            for (int j = i; j < size - 1; j++) {
                maxValueColumn = j;
                for (int k = j + 1; k < size; k++) {
                    if (Math.abs(a[i][k]) > Math.abs(a[i][maxValueColumn])) {
                        maxValueColumn = k;
                    }
                }

                for (int k = 0; k < size; k++) {
                    double buff = a[k][j];
                    a[k][j] = a[k][maxValueColumn];
                    a[k][maxValueColumn] = buff;
                }
            }

            for (int j = i + 1; j < size; j++) {
                double buff = a[i][j] / a[i][i];
                for (int k = 0; k < size; k++) {
                    a[k][j] = a[k][j] - a[k][i] * buff;
                }
            }

            if (i != maxValueColumn) {
                exchangesCount++;
            }
        }

        for (int i = 0; i < size; i++) {
            result *= a[i][i];
        }

        if (exchangesCount % 2 != 0) {
            result *= -1;
        }

        return result;
    }
}
