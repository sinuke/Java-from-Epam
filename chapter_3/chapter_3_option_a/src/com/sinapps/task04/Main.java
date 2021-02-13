package com.sinapps.task04;
/*
    Задания к главе 3
    Вариант A

    Создать классы, спецификации которых приведены ниже. Определить конструкторы и методы
    setТип(), getТип(), toString(). Определить дополнительно методы в классе, создающем
    массив объектов. Задать критерий выбора данных и вывести эти данные на консоль. В
    каждом классе, обладающем информацией, должно быть объявлено несколько конструкторов.

    4. Abiturient: id, Фамилия, Имя, Отчество, Адрес, Телефон, Оценки.
    Создать массив объектов. Вывести:
	    a) список абитуриентов, имеющих неудовлетворительные оценки;
	    b) список абитуриентов, у которых сумма баллов выше заданной;
	    c) выбрать заданное число n абитуриентов, имеющих самую высокую
	    сумму баллов (вывести также полный список абитуриентов, имеющих
	    полупроходную сумму).
 */

public class Main {
    public static void main(String[] args) {
        System.out.println("-------------------------------------");
        System.out.println("       Список всех абитуриентов     :");
        System.out.println("-------------------------------------");
        Enrollees enrollees = new Enrollees(25, 5);
        for (Enrollee enrollee : enrollees.getEnrollees()) {
            System.out.println(enrollee);
        }

        System.out.println("\n----------------------------------------------");
        System.out.println("Список абитуриентов c отрицательными оценками:");
        System.out.println("----------------------------------------------");
        Enrollee[] enrolleesWithNegativeMarks = enrollees.filterByNegativeMarks();
        for (Enrollee enrollee : enrolleesWithNegativeMarks) {
            System.out.println(enrollee);
        }

        System.out.println("\n---------------------------------------------");
        System.out.println("Список абитуриентов с суммой баллов больше 35:");
        System.out.println("---------------------------------------------");
        Enrollee[] enrolleesSumMarks = enrollees.filterBySumMarks(35);
        for (Enrollee enrollee : enrolleesSumMarks) {
            System.out.println(enrollee);
        }

        System.out.println("\n----------------------------------------------------");
        System.out.println("Список 10 абитуриентов с максимальной суммой баллов:");
        System.out.println("----------------------------------------------------");
        Enrollee[] enrolleesMaxMarks = enrollees.filterMaxSumMarks(10);
        for (Enrollee enrollee : enrolleesMaxMarks) {
            System.out.println(enrollee);
        }

        System.out.println("\n-------------------------------------------");
        System.out.println("Список абитуриентов с полупроходным баллом:");
        System.out.println("-------------------------------------------");
        Enrollee[] enrolleeSemiMark = enrollees.filterSemiMarks(10);
        for (Enrollee enrollee : enrolleeSemiMark) {
            System.out.println(enrollee);
        }
    }
}
