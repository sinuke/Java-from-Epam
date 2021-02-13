package com.sinapps.task02;
/*
    Задания к главе 3
    Вариант A

    Создать классы, спецификации которых приведены ниже. Определить конструкторы и методы
    setТип(), getТип(), toString(). Определить дополнительно методы в классе, создающем
    массив объектов. Задать критерий выбора данных и вывести эти данные на консоль. В
    каждом классе, обладающем информацией, должно быть объявлено несколько конструкторов.

    2. Customer: id, Фамилия, Имя, Отчество, Адрес, Номер кредитной карточки, Номер банковского счета.
    Создать массив объектов. Вывести:
	    a) список покупателей в алфавитном порядке;
	    b) список покупателей, у которых номер кредитной карточки находится в заданном интервале.
 */

import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        Customers customers = new Customers(20);
        Collections.sort(customers.getCustomers(), Customer.customerSurnameComparator);

        System.out.println("-----------------------------------------");
        System.out.println("Список покупателей в алфавитном порядке: ");
        System.out.println("-----------------------------------------");
        for (Customer customer : customers.getCustomers()) {
            System.out.println(customer);
        }

        System.out.println("---------------------------------------------");
        System.out.println("Список покупателей c картой от 0100 до 1000: ");
        System.out.println("---------------------------------------------");
        Customer[] filteredCustomers = customers.filterByCard(100, 1000);
        for (Customer customer : filteredCustomers) {
            System.out.println(customer);
        }
    }
}
