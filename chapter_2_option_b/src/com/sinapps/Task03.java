package com.sinapps;
/*
    3. Найти корни квадратного уравнения. Параметры уравнения передавать с командной строкой.
 */

import java.util.Scanner;

public class Task03 {
    public static void main(String[] args) {
        if (args.length >= 3) {
            System.out.println("Решение квадратного уравнения ax^2 + bx + c = 0");
            try {
                int a = Integer.parseInt(args[0]);
                if (a != 0) {
                    int b = Integer.parseInt(args[1]);
                    int c = Integer.parseInt(args[2]);

                    int D = b * b - 4 * a * c;
                    if (D < 0) {
                        System.out.println("Корней нет");
                    } else {
                        double x1 = (-b + Math.sqrt(D)) / (2 * a);
                        if (D > 0) {
                            double x2 = (-b - Math.sqrt(D)) / (2 * a);
                            System.out.println("Два корня. x1 = " + x1 + "; x2 = " + x2);
                        } else {
                            System.out.println("Один корень. x = " + x1);
                        }
                    }
                } else {
                    System.out.println("Коэффициент a не может быть равным нулю!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Неверный формат числа " + e);
            }
        } else {
            System.out.println("Недостаточно параметров. Введите параметры a b и с для решения квадратного" +
                               " уравнения вида ax^2 + bx + c = 0");
        }

        System.out.println("\n***********************************");
        System.out.println("Разработчик: sinapps");
        System.out.println("Задание получено: 2021.01.07 17:20");
        System.out.println("Задание выполнено: 2021.01.07 17:32");
    }
}
