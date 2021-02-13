package com.sinapps.task05;
/*
    Задания к главе 3
    Вариант A

    Создать классы, спецификации которых приведены ниже. Определить конструкторы и методы
    setТип(), getТип(), toString(). Определить дополнительно методы в классе, создающем
    массив объектов. Задать критерий выбора данных и вывести эти данные на консоль. В
    каждом классе, обладающем информацией, должно быть объявлено несколько конструкторов.

    5. Book: id, Название, Автор (ы), Издательство, Год издания, Количество страниц, Цена, Тип переплета.
    Создать массив объектов. Вывести:
	    a) список книг заданного автора;
	    b) список книг, выпущенных заданным издательством;
	    c) список книг, выпущенных после заданного года.
 */

public class Main {
    public static void main(String[] args) {
        Books books = new Books(15);
        System.out.println("Список книг:");
        for (Book book : books.getBooks()) {
            System.out.println(book);
        }

        System.out.println("\n-----------------------");
        System.out.println("Книги Дж. Р. Р. Толкин:");
        System.out.println("-----------------------");
        Book[] booksByAuthor = books.filterByAuthor("Дж. Р. Р. Толкин");
        for (Book book : booksByAuthor) {
            System.out.println(book);
        }

        System.out.println("\n---------------------------");
        System.out.println("Книги издательства Pearson:");
        System.out.println("---------------------------");
        Book[] booksByPublisher = books.filterByPublisher("Pearson");
        for (Book book : booksByPublisher) {
            System.out.println(book);
        }

        System.out.println("\n--------------------------------");
        System.out.println("Книги, изданные после 2000 года:");
        System.out.println("--------------------------------");
        Book[] booksByYear = books.filterByYear(2000);
        for (Book book : booksByYear) {
            System.out.println(book);
        }
    }
}
