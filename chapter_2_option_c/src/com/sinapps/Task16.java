package com.sinapps;
/*
    Ввести с консоли n-размерность матрицы a [n] [n].
    Задать значения элементов матрицы в интервале значений
    от -n до n с помощью датчика случайных чисел.

    16. Перестроить матрицу, переставляя в ней строки так,
    чтобы сумма элементов в строках полученной матрицы возрастала.
 */

import java.util.Random;
import java.util.Scanner;

public class Task16 {
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
                if (getRowSum(a[j]) > getRowSum(a[j + 1])) {
                    int[] temp = a[j + 1];
                    a[j + 1] = a[j];
                    a[j] = temp;
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
        System.out.println("Задание получено: 2021.01.10 17:19");
        System.out.println("Задание выполнено: 2021.01.10 17:34");
    }

    public static int getRowSum(int[] row) {
        int result = 0;
        for (int value : row) {
            result += value;
        }
        return result;
    }
}
