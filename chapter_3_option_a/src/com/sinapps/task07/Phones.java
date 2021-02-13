package com.sinapps.task07;

import java.util.ArrayList;
import java.util.Random;

public class Phones {
    private final ArrayList<Phone> phones;

    private final String[] NAMES = {"Михаил", "Максим", "Иван", "Артем", "Дмитрий", "Даниил", "Марк", "Лев", "Матвей"};
    private final String[] SURNAMES = {"Иванов", "Смирнов", "Кузнецов", "Попов", "Васильев", "Петров", "Соколов",
            "Михайлов", "Новиков", "Фёдоров", "Морозов", "Волков", "Алексеев", "Лебедев", "Семенов", "Егоров",
            "Павлов", "Козлов", "Степанов", "Николаев", "Орлов", "Андреев", "Макаров", "Никитин", "Захаров"};
    private final String[] MIDDLE_NAMES = {"Алексеевич", "Артёмович", "Вадимович", "Владимирович", "Валентинович",
            "Данилович", "Денисович", "Дмитриевич", "Егорович", "Кириллович", "Леонидович", "Максимович", "Матвеевич",
            "Никитович", "Олегович", "Павлович", "Петрович", "Романович", "Сергеевич", "Станиславович"};
    private final String[] ADDRESSES = {"г. Гомель, ул. Советская д. 1 кв. 10", "г. Минск, ул Мельникайте д. 12 кв. 45",
            "г. Витебск, п-т Ленина д. 34 кв. 18", "г. Гродно, ул. Макарова д. 16", "г. Брест, ул. Советская д. 16 кв. 54",
            "г. Могилев, ул. 50-лет БССР д. 17 кв. 123"};

    private final Random random = new Random();

    public Phones(int count) {
        phones = generateRandomPhonesList(count);
    }

    private ArrayList<Phone> generateRandomPhonesList(int length) {
        ArrayList<Phone> result = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            result.add(new Phone(i, generateRandomSurname(), generateRandomMiddleName(), generateRandomName(),
                    generateRandomAddress(), generateRandomCard(), generateRandomMoney(), generateRandomMoney(),
                    generateRandomSeconds(), generateRandomSeconds()));
        }
        return result;
    }

    private String generateRandomName() {
        return NAMES[random.nextInt(NAMES.length)];
    }

    private String generateRandomSurname() {
        return SURNAMES[random.nextInt(SURNAMES.length)];
    }

    private String generateRandomMiddleName() {
        return MIDDLE_NAMES[random.nextInt(MIDDLE_NAMES.length)];
    }

    private String generateRandomAddress() {
        return ADDRESSES[random.nextInt(ADDRESSES.length)];
    }

    private double generateRandomMoney() {
        return random.nextDouble() * 100;
    }

    private int generateRandomSeconds() {
        return random.nextInt(5000);
    }

    private Card generateRandomCard() {
        return new Card(random.nextInt(10000), random.nextInt(10000), random.nextInt(10000), random.nextInt(10000));
    }

    public ArrayList<Phone> getPhones() {
        return phones;
    }

    public ArrayList<Phone> filterByInCityTime(int seconds) {
        ArrayList<Phone> result = new ArrayList<>();
        for (Phone phone : getPhones()) {
            if (phone.getInCityTime() > seconds) {
                result.add(phone);
            }
        }
        return result;
    }

    public ArrayList<Phone> filterByOutCityTime() {
        ArrayList<Phone> result = new ArrayList<>();
        for (Phone phone : getPhones()) {
            if (phone.getOutCityTime() > 0) {
                result.add(phone);
            }
        }
        return result;
    }
}
