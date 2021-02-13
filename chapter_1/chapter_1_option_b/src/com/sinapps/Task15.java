package com.sinapps;
/*
    Ввести с консоли n целых чисел. На консоль вывести:
    15. Период десятичной дроби p = m/n для первых двух целых положительных чисел n и m, расположенных подряд.
 */

import java.util.Scanner;

public class Task15 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Введите число элементов n: ");
        int n = input.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < a.length; i++) {
            System.out.print((i + 1) + "-й элемент: ");
            a[i] = input.nextInt();
        }

        if (n > 1) {
            int mValue = -1;
            int nValue = -1;
            for (int i = 0; i < a.length - 1; i++) {
                if (a[i] > 0 && a[i + 1] > 0) {
                    mValue = a[i];
                    nValue = a[i + 1];
                    break;
                }
            }

            if (mValue > 0 && nValue > 0) {
                System.out.println("Период дроби " + mValue + "/" + nValue + ":");
                System.out.print(period(mValue, nValue));
            } else {
                System.out.print("Не найдено два положительных числа подряд");
            }
        }
    }

    public static int greatestCommonDivisor(int a, int b) {
        if (a == b || a == 1 || b == 1) {
            return a;
        }

        int x = Math.min(a, b);
        int y = a + b - x;
        int z;
        do {
            z = y % x;
            y = x;
            x = z;
        } while (z != 0);

        return y;
    }

    public static String period(int a, int b) {
        String result = "";

        while (b % 2 == 0) {
            b /= 2;
            a *= 5;
        }

        while (b % 5 == 0) {
            b /= 5;
            a *= 2;
        }

        int c = greatestCommonDivisor(a, b);
        a /= c;
        b /= c;

        if (b == 1) {
            result = String.valueOf(a);
        } else {
            if (a > b) {
                result = String.valueOf((a - a % b) / b);
                a %= b;
                if (a != 0) {
                    result += "(";
                }
            } else {
                result += "(";
            }

            while (a % 10 == 0) {
                a /= 10;
            }

            int i = a;
            while (true) {
                int j = 0;
                while (i < b) {
                    i *= 10;
                    j++;
                    if (j > 1) {
                        result += "0";
                    }
                }

                if ((i - a) % b == 0) {
                    result += String.valueOf((i - a) / b);
                    break;
                } else {
                    j = i % b;
                    result += String.valueOf((i - j) / b);
                    i = j;
                }
            }

            result += ")";
        }

        return result;
    }
}
