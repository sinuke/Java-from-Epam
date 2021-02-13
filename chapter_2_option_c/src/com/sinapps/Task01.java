package com.sinapps;
/*
    Ввести с консоли n-размерность матрицы a [n] [n].
    Задать значения элементов матрицы в интервале значений
    от -n до n с помощью датчика случайных чисел.

    1. Упорядочить строки (столбцы) матрицы в порядке возрастания
    значений элементов k-го столбца (строки).
 */

import java.util.Random;
import java.util.Scanner;

public class Task01 {

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

        int k;
        do {
            System.out.print("Введите номер столбца k (1 <= k <= n): ");
            k = input.nextInt();
        } while (k < 1 || k > n);

        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - i- 1; j++) {
                if (a[j][k - 1] > a[j + 1][k - 1]) {
                    int[] temp = a[j + 1];
                    a[j + 1] = a[j];
                    a[j] = temp;
                }
            }
        }

        System.out.println("Упорядоченная матрица по столбцу " + k);
        for (int[] columns : a) {
            for (int cell : columns) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }

        System.out.println("\n***********************************");
        System.out.println("Разработчик: sinapps");
        System.out.println("Задание получено: 2021.01.07 21:31");
        System.out.println("Задание выполнено: 2021.01.07 21:50");
    }
}
