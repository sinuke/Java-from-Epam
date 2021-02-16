package com.sinapps.task11;
/*
    Задания к главе 3
    Вариант A

    Создать классы, спецификации которых приведены ниже. Определить конструкторы и методы
    setТип(), getТип(), toString(). Определить дополнительно методы в классе, создающем
    массив объектов. Задать критерий выбора данных и вывести эти данные на консоль. В
    каждом классе, обладающем информацией, должно быть объявлено несколько конструкторов.

    11. Bus: Фамилия и инициалы водителя, Номер автобуса, Номер маршрута, Марка, Год начала эксплуатации, Пробег.
    Создать массив объектов. Вывести:
	    a) список автобусов для заданного номера маршрута;
	    b) список автобусов, которые эксплуатируются больше заданного срока;
	    c) список автобусов, пробег у которых больше заданного расстояния.
 */

public class Main {
    public static void main(String[] args) {
        Buses buses = new Buses(15);
        for (Bus bus : buses.getBuses()) {
            System.out.println(bus);
        }

        System.out.println("\n------------------------------");
        System.out.println("Список автобусов 10А маршрута:");
        System.out.println("------------------------------");
        Bus[] busesRoute = buses.filterByRoute("10А");
        for (Bus bus : busesRoute) {
            System.out.println(bus);
        }

        System.out.println("\n------------------------------------------------");
        System.out.println("Список автобусов, эксплуатирующихся более 5 лет:");
        System.out.println("------------------------------------------------");
        Bus[] busesAge = buses.filterByAge(5);
        for (Bus bus : busesAge) {
            System.out.println(bus);
        }

        System.out.println("\n---------------------------------------------");
        System.out.println("Список автобусов с пробегом более 100 000 км:");
        System.out.println("---------------------------------------------");
        Bus[] busesMileage = buses.filterByMileage(100_000);
        for (Bus bus : busesMileage) {
            System.out.println(bus);
        }
    }
}
