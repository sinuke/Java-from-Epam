package com.sinapps.task11;

import java.util.Calendar;
import java.util.Random;

public class Buses {
    private final Bus[] buses;
    private final String[] SURNAMES = {"Иванов", "Смирнов", "Кузнецов", "Попов", "Васильев", "Петров", "Соколов",
            "Михайлов", "Новиков", "Фёдоров", "Морозов", "Волков", "Алексеев", "Лебедев", "Семенов", "Егоров",
            "Павлов", "Козлов", "Степанов", "Николаев", "Орлов", "Андреев", "Макаров", "Никитин", "Захаров"};
    private final String SYMBOLS = "АБВГЕЖЗИКЛАМНОПРСТУФХЦЭЮЯ";
    private final String[] BRANDS = {
            "ГАЗ",
            "НЕФАЗ",
            "МАЗ",
            "НЕМАН",
            "СИМАЗ",
            "Mercedes-Benz",
            "Yutong",
            "Zhong Tong"
    };

    private final Random random = new Random();

    public Buses(int count) {
        buses = generateRandomBusesLst(count);
    }

    private Bus[] generateRandomBusesLst(int count) {
        Bus[] result = new Bus[count];
        for (int i = 0; i < result.length; i++) {
            result[i] = new Bus(generateRandomDriver(), generateRandomNumber(), generateRandomRoute(), generateRandomBrand(),
                    generateRandomYear(), generateRandomMileage());
        }
        return result;
    }

    public Bus[] getBuses() {
        return buses;
    }

    private String generateRandomDriver() {
        return SURNAMES[random.nextInt(SURNAMES.length)] + " " + SYMBOLS.charAt(random.nextInt(SYMBOLS.length())) + "." +
                SYMBOLS.charAt(random.nextInt(SYMBOLS.length())) + ".";
    }

    private int generateRandomNumber() {
        return random.nextInt(1000) + 1;
    }

    private String generateRandomRoute() {
        return String.valueOf(random.nextInt(100) + 1) + SYMBOLS.charAt(random.nextInt(SYMBOLS.length()));
    }

    private String generateRandomBrand() {
        return BRANDS[random.nextInt(BRANDS.length)];
    }

    private int generateRandomYear() {
        return random.nextInt(22) + 2000;
    }

    private int generateRandomMileage() {
        return random.nextInt(300_000) + 1;
    }

    public Bus[] filterByRoute(String route) {
        int count = 0;
        for (Bus bus : getBuses()) {
            if (bus.getRoute().equals(route)) {
                count++;
            }
         }

        Bus[] result = new Bus[count];
        int index = -1;
        for (Bus bus : getBuses()) {
            if (bus.getRoute().equals(route)) {
                index++;
                result[index] = bus;
            }
        }
        return result;
    }

    public Bus[] filterByAge(int age) {
        int count = 0;
        Calendar calendar = Calendar.getInstance();

        for (Bus bus : getBuses()) {
            if (calendar.get(Calendar.YEAR) - bus.getYear() > age) {
                count++;
            }
        }

        Bus[] result = new Bus[count];
        int index = -1;
        for (Bus bus : getBuses()) {
            if (calendar.get(Calendar.YEAR) - bus.getYear() > age) {
                index++;
                result[index] = bus;
            }
        }
        return result;
    }

    public Bus[] filterByMileage(int mileage) {
        int count = 0;

        for (Bus bus : getBuses()) {
            if (bus.getMileage() > mileage) {
                count++;
            }
        }

        Bus[] result = new Bus[count];
        int index = -1;
        for (Bus bus : getBuses()) {
            if (bus.getMileage() > mileage) {
                index++;
                result[index] = bus;
            }
        }
        return result;
    }
}
