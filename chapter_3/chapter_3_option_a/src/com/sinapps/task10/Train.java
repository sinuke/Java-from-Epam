package com.sinapps.task10;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Train {
    private String destination;
    private int number;
    private Date departure;

    private int commonCount;
    private int compartmentCount;
    private int reservedSeatCount;
    private int luxuryCount;

    private final SimpleDateFormat departureFormat = new SimpleDateFormat("HH:mm");

    public Train(String destination, int number, Date departure, int commonCount, int compartmentCount, int reservedSeatCount, int luxuryCount) {
        this.destination = destination;
        this.number = number;
        this.departure = departure;
        this.commonCount = commonCount;
        this.compartmentCount = compartmentCount;
        this.reservedSeatCount = reservedSeatCount;
        this.luxuryCount = luxuryCount;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Date getDeparture() {
        return departure;
    }

    public void setDeparture(Date departure) {
        this.departure = departure;
    }

    public int getCommonCount() {
        return commonCount;
    }

    public void setCommonCount(int commonCount) {
        this.commonCount = commonCount;
    }

    public int getCompartmentCount() {
        return compartmentCount;
    }

    public void setCompartmentCount(int compartmentCount) {
        this.compartmentCount = compartmentCount;
    }

    public int getReservedSeatCount() {
        return reservedSeatCount;
    }

    public void setReservedSeatCount(int reservedSeatCount) {
        this.reservedSeatCount = reservedSeatCount;
    }

    public int getLuxuryCount() {
        return luxuryCount;
    }

    public void setLuxuryCount(int luxuryCount) {
        this.luxuryCount = luxuryCount;
    }

    @Override
    public String toString() {
        return "#" + getNumber() + "\t" + getDestination() + "\t" + departureFormat.format(getDeparture()) +
                "\tОбщие: " + getCommonCount() + "\tКупе: " + getCompartmentCount() + "\tПлацкарт: " + getReservedSeatCount() +
                "\tЛюкс: " + getLuxuryCount();
    }
}
