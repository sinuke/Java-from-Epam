package com.sinapps;
/*
    2. Вывести числа от 1 до k в виде матрицы N x N слева направо и сверху вниз.
 */

import java.util.Arrays;
import java.util.Scanner;

public class Task02 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Введите количество чисел k: ");
        int k = input.nextInt();
        int n;
        do {
            System.out.print("Введите размер матрицы N: ");
            n = input.nextInt();
        } while (n * n < k);
        int[][] matrix = new int[n][n];

        for (int[] columns : matrix) {
            Arrays.fill(columns, -1);
        }

        for (int i = 0; i < k; i++) {
            matrix[i / n][i % n] = i + 1;
        }

        System.out.println("Матрица: ");
        for (int[] columns : matrix) {
            for (int cell : columns) {
                if (cell > 0) {
                    System.out.print(cell + " ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }

        System.out.println("\n***********************************");
        System.out.println("Разработчик: sinapps");
        System.out.println("Задание получено: 2021.01.07 10:04");
        System.out.println("Задание выполнено: 2021.01.07 10:17");
    }
}
