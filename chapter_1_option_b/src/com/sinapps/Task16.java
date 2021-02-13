package com.sinapps;
/*
    Ввести с консоли n целых чисел. На консоль вывести:
    16. Построить треугольник Паскаля для первого положительного числа.
 */

import java.util.Arrays;
import java.util.Scanner;

public class Task16 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Введите число элементов n: ");
        int n = input.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < a.length; i++) {
            System.out.print((i + 1) + "-й элемент: ");
            a[i] = input.nextInt();
        }

        for (int value : a) {
            if (value > 0) {
                System.out.println("Треугольник Паскаля для числа " + value + ":");
                printPascalTriangle(value);
            }
        }
    }

    public static void printPascalTriangle(int value) {
        int[][] pt = new int[value + 1][];

        pt[0] = new int[1];
        pt[0][0] = 1;
        for (int i = 1; i < pt.length; i++) {
            pt[i] = new int[i + 1];

            pt[i][0] = 1;
            pt[i][i] = 1;

            for (int j = 1; j < i; j++) {
                pt[i][j] = pt[i - 1][j - 1] + pt[i - 1][j];
            }
        }

        for (int[] lines : pt) {
            for (int cell : lines) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }
}
