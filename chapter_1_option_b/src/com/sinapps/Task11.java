package com.sinapps;
/*
    Ввести с консоли n целых чисел. На консоль вывести:
    11. «Счастливые» числа.
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Task11 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Введите число элементов n: ");
        int n = input.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < a.length; i++) {
            System.out.print((i + 1) + "-й элемент: ");
            a[i] = input.nextInt();
        }

        System.out.println("Счастливые числа: ");
        for (int value : a) {
            if (isHappy(value)) {
                System.out.print(value + " ");
            }
        }
    }

    public static int pdi(int number) {
        int total = 0;
        int value = number;
        while (value > 0) {
            total += (value % 10) * (value % 10);
            value /= 10;
        }
        return total;
    }

    public static boolean isHappy(int number) {
        int value = number;
        ArrayList<Integer> seen_numbers = new ArrayList<>();
        while (value > 1 && !seen_numbers.contains(value)) {
            seen_numbers.add(value);
            value = pdi(value);
        }
        return value == 1;
    }
}
