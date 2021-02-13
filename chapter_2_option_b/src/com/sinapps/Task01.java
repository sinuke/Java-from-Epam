package com.sinapps;
/*
    1. Определить принадлежность некоторого значения k интервалам (n, m], [n, m), (n, m), [n, m].
 */

import java.util.Scanner;

public class Task01 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Введите число k: ");
        int k = input.nextInt();
        System.out.print("Введите число n: ");
        int n = input.nextInt();
        System.out.print("Введите число m: ");
        int m = input.nextInt();

        if (k >= n && k <= m) {
            System.out.println("Число k = " + k + " принадлежит интервалу [" + n + ", " + m + "]");
        }

        if (k > n && k < m) {
            System.out.println("Число k = " + k + " принадлежит интервалу (" + n + ", " + m + ")");
        }

        if (k >= n && k < m) {
            System.out.println("Число k = " + k + " принадлежит интервалу [" + n + ", " + m + ")");
        }

        if (k > n && k <= m) {
            System.out.println("Число k = " + k + " принадлежит интервалу (" + n + ", " + m + "]");
        }

        if (k < n || k > m) {
            System.out.println("Число k = " + k + " не принадлежит интервалу [" + n + ", " + m + "]");
        }

        System.out.println("\n***********************************");
        System.out.println("Разработчик: sinapps");
        System.out.println("Задание получено: 2021.01.07 08:57");
        System.out.println("Задание выполнено: 2021.01.07 09:31");
    }
}
