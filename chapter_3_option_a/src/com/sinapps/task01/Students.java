package com.sinapps.task01;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class Students {
    private Student[] students;

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
    public static final String[] FACULTIES = {"Физический", "Математический", "Химико-биологический", "Филологический", "Экономический",
            "Факультет иностранных языков", "Факультет физической культуры и спорта"};

    private final Random random = new Random();

    public Students(int count) {
        students = generateStudentsList(count);
    }

    private Date generateRandomBirth() {
        long ms = -946771200000L + (Math.abs(random.nextLong()) % (80L * 365 * 24 * 60 * 60 * 1000));
        return new Date(ms);
    }

    private int generateRandomCourse() {
        return random.nextInt(5) + 1;
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

    private String generateRandomFaculty() {
        return FACULTIES[random.nextInt(FACULTIES.length)];
    }

    private String generateRandomPhone() {
        String phone = "+37529";
        for (int i = 0; i < 7; i++) {
            phone = phone + random.nextInt(10);
        }
        return phone;
    }

    private String generateRandomGroup(String faculty, int course) {
        String group = String.valueOf(faculty.charAt(0));
        group = group + course + (random.nextInt(8) + 1);
        return group;
    }

    private Student[] generateStudentsList(int length) {
        Student[] list = new Student[length];
        for (int i = 0; i < length; i++) {
            int course = generateRandomCourse();
            String faculty = generateRandomFaculty();

            list[i] = new Student(i, generateRandomSurname(), generateRandomName(), generateRandomMiddleName(),
                    generateRandomBirth(), generateRandomAddress(), generateRandomPhone(), faculty, course,
                    generateRandomGroup(faculty, course));
        }

        return list;
    }

    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }

    public Student[] filterByFaculty(String faculty) {
        int count = 0;
        for (Student student : getStudents()) {
            if (student.getFaculty().equals(faculty)) {
                count++;
            }
        }

        Student[] result = new Student[count];
        int index = -1;
        for (Student student : getStudents()) {
            if (student.getFaculty().equals(faculty)) {
                index++;
                result[index] = student;
            }
        }

        return result;
    }

    public Student[] filterByBirthYear(int year) {
        int count = 0;
        Calendar calendar = Calendar.getInstance();
        for (Student student : getStudents()) {
            calendar.setTime(student.getBirth());

            if (calendar.get(Calendar.YEAR) >= year) {
                count++;
            }
        }

        Student[] result = new Student[count];
        int index = -1;

        for (Student student : getStudents()) {
            calendar.setTime(student.getBirth());

            if (calendar.get(Calendar.YEAR) > year) {
                index++;
                result[index] = student;
            }
        }

        return result;
    }

    public Student[] filterByCourse(int course) {
        int count = 0;
        for (Student student : getStudents()) {
            if (student.getCourse() == course) {
                count++;
            }
        }

        Student[] result = new Student[count];
        int index = -1;
        for (Student student : getStudents()) {
            if (student.getCourse() == course) {
                index++;
                result[index] = student;
            }
        }

        return result;
    }

    public Student[] filterByGroup(String group) {
        int count = 0;
        for (Student student : getStudents()) {
            if (student.getGroup().equals(group)) {
                count++;
            }
        }

        Student[] result = new Student[count];
        int index = -1;
        for (Student student : getStudents()) {
            if (student.getGroup().equals(group)) {
                index++;
                result[index] = student;
            }
        }

        return result;
    }
}
