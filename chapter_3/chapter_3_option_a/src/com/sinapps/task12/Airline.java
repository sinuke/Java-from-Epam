package com.sinapps.task12;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Airline {
    private String destination;
    private String number;
    private String type;
    private Date departure;
    private WeekDays[] days;

    private final SimpleDateFormat departureFormat = new SimpleDateFormat("HH:mm");

    public Airline(String destination, String number, String type, Date departure, WeekDays[] days) {
        this.destination = destination;
        this.number = number;
        this.type = type;
        this.departure = departure;
        this.days = days;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDeparture() {
        return departure;
    }

    public void setDeparture(Date departure) {
        this.departure = departure;
    }

    public WeekDays[] getDays() {
        return days;
    }

    public void setDays(WeekDays[] days) {
        this.days = days;
    }

    @Override
    public String toString() {
        return "Куда: " + getDestination() + "\tРейс: " + getNumber() + "\tСамолёт: " + getType() +
                "\tВылет: " + departureFormat.format(getDeparture()) + "\tДни: " + getDaysString();
    }

    public String getDaysString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < getDays().length; i++) {
            result.append(getDays()[i].getTitle());
            if (i < getDays().length - 1) {
                    result.append(", ");
                }
            }
        return "[" + result.toString() + "]";
    };

    public boolean containsDay(WeekDays day){
        boolean result = false;
        for (WeekDays weekDay : days) {
            if (weekDay == day) {
                result = true;
                break;
            }
        }
        return result;
    }
}
