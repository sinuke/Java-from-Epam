package com.sinapps;
/*
    Отобразить в окне консоли аргументы командной строки в обратном порядке.
 */

public class Task02 {
    public static void main(String[] args) {
        System.out.println("Аргументы коммандной строки в обратном порядке: ");
        for (int i = args.length - 1; i >= 0; i--) {
            System.out.println((i + 1) + "-й аргумент: " + args[i]);
        }
    }
}
