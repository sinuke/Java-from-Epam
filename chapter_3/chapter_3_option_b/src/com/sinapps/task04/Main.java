package com.sinapps.task04;

/*
    Реализовать методы сложения, вычитания, умножения и деления объектов
    (для тех классов, объекты которых могут поддерживать арифметические действия):

    4. Определить класс Полином степени n. Объявить массив/список/множество из m
    полиномов и определить сумму полиномов массива.
 */

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int m = 0;
        do {
            System.out.print("Введите количество полиновов: ");
            m = input.nextInt();
        } while (m <= 0);

        Polynomial[] polynomials = new Polynomial[m];
        Polynomial result = new Polynomial(new double[]{});

        for (int i = 0; i < polynomials.length; i++) {
            polynomials[i] = generateRandomPolynomial();
            result = Polynomial.sum(result, polynomials[i]);
            System.out.println("Полином: " + polynomials[i]);
        }

        System.out.println("Сумма полиномов: ");
        System.out.println("\t" + result);
    }

    public static Polynomial generateRandomPolynomial() {
        Random random = new Random();
        int count = random.nextInt(9) + 1;
        double[] args = new double[count];

        for (int i = 0; i < args.length; i++) {
            args[i] = random.nextDouble() * 10;
        }

        return new Polynomial(args);
    }
}
