package com.sinapps.task03;

public class Patient {
    private int id;
    private String surname;
    private String name;
    private String middleName;
    private String address;
    private String phone;
    private int cardId;
    private String diagnosis;

    public Patient() {

    }

    public Patient(int id, String surname, String name, String middleName, String address, String phone, int cardId, String diagnosis) {
        setId(id);
        setSurname(surname);
        setName(name);
        setMiddleName(middleName);
        setAddress(address);
        setPhone(phone);
        setCardId(cardId);
        setDiagnosis(diagnosis);
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

    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getFullName() {
        return getSurname() + " " + getName() + " " + getMiddleName();
    }

    @Override
    public String toString() {
        return getId() + "\t" + getFullName() + "\t" + getAddress() + "\t" + getPhone() + "\t" +
                String.format("%012d", getCardId()) + "\t" + getDiagnosis();
    }
}
