package com.sinapps.task09;
/*
    Задания к главе 3
    Вариант A

    Создать классы, спецификации которых приведены ниже. Определить конструкторы и методы
    setТип(), getТип(), toString(). Определить дополнительно методы в классе, создающем
    массив объектов. Задать критерий выбора данных и вывести эти данные на консоль. В
    каждом классе, обладающем информацией, должно быть объявлено несколько конструкторов.

    9. Product: id, Наименование, UPC, Производитель, Цена, Срок хранения, Количество.
    Создать массив объектов. Вывести:
	    a) список товаров для заданного наименования;
	    b) список товаров для заданного наименования, цена которых не превосходит заданную;
	    c) список товаров, срок хранения которых больше заданного.
 */

public class Main {
    public static void main(String[] args) {
        Products products = new Products(15);
        for (Product product : products.getProducts()) {
            System.out.println(product);
        }

        System.out.println("\n------------------------------");
        System.out.println("     Список товаров: Кофе     ");
        System.out.println("------------------------------");
        Product[] productsByName = products.filterByName("Кофе");
        for (Product product : productsByName) {
            System.out.println(product);
        }

        System.out.println("\n--------------------------------------------");
        System.out.println("Список товаров: Кофе, стоимостью не более $5");
        System.out.println("--------------------------------------------");
        Product[] productsByNameAndPrice = products.filterByNameAndPrice("Кофе", 5);
        for (Product product : productsByNameAndPrice) {
            System.out.println(product);
        }

        System.out.println("\n---------------------------------------------");
        System.out.println("Список товаров со сроком хранения более 2 лет");
        System.out.println("---------------------------------------------");
        Product[] productsByBestBefore = products.filterByBestBefore(2);
        for (Product product : productsByBestBefore) {
            System.out.println(product);
        }
    }
}
