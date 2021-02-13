package com.sinapps;
/*
    Вывести заданное количество случайных чисел с переходом и без перехода на новую строку.
 */

import java.util.Random;
import java.util.Scanner;

public class Task03 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Введите количество случайных чисел n: ");
        int n = input.nextInt();
        String valuesLine = "";
        Random random = new Random();

        System.out.println("Случайные числа: ");
        for (int i = 0; i < n; i++) {
            int value = random.nextInt(Integer.MAX_VALUE);
            System.out.println((i + 1) + ": " + value);
            valuesLine += String.valueOf(value) + " ";
        }
        System.out.println("Случайные числа одной строкой: ");
        System.out.println(valuesLine);
    }
}
