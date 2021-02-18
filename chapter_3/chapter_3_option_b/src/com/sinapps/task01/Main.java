package com.sinapps.task01;

/*
    Реализовать методы сложения, вычитания, умножения и деления объектов
    (для тех классов, объекты которых могут поддерживать арифметические действия):

    1. Определить класс Дробь (Рациональная Дробь) в виде пары чисел m и n. Объявить и
    инициализировать массив из k дробей, ввести/вывести значения для массива дробей.
    Создать массив/список/множество объектов и передать его в метод, который изменяет
    каждый элемент массива с четным индексом путем добавления следующего за ним элемента.
 */

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int k = 0;
        Scanner input = new Scanner(System.in);

        do {
            System.out.print("Введите размер массива: ");
            k = input.nextInt();
        } while (k <= 0);

        Fraction[] fractions = new Fraction[k];
        for (int i = 0; i < fractions.length; i++) {
            System.out.println("Дробь #" + (i + 1) + ":");
            System.out.print("\tВведите чеслитель: ");
            int numerator = input.nextInt();
            System.out.print("\tВведите знаменатель: ");
            int denominator = input.nextInt();

            fractions[i] = new Fraction(numerator, denominator);
        }

        System.out.println("\nМассив дробей: ");
        for (Fraction fraction : fractions) {
            System.out.println(fraction);
        }

        System.out.println("\nИзмененный массив дробей: ");
        Fraction[] changedFractions = FractionsChanger.change(fractions);
        for (Fraction fraction : changedFractions) {
            System.out.println(fraction);
        }
    }
}
