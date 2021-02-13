package com.sinapps;
/*
    Ввести с консоли n-размерность матрицы a [n] [n].
    Задать значения элементов матрицы в интервале значений
    от -n до n с помощью датчика случайных чисел.

    6. Вычислить норму матрицы.
 */

import java.util.Random;
import java.util.Scanner;

public class Task06 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n;
        do {
            System.out.print("Введите размер матрицы n: ");
            n = input.nextInt();
        } while (n < 1);

        System.out.println("Матрица: ");
        int[][] a = new int[n][n];
        double matrixNorm = 0;
        Random random = new Random();
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                a[i][j] = n - random.nextInt(2 * n + 1);
                matrixNorm += a[i][j] * a[i][j];
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }

        matrixNorm = Math.sqrt(matrixNorm);
        System.out.println("Норма Фробениуса: " + matrixNorm);

        System.out.println("\n***********************************");
        System.out.println("Разработчик: sinapps");
        System.out.println("Задание получено: 2021.01.08 18:01");
        System.out.println("Задание выполнено: 2021.01.08 18:06");
    }
}
