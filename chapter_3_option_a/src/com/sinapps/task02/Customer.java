package com.sinapps.task02;

import java.util.Comparator;
import java.util.Locale;

public class Customer {
    private int id;
    private String surname;
    private String name;
    private String middleName;
    private String address;
    private Card card;
    private String bankAccountNumber;

    public Customer() {

    }

    public Customer(int id, String surname, String name, String middleName, String address,
                    Card card, String bankAccountNumber) {
        setId(id);
        setSurname(surname);
        setName(name);
        setMiddleName(middleName);
        setAddress(address);
        setCard(card);
        setBankAccountNumber(bankAccountNumber);
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

    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    public void setBankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }

    public String getFullName() {
        return getSurname() + " " + getName() + " " + getMiddleName();
    }

    public static Comparator<Customer> customerSurnameComparator = new Comparator<Customer>() {
        @Override
        public int compare(Customer o1, Customer o2) {
            String fullName1 = o1.getFullName().toUpperCase(Locale.ROOT);
            String fullName2 = o2.getFullName().toUpperCase(Locale.ROOT);
            return  fullName1.compareTo(fullName2);
        }
    };

    @Override
    public String toString() {
        return getId() + "\t" + getFullName() + "\t" + getAddress() + "\t" + getCard() + "\t" + getBankAccountNumber();
    }
}
