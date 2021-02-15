package com.sinapps.task10;
/*
    Задания к главе 3
    Вариант A

    Создать классы, спецификации которых приведены ниже. Определить конструкторы и методы
    setТип(), getТип(), toString(). Определить дополнительно методы в классе, создающем
    массив объектов. Задать критерий выбора данных и вывести эти данные на консоль. В
    каждом классе, обладающем информацией, должно быть объявлено несколько конструкторов.

    10. Train: Пункт назначения, Номер поезда, Время отправления, Число мест (общих, купе, плацкарт, люкс).
    Создать массив объектов. Вывести:
	    a) список поездов, следующих до заданного пункта назначения;
	    b) список поездов, следующих до заданного пункта назначения и отправляющихся после заданного часа;
	    c) список поездов, отправляющихся до заданного пункта назначения и имеющих общие места.
 */

public class Main {
    public static void main(String[] args) {
        Trains trains = new Trains(15);
        for (Train train : trains.getTrains()) {
            System.out.println(train);
        }

        System.out.println("\n---------------------------------------------");
        System.out.println("Список поездов до станции: Париж-Пассажирский");
        System.out.println("---------------------------------------------");
        Train[] trainsToParis = trains.filterByDestination("Париж-Пассажирский");
        for (Train train : trainsToParis) {
            System.out.println(train);
        }

        System.out.println("\n-------------------------------------------------------------------------");
        System.out.println("Список поездов до станции: Париж-Пассажирский, отправляющихся после 06:00");
        System.out.println("-------------------------------------------------------------------------");
        Train[] trainsToParis6AM = trains.filterByDestinationAndTime("Париж-Пассажирский", "06:00");
        for (Train train : trainsToParis6AM) {
            System.out.println(train);
        }

        System.out.println("\n------------------------------------------------------------------");
        System.out.println("Список поездов до станции: Париж-Пассажирский, имеющий общие места");
        System.out.println("------------------------------------------------------------------");
        Train[] trainsToParisCommon = trains.filterByDestinationAndCommon("Париж-Пассажирский");
        for (Train train : trainsToParisCommon) {
            System.out.println(train);
        }
    }
}
