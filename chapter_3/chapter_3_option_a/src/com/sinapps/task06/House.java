package com.sinapps.task06;

public class House {
    //id, Номер квартиры, Площадь, Этаж, Количество комнат, Улица, Тип здания, Срок эксплуатации.
    private int id;
    private int number;
    private double square;
    private int floor;
    private int rooms;
    private String street;
    private String building;
    private int age;

    public House(int id, int number, double square, int floor, int rooms, String street, String building, int age) {
        setId(id);
        setNumber(number);
        setSquare(square);
        setFloor(floor);
        setRooms(rooms);
        setStreet(street);
        setBuilding(building);
        setAge(age);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getSquare() {
        return square;
    }

    public void setSquare(double square) {
        this.square = square;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return getId() + ". ул. " + getStreet() + ", кв. " + getNumber() + ", этаж: " + getFloor() + ", комнат: " +
               getRooms() + ", площадь: " + String.format("%.2f", getSquare()) + " м. кв., здание: " + getBuilding() +
               ", в эксплуатации: " + getAge() + " лет";
    }
}

