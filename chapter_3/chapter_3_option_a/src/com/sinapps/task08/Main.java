package com.sinapps.task08;
/*
    Задания к главе 3
    Вариант A

    Создать классы, спецификации которых приведены ниже. Определить конструкторы и методы
    setТип(), getТип(), toString(). Определить дополнительно методы в классе, создающем
    массив объектов. Задать критерий выбора данных и вывести эти данные на консоль. В
    каждом классе, обладающем информацией, должно быть объявлено несколько конструкторов.

    8. Car: id, Марка, Модель, Год выпуска, Цвет, Цена, Регистрационный номер.
    Создать массив объектов. Вывести:
	    a) список автомобилей заданной марки;
	    b) список автомобилей заданной модели, которые эксплуатируются больше n лет;
	    c) список автомобилей заданного года выпуска, цена которых больше указанной.
 */

public class Main {
    public static void main(String[] args) {
        Cars cars = new Cars(10);
        for (Car car : cars.getCars()) {
            System.out.println(car);
        }

        System.out.println("\n--------------------------------");
        System.out.println("       Автомобили марки BMW:    ");
        System.out.println("--------------------------------");
        Car[] carsBMW = cars.filterByBrand("BMW");
        for (Car car : carsBMW) {
            System.out.println(car);
        }

        System.out.println("\n----------------------------------");
        System.out.println("Автомобили марки BMW старше 5 лет:");
        System.out.println("----------------------------------");
        Car[] carsOldBMW = cars.filterByBrandAndYearsOld("BMW", 5);
        for (Car car : carsOldBMW) {
            System.out.println(car);
        }

        System.out.println("\n--------------------------------------------");
        System.out.println("Автомобили 2010 г.в. стоимостью более $1000:");
        System.out.println("--------------------------------------------");
        Car[] cars2010 = cars.filterByYearAndPrice(2010, 1000);
        for (Car car : cars2010) {
            System.out.println(car);
        }
    }
}
