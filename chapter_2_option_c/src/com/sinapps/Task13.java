package com.sinapps;
/*
    Ввести с консоли n-размерность матрицы a [n] [n].
    Задать значения элементов матрицы в интервале значений
    от -n до n с помощью датчика случайных чисел.

    13. Преобразовать строки матрицы таким образом,
    чтобы элементы, равные нулю, располагались после всех остальных.
 */

import java.util.Random;
import java.util.Scanner;

public class Task13 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        /*
        Тестовая матрица
        int[][] a = {{0, 1, 2, 3, 4},
                     {0, 0, 1, 0, 2},
                     {0, 0, 0, 3, 4},
                     {0, 5, 0, 6, 0},
                     {7, 8, 0, 9, 0}};
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

        for (int i = 0; i < a.length; i++) {
            a[i] = changeRow(a[i]);
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
        System.out.println("Задание получено: 2021.01.09 16:52");
        System.out.println("Задание выполнено: 2021.01.09 17:04");
    }

    public static int[] changeRow(int[] row) {
        for (int i = 0; i < row.length - 1; i++) {
            for (int j = 0; j < row.length - i- 1; j++) {
                if (row[j] == 0) {
                    int temp = row[j + 1];
                    row[j + 1] = row[j];
                    row[j] = temp;
                }
            }
        }

        return row;
    }
}
