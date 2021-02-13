package com.sinapps.task07;
/*
    Задания к главе 3
    Вариант A

    Создать классы, спецификации которых приведены ниже. Определить конструкторы и методы
    setТип(), getТип(), toString(). Определить дополнительно методы в классе, создающем
    массив объектов. Задать критерий выбора данных и вывести эти данные на консоль. В
    каждом классе, обладающем информацией, должно быть объявлено несколько конструкторов.

    7. Phone: id, Фамилия, Имя, Отчество, Адрес, Номер кредитной карточки, Дебет, Кредит, Время
    городских и междугородных разговоров. Создать массив объектов. Вывести:
	    a) сведения об абонентах, у которых время внутригородских разговоров
	    превышает заданное;
	    b) сведения об абонентах, которые пользовались междугородной связью;
	    c) сведения об абонентах в алфавитном порядке.
 */

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        Phones phones = new Phones(15);
        Collections.sort(phones.getPhones(), Phone.phoneSurnameComparator);

        System.out.println("-------------------------------------------");
        System.out.println("Сведения об абонентах в алфавитном порядке:");
        System.out.println("-------------------------------------------");
        for (Phone phone : phones.getPhones()) {
            System.out.println(phone);
        }

        System.out.println("\n-----------------------------------------------------------------------");
        System.out.println("Сведения об абонентах с городскими звонками длительностью более 1 часа:");
        System.out.println("-----------------------------------------------------------------------");
        ArrayList<Phone> phonesInCity = phones.filterByInCityTime(3600);
        for (Phone phone : phonesInCity) {
            System.out.println(phone);
        }

        System.out.println("\n------------------------------------------------");
        System.out.println("Сведения об абонентах с междугородними звонками:");
        System.out.println("------------------------------------------------");
        ArrayList<Phone> phonesOutCity = phones.filterByOutCityTime();
        for (Phone phone : phonesOutCity) {
            System.out.println(phone);
        }
    }
}
