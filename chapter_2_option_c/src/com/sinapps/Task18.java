package com.sinapps;
/*
    Ввести с консоли n-размерность матрицы a [n] [n].
    Задать значения элементов матрицы в интервале значений
    от -n до n с помощью датчика случайных чисел.

    18. Найти наименьший среди локальных максимумов.
    (Элемент матрицы называется локальным минимумом, если он строго меньше всех своих соседей.)
 */

import java.util.Random;
import java.util.Scanner;

public class Task18 {
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

        int countLocalMinimums = 0;
        int minLocalMinimum = Integer.MAX_VALUE;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (isLocalMin(a, i, j)) {
                    countLocalMinimums++;
                    if (a[i][j] < minLocalMinimum) {
                        minLocalMinimum = a[i][j];
                    }
                }
            }
        }

        if (countLocalMinimums > 0) {
            System.out.println("Количество локальных мининимумов: " + countLocalMinimums);
            System.out.println("Наименьший из локальных минимумов: " + minLocalMinimum);
        } else {
            System.out.println("Нет локальных минимумов");
        }

        System.out.println("\n***********************************");
        System.out.println("Разработчик: sinapps");
        System.out.println("Задание получено: 2021.01.10 21:47");
        System.out.println("Задание выполнено: 2021.01.10 21:55");
    }

    public static boolean isLocalMin(int[][] matrix, int valueRow, int valueColumn) {
        boolean result = true;
        int value = matrix[valueRow][valueColumn];
        int size = matrix.length;

        final int[] ROW_MOVE = {-1, -1, -1, 0, +1, +1, +1, 0};
        final int[] COLUMN_MOVE = {-1, 0, +1, +1, +1, 0, -1, -1};
        final int MOVES_COUNT = ROW_MOVE.length;

        for (int i = 0; i < MOVES_COUNT; i++) {
            if (valueRow + ROW_MOVE[i] >= 0 && valueRow + ROW_MOVE[i] < size &&
                    valueColumn + COLUMN_MOVE[i] >= 0 && valueColumn + COLUMN_MOVE[i] < size) {
                result = result && (value < matrix[valueRow + ROW_MOVE[i]][valueColumn + COLUMN_MOVE[i]]);
            }
        }
        return result;
    }
}
