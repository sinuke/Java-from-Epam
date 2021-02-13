package com.sinapps;
/*
    Ввести с консоли n-размерность матрицы a [n] [n].
    Задать значения элементов матрицы в интервале значений
    от -n до n с помощью датчика случайных чисел.

    11. Уплотнить матрицу, удаляя из нее строки и столбцы, заполненные нулями.
 */

import java.util.Random;
import java.util.Scanner;

public class Task11 {
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

        // Удаляем строки, заполненные нулями
        int i = 0;
        do {
            boolean isEmpty = true;
            for (int j = 0; j < a[i].length; j++) {
                if (a[i][j] != 0) {
                    isEmpty = false;
                    break;
                }
            }

            if (isEmpty) {
                a = removeRow(a, i);
            } else {
                i++;
            }
        } while (i < a.length);

        // Удаляем столбцы, заполненные нулями
        if (a.length > 0) {
            i = 0;
            do {
                boolean isEmpty = true;
                for (int[] row : a) {
                    if (row[i] != 0) {
                        isEmpty = false;
                        break;
                    }
                }

                if (isEmpty) {
                    a = removeColumn(a, i);
                } else {
                    i++;
                }
            } while (i < a[0].length);
        }

        System.out.println("Преобразованная матрица:");
        for (int[] row : a) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }

        System.out.println("\n***********************************");
        System.out.println("Разработчик: sinapps");
        System.out.println("Задание получено: 2021.01.09 09:56");
        System.out.println("Задание выполнено: 2021.01.09 10:11");
    }

    public static int[][] removeRow(int[][] a, int row) {
        int[][] result = new int[a.length - 1][a[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (i < row) {
                    result[i][j] = a[i][j];
                } else if (i > row) {
                    result[i - 1][j] = a[i][j];
                }
            }
        }
        return result;
    }

    public static int[][] removeColumn(int[][] a, int column) {
        int[][] result = new int[a.length][a[0].length - 1];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (j < column) {
                    result[i][j] = a[i][j];
                } else if (j > column) {
                    result[i][j - 1] = a[i][j];
                }
            }
        }
        return result;
    }
}
