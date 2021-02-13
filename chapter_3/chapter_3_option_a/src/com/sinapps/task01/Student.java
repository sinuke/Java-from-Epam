package com.sinapps.task01;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Student {
    private int id;
    private String surname;
    private String name;
    private String middleName;
    private Date birth;
    private String address;
    private String phone;
    private String faculty;
    private int course;
    private String group;

    private final SimpleDateFormat birthFormat = new SimpleDateFormat("dd/MM/yyyy");

    public Student(int id, String surname, String name, String middleName, Date birth, String address, String phone,
                   String faculty, int course, String group) {
        setId(id);
        setSurname(surname);
        setName(name);
        setMiddleName(middleName);
        setBirth(birth);
        setAddress(address);
        setPhone(phone);
        setFaculty(faculty);
        setCourse(course);
        setGroup(group);
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

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
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

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return getId() + "\t" + getSurname() + " " + getName() + " " + getMiddleName() + "\t" +
               birthFormat.format(getBirth()) + "\t" + getAddress() + "\t" + getPhone() + "\t" +
               getCourse() + "\t" + getFaculty() + "\t" + getGroup();

    }
}
