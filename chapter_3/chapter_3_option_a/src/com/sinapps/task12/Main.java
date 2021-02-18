package com.sinapps.task12;
/*
    Задания к главе 3
    Вариант A

    Создать классы, спецификации которых приведены ниже. Определить конструкторы и методы
    setТип(), getТип(), toString(). Определить дополнительно методы в классе, создающем
    массив объектов. Задать критерий выбора данных и вывести эти данные на консоль. В
    каждом классе, обладающем информацией, должно быть объявлено несколько конструкторов.

    12. Airline: Пункт назначения, Номер рейса, Тип самолета, Время вылета, Дни недели.
    Создать массив объектов. Вывести:
	    a) список рейсов для заданного пункта назначения;
	    b) список рейсов для заданного дня недели;
	    c) список рейсов для заданного дня недели, время вылета для которых больше заданного.
 */

public class Main {
    public static void main(String[] args) {
        Airlines airlines = new Airlines(15);
        for (Airline airline : airlines.getAirlines()) {
            System.out.println(airline);
        }

        System.out.println("\n-------------------------------");
        System.out.println("    Список рейсов до Парижа:   ");
        System.out.println("-------------------------------");
        Airline[] airlinesToParis = airlines.filterByDestination("Париж");
        for (Airline airline : airlinesToParis) {
            System.out.println(airline);
        }

        System.out.println("\n-------------------------------");
        System.out.println("Список рейсов, вылетающих в СР:");
        System.out.println("-------------------------------");
        Airline[] airlinesWednesday = airlines.filterByDay(WeekDays.WEDNESDAY);
        for (Airline airline : airlinesWednesday) {
            System.out.println(airline);
        }

        System.out.println("\n-------------------------------------------");
        System.out.println("Список рейсов, вылетающих в СР после 10:00:");
        System.out.println("-------------------------------------------");
        Airline[] airlinesWednesday10AM = airlines.filterByDayAndTime(WeekDays.WEDNESDAY, "10:00");
        for (Airline airline : airlinesWednesday10AM) {
            System.out.println(airline);
        }
    }
}
