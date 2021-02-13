package com.sinapps.task06;

import java.util.Random;

public class Houses  {
    private final House[] houses;

    private final String[] streets = {
            "Центральная",
            "Молодежная",
            "Школьная",
            "Лесная",
            "Садовая",
            "Советская",
            "Новая",
            "Набережная",
            "Заречная",
            "Зеленая"
    };

    private final String[] buildings = {
            "Деревянное",
            "Каменнеое",
            "Бетонное",
            "Кирпичное",
            "Железобетонное",
            "Из металлоконструкции"
    };

    private final Random random = new Random();

    public Houses(int count) {
        houses = generateHousesRandomList(count);
    }

    public House[] getHouses() {
        return houses;
    }

    private House[] generateHousesRandomList(int length) {
        House[] result = new House[length];
        for (int i = 0; i < length; i++) {
            result[i] = new House(i, generateRandomNumber(), generateRandomSquare(),
                    generateRandomFloor(), generateRandomRooms(), generateRandomStreet(),
                    generateRandomBuilding(), generateRandomAge());
        }
        return result;
    }

    private int generateRandomNumber() {
        return (random.nextInt(100) + 1);
    }

    private double generateRandomSquare() {
        return (random.nextDouble() * 50 + 12.0D);
    }

    private int generateRandomFloor() {
        return (random.nextInt(10) + 1);
    }

    private int generateRandomRooms() {
        return (random.nextInt(5) + 1);
    }

    private String generateRandomStreet() {
        return (streets[random.nextInt(streets.length)]);
    }

    private String generateRandomBuilding() {
        return (buildings[random.nextInt(buildings.length)]);
    }

    private int generateRandomAge() {
        return (random.nextInt(50) + 1);
    }

    public House[] filterByRooms(int rooms) {
        int count = 0;
        for (House house : getHouses()) {
            if (house.getRooms() == rooms) {
                count++;
            }
        }

        House[] result = new House[count];
        int index = -1;
        for (House house : getHouses()) {
            if (house.getRooms() == rooms) {
                index++;
                result[index] = house;
            }
        }

        return result;
    }

    public House[] filterByRoomsAndFloor(int rooms, int startFloor, int endFloor) {
        int count = 0;
        for (House house : getHouses()) {
            if (house.getRooms() == rooms && house.getFloor() >= startFloor && house.getFloor() <= endFloor) {
                count++;
            }
        }

        House[] result = new House[count];
        int index = -1;
        for (House house : getHouses()) {
            if (house.getRooms() == rooms && house.getFloor() >= startFloor && house.getFloor() <= endFloor) {
                index++;
                result[index] = house;
            }
        }

        return result;
    }

    public House[] filterBySquare(double square) {
        int count = 0;
        for (House house : getHouses()) {
            if (house.getSquare() > square) {
                count++;
            }
        }

        House[] result = new House[count];
        int index = -1;
        for (House house : getHouses()) {
            if (house.getSquare() > square) {
                index++;
                result[index] = house;
            }
        }

        return result;
    }
}
