package com.sinapps.task02;

/*
    Реализовать методы сложения, вычитания, умножения и деления объектов
    (для тех классов, объекты которых могут поддерживать арифметические действия):

    2. Определить класс Комплекс. Создать массив/список/множество размерности n
    из комплексных координат. Передать его в метод, который выполнит сложение/умножение
    его элементов.
 */

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int n;
        Scanner input = new Scanner(System.in);

        do {
            System.out.print("Введите размер массива: ");
            n = input.nextInt();
        } while (n <= 0);

        Complex[] arr = new Complex[n];

        for (int i = 0; i < arr.length; i++) {
            System.out.println("Комлексное число #" + (i + 1) + ": ");
            System.out.print("\tДействительная часть: ");
            double real = input.nextDouble();
            System.out.print("\tМнимая часть: ");
            double imaginary = input.nextDouble();
            arr[i] = new Complex(real, imaginary);
        }

        System.out.println("\nМассив комплексных чисел:");
        for (Complex complex : arr) {
            System.out.println("\t" + complex);
        }

        System.out.println("\nСумма комплексных чисел: " + ComplexArrayUtils.calculateSum(arr));
        System.out.println("Произведение комплексных чисел: " + ComplexArrayUtils.calculateMultiplication(arr));
    }
}
