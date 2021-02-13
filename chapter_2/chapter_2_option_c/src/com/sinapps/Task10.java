package com.sinapps;
/*
    Ввести с консоли n-размерность матрицы a [n] [n].
    Задать значения элементов матрицы в интервале значений
    от -n до n с помощью датчика случайных чисел.

    10. Найти максимальный элемент (ы) в матрице и
    удалить из матрицы все строки и столбцы, его содержащие.
 */

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Task10 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n;
        do {
            System.out.print("Введите размер матрицы n: ");
            n = input.nextInt();
        } while (n < 1);

        System.out.println("Матрица: ");
        int[][] a = new int[n][n];
        int maxValue = Integer.MIN_VALUE; // Максимальное значение
        Random random = new Random();
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                a[i][j] = n - random.nextInt(2 * n + 1);
                if (a[i][j] > maxValue) {
                    maxValue = a[i][j];
                }
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("Максимальный элемент: " + maxValue);
        int[] rows = new int[a.length]; // строки максимумов
        int[] columns = new int[a.length]; // колонки максимумов
        int kr = -1, kc = -1;
        Arrays.fill(rows, -1);
        Arrays.fill(columns, -1);

        // Запоминаем координаты всех максимальных значений
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (maxValue == a[i][j]) {
                    if (!contains(rows, i)) {
                        kr++;
                        rows[kr] = i;
                    }

                    if (!contains(columns, j)) {
                        kc++;
                        columns[kc] = j;
                    }
                }
            }
        }

        // Удаляем строки
        for (int i = 0; i < rows.length; i++) {
            if (rows[i] > -1) {
                a = removeRow(a, rows[i]);
                for (int j = i + 1; j < rows.length; j++) {
                    if (rows[i] < rows[j]) {
                        rows[j]--;
                    }
                }
            }
        }

        // Удаляем столбцы
        for (int i = 0; i < columns.length; i++) {
            if (columns[i] > -1) {
                a = removeColumn(a, columns[i]);
                for (int j = i + 1; j < columns.length; j++) {
                    if (columns[i] < columns[j]) {
                        columns[j]--;
                    }
                }
            }
        }

        System.out.println("Преобразованная матрица:");
        for (int[] line : a) {
            for (int cell : line) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }

        System.out.println("\n***********************************");
        System.out.println("Разработчик: sinapps");
        System.out.println("Задание получено: 2021.01.08 20:35");
        System.out.println("Задание выполнено: 2021.01.08 22:26");
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

    public static boolean contains(int[] a, int value) {
        boolean result = false;
        for (int item : a) {
            if (item == value) {
                result = true;
                break;
            }
        }
        return result;
    }
}
