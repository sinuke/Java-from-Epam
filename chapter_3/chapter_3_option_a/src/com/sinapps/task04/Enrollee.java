package com.sinapps.task04;

import java.util.Comparator;

public class Enrollee {
    //id, Фамилия, Имя, Отчество, Адрес, Телефон, Оценки.
    private int id;
    private String surname;
    private String name;
    private String middleName;
    private String address;
    private String phone;
    private int[] marks;

    public Enrollee() {

    }

    public Enrollee(int id, String surname, String name, String middleName, String address, String phone, int[] marks) {
        setId(id);
        setSurname(surname);
        setName(name);
        setMiddleName(middleName);
        setAddress(address);
        setPhone(phone);
        setMarks(marks);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int[] getMarks() {
        return marks;
    }

    public void setMarks(int[] marks) {
        this.marks = marks;
    }

    public String getFullName() {
        return getSurname() + " " + getName() + " " + getMiddleName();
    }

    private String getMarksString() {
        String result = "[";
        for (int i = 0; i < getMarks().length; i++) {
            if (i < getMarks().length - 1) {
                result += getMarks()[i] + ", ";
            } else {
                result += getMarks()[i] + "]";
            }
        }
        return result;
    }

    public boolean hasNegativeMark() {
        boolean result = false;
        for (int mark : getMarks()) {
            if (mark < 3) {
                result = true;
                break;
            }
        }

        return result;
    }

    public int getSumMarks() {
        int result = 0;
        for (int mark : getMarks()) {
            result += mark;
        }
        return result;
    }

    @Override
    public String toString() {
        return getId() + "\t" + getFullName() + "\t" + getAddress() + "\t" + getPhone() + "\t" +
                getMarksString();
    }

    public static Comparator<Enrollee> enrolleeSumMarksComparator = new Comparator<Enrollee>() {
        @Override
        public int compare(Enrollee o1, Enrollee o2) {
            int sumMarks1 = o1.getSumMarks();
            int sumMarks2 = o2.getSumMarks();
            return  sumMarks2 - sumMarks1;
        }
    };
}
