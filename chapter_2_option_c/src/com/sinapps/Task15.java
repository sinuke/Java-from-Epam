package com.sinapps;
/*
    Ввести с консоли n-размерность матрицы a [n] [n].
    Задать значения элементов матрицы в интервале значений
    от -n до n с помощью датчика случайных чисел.

    15. Найти количество всех седловых точек матрицы.
    (Матрица А имеет седловую точку Аi, j , если Аi, j является
    минимальным элементом в i-й строке и максимальным в j-м столбце).
 */

import java.util.Random;
import java.util.Scanner;

public class Task15 {
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

        int countSaddlePoints = 0;
        for (int i = 0; i < a.length; i++) {
            int minValue = a[i][0];
            int minColumn = 0;
            int minRow = i;
            for (int j = 0; j < a[i].length; j++) {
                if (a[i][j] < minValue) {
                    minValue = a[i][j];
                    minRow = i;
                    minColumn = j;
                }
            }

            int maxValue = a[0][minColumn];
            int maxRow = 0;
            for (int k = 0; k < a.length; k++) {
                if (a[k][minColumn] > maxValue) {
                    maxValue = a[k][minColumn];
                    maxRow = k;
                }
            }

            if (maxValue == minValue && maxRow == minRow) {
                countSaddlePoints++;
            }
        }

        System.out.println("Количество седловых точек: " + countSaddlePoints);

        System.out.println("\n***********************************");
        System.out.println("Разработчик: sinapps");
        System.out.println("Задание получено: 2021.01.10 09:42");
        System.out.println("Задание выполнено: 2021.01.10 10:01");
    }
}
