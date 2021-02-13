package com.sinapps.task03;

import java.util.Random;

public class Patients {
    private Patient[] patients;

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

    private final String[] DIAGNOSES = {"Ишемическая болезнь сердца", "Цереброваскулярная болезнь",
            "Инфекции нижних дыхательных путей", "СПИД", "Обструктивная болезнь легких",
            "Диарейные заболевания", "Туберкулез"};

    private final Random random = new Random();

    public Patients(int count) {
        patients = generatePatientsList(count);
    }

    private Patient[] generatePatientsList(int length) {
        Patient[] list = new Patient[length];
        for (int i = 0; i < length; i++) {

            list[i] = new Patient(i, generateRandomSurname(), generateRandomName(), generateRandomMiddleName(),
                    generateRandomAddress(), generateRandomPhone(), generateRandomCardId(), generateRandomDiagnosis());
        }
        return list;
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

    private int generateRandomCardId() {
        return random.nextInt(Integer.MAX_VALUE);
    }

    private String generateRandomDiagnosis() {
        return DIAGNOSES[random.nextInt(DIAGNOSES.length)];
    }

    public Patient[] getPatients() {
        return patients;
    }

    public void setPatients(Patient[] patients) {
        this.patients = patients;
    }

    public Patient[] filterByDiagnosis(String diagnosis) {
        int count = 0;
        for (Patient patient : getPatients()) {
            if (patient.getDiagnosis().equals(diagnosis)) {
                count++;
            }
        }

        Patient[] result = new Patient[count];
        int index = -1;
        for (Patient patient : getPatients()) {
            if (patient.getDiagnosis().equals(diagnosis)) {
                index++;
                result[index] = patient;
            }
        }

        return result;
    }

    public Patient[] filterByCardIdInterval(int cardIdStart, int cardIdEnd) {
        int count = 0;
        for (Patient patient : getPatients()) {
            if (patient.getCardId() >= cardIdStart && patient.getCardId() <= cardIdEnd) {
                count++;
            }
        }

        Patient[] result = new Patient[count];
        int index = -1;
        for (Patient patient : getPatients()) {
            if (patient.getCardId() >= cardIdStart && patient.getCardId() <= cardIdEnd) {
                index++;
                result[index] = patient;
            }
        }

        return result;
    }
}
