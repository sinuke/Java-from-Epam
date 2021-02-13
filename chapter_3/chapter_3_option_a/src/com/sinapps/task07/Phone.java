package com.sinapps.task07;

import java.util.Comparator;
import java.util.Locale;

public class Phone {
    private int id;
    private String surname;
    private String name;
    private String middleName;
    private String address;
    private Card card;
    private double debit;
    private double credit;
    private int inCityTime;
    private int outCityTime;

    public Phone(int id, String surname, String middleName, String name, String address, Card card, double debit, double credit,
                 int inCityTime, int outCityTime) {
        setId(id);
        setSurname(surname);
        setMiddleName(middleName);
        setName(name);
        setAddress(address);
        setCard(card);
        setDebit(debit);
        setCredit(credit);
        setCard(card);
        setInCityTime(inCityTime);
        setOutCityTime(outCityTime);
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

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public double getDebit() {
        return debit;
    }

    public void setDebit(double debit) {
        this.debit = debit;
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    public int getInCityTime() {
        return inCityTime;
    }

    public void setInCityTime(int inCityTime) {
        this.inCityTime = inCityTime;
    }

    public int getOutCityTime() {
        return outCityTime;
    }

    public void setOutCityTime(int outCityTime) {
        this.outCityTime = outCityTime;
    }

    public String getFullName() {
        return getSurname() + " " + getName() + " " + getMiddleName();
    }

    public static String secondsToString(int seconds) {
        int numberOfDays;
        int numberOfHours;
        int numberOfMinutes;
        int numberOfSeconds;

        numberOfDays = seconds / 86400;
        numberOfHours = (seconds % 86400 ) / 3600 ;
        numberOfMinutes = ((seconds % 86400 ) % 3600 ) / 60;
        numberOfSeconds = ((seconds % 86400 ) % 3600 ) % 60;

        String result = (numberOfDays > 0) ? (numberOfDays + " д. ") : "";

        result += String.format("%02d", numberOfHours) + ":" + String.format("%2d", numberOfMinutes) + ":" +
                String.format("%02d", numberOfSeconds);

        return result;
    }

    public static Comparator<Phone> phoneSurnameComparator = new Comparator<Phone>() {
        @Override
        public int compare(Phone o1, Phone o2) {
            String fullName1 = o1.getFullName().toUpperCase(Locale.ROOT);
            String fullName2 = o2.getFullName().toUpperCase(Locale.ROOT);
            return  fullName1.compareTo(fullName2);
        }
    };

    @Override
    public String toString() {
        return getId() + "\t" + getFullName() + "\t" + getAddress() + "\t" + getCard() + "\tD: " +
                String.format("%.2f", getDebit()) + "\t C:" + String.format("%.2f", getCredit()) + "\t" +
                secondsToString(inCityTime) + "\t" + secondsToString(outCityTime);
    }
}
