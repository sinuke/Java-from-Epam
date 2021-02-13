package com.sinapps;
/*
    Ввести с консоли n-размерность матрицы a [n] [n].
    Задать значения элементов матрицы в интервале значений
    от -n до n с помощью датчика случайных чисел.

    14. Округлить все элементы матрицы до целого числа.
 */

import java.util.Random;
import java.util.Scanner;

public class Task14 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n;
        do {
            System.out.print("Введите размер матрицы n: ");
            n = input.nextInt();
        } while (n < 1);

        System.out.println("Матрица: ");
        double[][] matrixD = new double[n][n];
        int[][] matrixI = new int[n][n];

        Random random = new Random();
        for (int i = 0; i < matrixD.length; i++) {
            for (int j = 0; j < matrixD[i].length; j++) {
                matrixD[i][j] = n - (2 * n + 1) * random.nextDouble();
                matrixI[i][j] = (int)Math.round(matrixD[i][j]);
                System.out.print(matrixD[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("Преобразованная матрица: ");
        for (int[] row : matrixI) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }

        System.out.println("\n***********************************");
        System.out.println("Разработчик: sinapps");
        System.out.println("Задание получено: 2021.01.09 18:17");
        System.out.println("Задание выполнено: 2021.01.09 18:23");
    }
}
