package com.sinapps.task10;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class Trains {
    private final Train[] trains;
    private final String[] DESTINATIONS = {
            "Гонконг-Пассажирский",
            "Бангкок-Пассажирский",
            "Макао-Пассажирский",
            "Сингапур-Пассажирский",
            "Лондон-Пассажирский",
            "Париж-Пассажирский",
            "Дубай-Пассажирский",
            "Дели-Пассажирский",
            "Стамбул-Пассажирский",
            "Куала-Лумпур-Пассажирский"
        };
    private final Random random = new Random();
    private final SimpleDateFormat departureFormat = new SimpleDateFormat("HH:mm");

    public Trains(int count) {
        trains = generateRandomTrainsList(count);
    }

    public Train[] getTrains() {
        return trains;
    }

    private Train[] generateRandomTrainsList(int count) {
        Train[] result = new Train[count];
        for (int i = 0; i < result.length; i++) {
            result[i] = new Train(generateRandomDestination(), generateRandomNumber(), generateRandomTime(), generateRandomCount(),
                    generateRandomCount(), generateRandomCount(), generateRandomCount());
        }
        return result;
    }

    private int generateRandomNumber() {
        return random.nextInt(900) + 100;
    }

    private String generateRandomDestination() {
        return DESTINATIONS[random.nextInt(DESTINATIONS.length)];
    }

    private Date generateRandomTime() {
        return new Date(random.nextLong());
    }

    private int generateRandomCount() {
        return random.nextInt(101);
    }

    public Train[] filterByDestination(String destination) {
        int count = 0;
        for (Train train : getTrains()) {
            if (train.getDestination().equals(destination)) {
                count ++;
            }
        }

        Train[] result = new Train[count];
        int index = -1;
        for (Train train : getTrains()) {
            if (train.getDestination().equals(destination)) {
                index ++;
                result[index] = train;
            }
        }

        return result;
    }

    public Train[] filterByDestinationAndTime(String destination, String time) {
        try {
            int count = 0;
            Date needTime = departureFormat.parse(time);
            Calendar departure = Calendar.getInstance();
            Calendar neededTime = Calendar.getInstance();
            neededTime.setTime(needTime);

            int h2 = neededTime.get(Calendar.HOUR_OF_DAY);
            int m2 = neededTime.get(Calendar.MINUTE);

            for (Train train : getTrains()) {
                departure.setTime(train.getDeparture());
                int h1 = departure.get(Calendar.HOUR_OF_DAY);
                int m1 = departure.get(Calendar.MINUTE);
                if (train.getDestination().equals(destination) && (h1 > h2 || (h1 == h2 && m1 > m2))) {
                    count ++;
                }
            }

            Train[] result = new Train[count];
            int index = -1;
            for (Train train : getTrains()) {
                departure.setTime(train.getDeparture());
                int h1 = departure.get(Calendar.HOUR_OF_DAY);
                int m1 = departure.get(Calendar.MINUTE);
                if (train.getDestination().equals(destination) && (h1 > h2 || (h1 == h2 && m1 > m2))) {
                    index ++;
                    result[index] = train;
                }
            }

            return result;
        } catch (ParseException e) {
            return new Train[0];
        }
    }

    public Train[] filterByDestinationAndCommon(String destination) {
        int count = 0;
        for (Train train : getTrains()) {
            if (train.getDestination().equals(destination) && train.getCommonCount() > 0) {
                count ++;
            }
        }

        Train[] result = new Train[count];
        int index = -1;
        for (Train train : getTrains()) {
            if (train.getDestination().equals(destination) && train.getCommonCount() > 0) {
                index ++;
                result[index] = train;
            }
        }

        return result;
    }
}
