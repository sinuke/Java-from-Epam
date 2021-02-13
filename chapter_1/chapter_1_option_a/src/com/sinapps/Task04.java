package com.sinapps;
/*
    Ввести пароль из командной строки и сравнить его со строкой-образцом.
 */

import java.util.Scanner;

public class Task04 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Введите пароль: ");
        String psw = input.next();

        if (psw.equals("qwerty")) {
            System.out.println("Верный пароль!");
        } else {
            System.out.println("Неверный пароль!");
        }
    }
}
