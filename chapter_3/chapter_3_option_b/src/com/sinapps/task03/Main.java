package com.sinapps.task03;

/*
    Реализовать методы сложения, вычитания, умножения и деления объектов
    (для тех классов, объекты которых могут поддерживать арифметические действия):

    3. Определить класс Квадратное уравнение. Реализовать методы для поиска корней,
    экстремумов, а также интервалов убывания/возрастания. Создать массив/список/множество
    объектов и определить наибольшие и наименьшие по значению корни.
 */

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    Scanner input = new Scanner(System.in);
	    int k = 0;
	    do {
	        System.out.print("Введите количество решаемых квадратных уравнений: ");
	        k = input.nextInt();
        } while (k <= 0);


	    Quadratic[] arr = new Quadratic[k];
	    for (int i = 0; i < arr.length; i++) {
	        System.out.println((i + 1) + "-e квадратное уравнение:");
            double a = 0;
            do {
                System.out.print("\tВведите коэффициент a, не равный нулю: ");
                a = input.nextDouble();
            } while (a == 0);

            System.out.print("\tВведите коэффициент b: ");
            double b = input.nextDouble();
            System.out.print("\tВведите коэффициент c: ");
            double c = input.nextDouble();

            arr[i] = new Quadratic(a, b, c);
            System.out.println(arr[i]);
            System.out.println("*******************************************");
        }

	    System.out.println("Минимальный корень:");
	    System.out.println(QuadraticArrayUtils.findMinimalRoot(arr));

        System.out.println("Максимальный корень:");
        System.out.println(QuadraticArrayUtils.findMaximalRoot(arr));
    }
}
