package com.sinapps.task03;
/*
    Задания к главе 3
    Вариант A

    Создать классы, спецификации которых приведены ниже. Определить конструкторы и методы
    setТип(), getТип(), toString(). Определить дополнительно методы в классе, создающем
    массив объектов. Задать критерий выбора данных и вывести эти данные на консоль. В
    каждом классе, обладающем информацией, должно быть объявлено несколько конструкторов.

    3. Patient: id, Фамилия, Имя, Отчество, Адрес, Телефон, Номер медицинской карты, Диагноз.
    Создать массив объектов. Вывести:
	    a) список пациентов, имеющих данный диагноз;
	    b) список пациентов, номер медицинской карты которых находится в заданном интервале.
 */

public class Main {
    public static void main(String[] args) {
        System.out.println("------------------------------------");
        System.out.println("       Список всех пациентов:");
        System.out.println("------------------------------------");
        Patients patients = new Patients(15);
        for (Patient patient : patients.getPatients()) {
            System.out.println(patient);
        }

        System.out.println("\n------------------------------------");
        System.out.println(" Список пациентов c диагнозом СПИД:");
        System.out.println("------------------------------------");
        Patient[] diagnosisPatients = patients.filterByDiagnosis("СПИД");
        for (Patient patient : diagnosisPatients) {
            System.out.println(patient);
        }

        System.out.println("\n----------------------------------------------------");
        System.out.println("Список пациентов с картами от 10000000 до 100000000:");
        System.out.println("----------------------------------------------------");
        Patient[] cardIdsPatients = patients.filterByCardIdInterval(10000000, 100000000);
        for (Patient patient : cardIdsPatients) {
            System.out.println(patient);
        }
    }
}
