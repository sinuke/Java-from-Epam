package com.sinapps.task06;
/*
    Задания к главе 3
    Вариант A

    Создать классы, спецификации которых приведены ниже. Определить конструкторы и методы
    setТип(), getТип(), toString(). Определить дополнительно методы в классе, создающем
    массив объектов. Задать критерий выбора данных и вывести эти данные на консоль. В
    каждом классе, обладающем информацией, должно быть объявлено несколько конструкторов.

    6. House: id, Номер квартиры, Площадь, Этаж, Количество комнат, Улица, Тип здания, Срок эксплуатации.
    Создать массив объектов. Вывести:
	    a) список квартир, имеющих заданное число комнат;
	    b) список квартир, имеющих заданное число комнат и расположенных на этаже, который находится в заданном промежутке;
	    c) список квартир, имеющих площадь, превосходящую заданную.
 */

public class Main {
    public static void main(String[] args) {
        System.out.println("Список квартир: ");
        Houses houses = new Houses(15);
        for (House house : houses.getHouses()) {
            System.out.println(house);
        }

        System.out.println("\n-----------------------------");
        System.out.println("Список 3-х комнатных квартир:");
        System.out.println("-----------------------------");
        House[] houses3Rooms = houses.filterByRooms(3);
        for (House house : houses3Rooms) {
            System.out.println(house);
        }

        System.out.println("\n---------------------------------------------------------------");
        System.out.println("Список 3-х комнатных квартир, расположенных на этаже с 5 по 10:");
        System.out.println("---------------------------------------------------------------");
        House[] housesRoomsAndFloor = houses.filterByRoomsAndFloor(3, 5, 10);
        for (House house : housesRoomsAndFloor) {
            System.out.println(house);
        }

        System.out.println("\n------------------------------------------");
        System.out.println("Список квартир с площадью более 50 кв. м.:");
        System.out.println("------------------------------------------");
        House[] housesSquare = houses.filterBySquare(50.0D);
        for (House house : housesSquare) {
            System.out.println(house);
        }
    }
}
