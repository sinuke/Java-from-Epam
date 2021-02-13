package com.sinapps;
/*
    Ввести с консоли n-размерность матрицы a [n] [n].
    Задать значения элементов матрицы в интервале значений
    от -n до n с помощью датчика случайных чисел.

    9. Построить матрицу, вычитая из элементов каждой
    строки матрицы ее среднее арифметическое.
 */

import java.util.Random;
import java.util.Scanner;

public class Task09 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n;
        do {
            System.out.print("Введите размер матрицы n: ");
            n = input.nextInt();
        } while (n < 1);

        System.out.println("Матрица: ");
        double[][] a = new double[n][n];
        double[] averages = new double[a.length];
        Random random = new Random();
        for (int i = 0; i < a.length; i++) {
            averages[i] = 0;
            for (int j = 0; j < a[i].length; j++) {
                a[i][j] = n - random.nextInt(2 * n + 1);
                averages[i] += a[i][j];
                System.out.print(a[i][j] + " ");
            }
            averages[i] = averages[i] / a.length;
            System.out.println();
        }

        System.out.println("От каждого элемента строки отнято среднее значение строки:");
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                a[i][j] -= averages[i];
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("\n***********************************");
        System.out.println("Разработчик: sinapps");
        System.out.println("Задание получено: 2021.01.08 20:19");
        System.out.println("Задание выполнено: 2021.01.08 20:30");
    }
}
