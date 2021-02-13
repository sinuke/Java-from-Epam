package com.sinapps.task04;

import java.util.Arrays;
import java.util.Random;

public class Enrollees {
    private final Enrollee[] enrollees;

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

    public Enrollees(int count, int countMarks) {
        enrollees = generateEnrolleesList(count, countMarks);
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

    private String generateRandomPhone() {
        String phone = "+37529";
        for (int i = 0; i < 7; i++) {
            phone = phone + random.nextInt(10);
        }
        return phone;
    }

    private int[] generateRandomMarks(int count) {
        int[] result = new int[count];
        for (int i = 0; i < count; i++) {
            result[i] = random.nextInt(10) + 1;
        }
        return result;
    }

    private Enrollee[] generateEnrolleesList(int length, int countMarks) {
        Enrollee[] result = new Enrollee[length];

        for (int i = 0; i < length; i++) {
            result[i] = new Enrollee(i, generateRandomSurname(), generateRandomName(), generateRandomMiddleName(),
                    generateRandomAddress(), generateRandomPhone(), generateRandomMarks(countMarks));
        }

        return result;
    }

    public Enrollee[] getEnrollees() {
        return enrollees;
    }

    public Enrollee[] filterByNegativeMarks() {
        int count = 0;
        for (Enrollee enrollee : getEnrollees()) {
            if (enrollee.hasNegativeMark()) {
                count++;
            }
        }

        Enrollee[] result = new Enrollee[count];
        int index = -1;
        for (Enrollee enrollee : getEnrollees()) {
            if (enrollee.hasNegativeMark()) {
                index++;
                result[index] = enrollee;
            }
        }

        return result;
    }

    public Enrollee[] filterBySumMarks (int sum) {
        int count = 0;
        for (Enrollee enrollee : getEnrollees()) {
            if (enrollee.getSumMarks() > sum) {
                count++;
            }
        }

        Enrollee[] result = new Enrollee[count];
        int index = -1;
        for (Enrollee enrollee : getEnrollees()) {
            if (enrollee.getSumMarks() > sum) {
                index++;
                result[index] = enrollee;
            }
        }

        return result;
    }

    public Enrollee[] filterMaxSumMarks(int count) {
        if (count > getEnrollees().length) {
            return getEnrollees();
        } else {
            Arrays.sort(getEnrollees(), Enrollee.enrolleeSumMarksComparator);
            Enrollee[] result = new Enrollee[count];
            for (int i = 0; i < count; i++) {
                result[i] = getEnrollees()[i];
            }
            return result;
        }
    }

    public Enrollee[] filterSemiMarks(int startIndex) {
        Arrays.sort(getEnrollees(), Enrollee.enrolleeSumMarksComparator);
        int semiMark = getEnrollees()[startIndex - 1].getSumMarks();
        int count = 0;
        for (int i = startIndex; i < getEnrollees().length; i++) {
            if (getEnrollees()[i].getSumMarks() == semiMark) {
                count++;
            }
        }

        Enrollee[] result = new Enrollee[count];
        int index = -1;
        for (int i = startIndex; i < getEnrollees().length; i++) {
            if (getEnrollees()[i].getSumMarks() == semiMark) {
                index++;
                result[index] = getEnrollees()[i];
            }
        }

        return result;
    }
}
