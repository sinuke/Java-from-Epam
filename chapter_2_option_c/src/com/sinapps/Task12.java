package com.sinapps;
/*
    Ввести с консоли n-размерность матрицы a [n] [n].
    Задать значения элементов матрицы в интервале значений
    от -n до n с помощью датчика случайных чисел.

    12. В матрице найти минимальный элемент и переместить
    его на место заданного элемента путем перестановки строк и столбцов.
 */

import java.util.Random;
import java.util.Scanner;

public class Task12 {
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

        int minValue = a[0][0];
        int sourceRow = 0, sourceColumn = 0;

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (a[i][j] < minValue) {
                    minValue = a[i][j];
                    sourceRow = i;
                    sourceColumn = j;
                }
            }
        }
        System.out.println("Минимальны элемент: " + minValue);
        System.out.println("Расположен в " + (sourceRow + 1) + " строке и " + (sourceColumn + 1) + " столбце");

        int destinationRow, destinationColumn;
        do {
            System.out.print("Строка: ");
            destinationRow = input.nextInt();
        } while (destinationRow < 1 || destinationRow > n);

        do {
            System.out.print("Столбец: ");
            destinationColumn = input.nextInt();
        } while (destinationColumn < 1 || destinationColumn > n);

        destinationRow--;
        destinationColumn--;

        exchangeRows(a, sourceRow, destinationRow);
        exchangeColumns(a, sourceColumn, destinationColumn);

        System.out.println("Преобразованная матрица: ");
        for (int[] row : a) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }

        System.out.println("\n***********************************");
        System.out.println("Разработчик: sinapps");
        System.out.println("Задание получено: 2021.01.09 12:40");
        System.out.println("Задание выполнено: 2021.01.09 12:57");
    }

    public static void exchangeRows(int[][] matrix, int sourceRow, int destinationRow) {
        if (sourceRow != destinationRow) {
            int[] temp = matrix[sourceRow];
            matrix[sourceRow] = matrix[destinationRow];
            matrix[destinationRow] = temp;
        }
    }

    public static void exchangeColumns(int[][] matrix, int sourceColumn, int destinationColumn) {
        if (sourceColumn != destinationColumn) {
            for (int i = 0; i < matrix.length; i++) {
                int temp = matrix[i][sourceColumn];
                matrix[i][sourceColumn] = matrix[i][destinationColumn];
                matrix[i][destinationColumn] = temp;
            }
        }
    }
}
