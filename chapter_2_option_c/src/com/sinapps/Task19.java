package com.sinapps;
/*
    Ввести с консоли n-размерность матрицы a [n] [n].
    Задать значения элементов матрицы в интервале значений
    от -n до n с помощью датчика случайных чисел.

    19. Перестроить заданную матрицу, переставляя в ней столбцы так,
    чтобы значения их характеристик убывали. (Характеристикой столбца
    прямоугольной матрицы называется сумма модулей его элементов.)
 */

import java.util.Random;
import java.util.Scanner;

public class Task19 {
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

        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - i- 1; j++) {
                if (getColumnAbsSum(a, j) < getColumnAbsSum(a, j + 1)) {
                    exchangeColumns(a, j, j + 1);
                }
            }
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
        System.out.println("Задание получено: 2021.01.10 21:59");
        System.out.println("Задание выполнено: 2021.01.10 22:05");
    }

    public static void exchangeColumns(int[][] matrix, int sourceColumn, int destinationColumn) {
        if (sourceColumn != destinationColumn) {
            for (int i = 0; i < matrix.length; i++) {
                int temp = matrix[i][sourceColumn];
                matrix[i][sourceColumn] = matrix[i][destinationColumn];
                matrix[i][destinationColumn] = temp;
            }
        }
    }

    public static int getColumnAbsSum(int[][] matrix, int columnIndex) {
        int result = 0;
        for (int[] row : matrix) {
            result += Math.abs(row[columnIndex]);
        }
        return result;
    }
}
