package com.sinapps.task02;

import java.util.ArrayList;
import java.util.Random;

public class Customers {
    private final ArrayList<Customer> customers;

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

    public Customers(int count) {
        customers = generateCustomersList(count);
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

    private Card generateRandomCard() {
        return new Card(random.nextInt(10000), random.nextInt(10000), random.nextInt(10000), random.nextInt(10000));
    }

    private String generateRandomBankAccountNumber() {
       return "ABC" + String.format("%016d", random.nextInt(Integer.MAX_VALUE)) + "BY";
    }

    private ArrayList<Customer> generateCustomersList(int length) {
        ArrayList<Customer> list = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            Customer customer = new Customer(i, generateRandomSurname(), generateRandomName(), generateRandomMiddleName(),
                    generateRandomAddress(), generateRandomCard(), generateRandomBankAccountNumber());
            list.add(customer);
        }

        return list;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public Customer[] filterByCard(int number1, int number4) {
        int count = 0;
        for (Customer customer : this.customers) {
            if (customer.getCard().inInterval(number1, number4)) {
                count++;
            }
        }

        Customer[] result = new Customer[count];
        int index = -1;
        for (Customer customer : this.customers) {
            if (customer.getCard().inInterval(number1, number4)) {
                index++;
                result[index] = customer;
            }
        }

        return result;
    }
}
