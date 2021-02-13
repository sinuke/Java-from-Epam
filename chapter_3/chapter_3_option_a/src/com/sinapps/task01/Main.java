package com.sinapps.task01;
/*
    Задания к главе 3
    Вариант A

    Создать классы, спецификации которых приведены ниже. Определить конструкторы и методы
    setТип(), getТип(), toString(). Определить дополнительно методы в классе, создающем
    массив объектов. Задать критерий выбора данных и вывести эти данные на консоль. В
    каждом классе, обладающем информацией, должно быть объявлено несколько конструкторов.

    1. Student: id, Фамилия, Имя, Отчество, Дата рождения, Адрес, Телефон, Факультет, Курс, Группа.
    Создать массив объектов. Вывести:
	    a) список студентов заданного факультета;
	    b) списки студентов для каждого факультета и курса;
	    c) список студентов, родившихся после заданного года;
	    d) список учебной группы.
 */

public class Main {

    public static void main(String[] args) {

        Students students = new Students(15);
        System.out.println("Список всех студентов:");
        for (Student student : students.getStudents()) {
            System.out.println(student);
        }

        System.out.println("\n----------------------------------------");
        System.out.println("Список студентов физического факультета:");
        System.out.println("----------------------------------------");
        Student[] physicalStudents = students.filterByFaculty("Физический");
        for (Student student : physicalStudents) {
            System.out.println(student);
        }

        for (String faculty : Students.FACULTIES) {
            System.out.println("\n----------------------------------------");
            System.out.println("Список студентов факультета: " + faculty);
            System.out.println("----------------------------------------");
            Student[] facultyStudents = students.filterByFaculty(faculty);
            for (Student student : facultyStudents) {
                System.out.println(student);
            }
        }

        for (int i = 1; i <= 5; i++) {
            System.out.println("\n----------------------------------------");
            System.out.println("Список студентов " + i + " курса: ");
            System.out.println("----------------------------------------");
            Student[] courseStudents = students.filterByCourse(i);
            for (Student student : courseStudents) {
                System.out.println(student);
            }
        }

        System.out.println("\n----------------------------------------");
        System.out.println("Список студентов с 1988 года рождения:");
        System.out.println("----------------------------------------");
        Student[] students1988 = students.filterByBirthYear(1988);
        for (Student student : students1988) {
            System.out.println(student);
        }

        System.out.println("\n----------------------------------------");
        System.out.println("Список студентов группы Ф11:");
        System.out.println("----------------------------------------");
        Student[] studentsF11 = students.filterByGroup("Ф11");
        for (Student student : studentsF11) {
            System.out.println(student);
        }
    }
}