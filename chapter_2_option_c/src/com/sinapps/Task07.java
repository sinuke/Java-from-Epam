package com.sinapps;
/*
    Ввести с консоли n-размерность матрицы a [n] [n].
    Задать значения элементов матрицы в интервале значений
    от -n до n с помощью датчика случайных чисел.

    7. Повернуть матрицу на 90 (180, 270) градусов против часовой стрелки.
 */

import java.util.Random;
import java.util.Scanner;

public class Task07 {
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

        int angle = 0;
        do {
            System.out.print("Введите угол поворота (90, 180 или 270 градусов): ");
            angle = input.nextInt();
        } while (angle < 90 || (angle > 90 && angle < 180) || (angle > 180 && angle < 270) || (angle > 270));

        do {
            rotate(a);
            angle -= 90;
        } while (angle > 0);

        System.out.println("Повернутая матрица на " + angle + " градусов:");
        for (int[] row : a) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }

        System.out.println("\n***********************************");
        System.out.println("Разработчик: sinapps");
        System.out.println("Задание получено: 2021.01.12 21:24");
        System.out.println("Задание выполнено: 2021.01.12 22:10");
    }

    public static void rotate(int[][] matrix) {
        int size = matrix.length;
        for (int i = 0; i < size / 2; i++) {
            int top = i;
            int bottom = size - 1 - i;
            for (int j = top; j < bottom; j++) {
                int temp = matrix[top][j];
                matrix[top][j] = matrix[j][bottom];
                matrix[j][bottom] = matrix[bottom][bottom - (j - top)];
                matrix[bottom][bottom - (j - top)] = matrix[bottom - (j - top)][top];
                matrix[bottom - (j - top)][top] = temp;
            }
        }
    }
}
