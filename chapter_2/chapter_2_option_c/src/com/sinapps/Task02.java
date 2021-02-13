package com.sinapps;
/*
    Ввести с консоли n-размерность матрицы a [n] [n].
    Задать значения элементов матрицы в интервале значений
    от -n до n с помощью датчика случайных чисел.

    2. Выполнить циклический сдвиг заданной матрицы на k позиций
    вправо (влево, вверх, вниз).
 */

import java.util.Random;
import java.util.Scanner;

public class Task02 {
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
            System.out.print("Введите величину сдвига влево: ");
            k = input.nextInt();
        } while (k < 1);

        // циклический сдвиг влево на k
        for (int i = 0; i < a.length; i++) {
            int[] line = new int[a.length];
            for (int j = 0; j < a[i].length; j++) {
                int index = j + k % a[j].length;
                if (index >= a[j].length) {
                    index = a[j].length - index;
                }
                line[index] = a[i][j];
            }
            a[i] = line;
        }

        for (int[] columns : a) {
            for (int cell : columns) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }

        System.out.println("\n***********************************");
        System.out.println("Разработчик: sinapps");
        System.out.println("Задание получено: 2021.01.07 22:51");
        System.out.println("Задание выполнено: 2021.01.07 23:19");
    }
}
