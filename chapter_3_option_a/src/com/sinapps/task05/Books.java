package com.sinapps.task05;

import java.util.Random;

public class Books {
    private final Book[] books;

    private final String[] titles = {
            "Дневник Анны Франк",
            "Думай и богатей",
            "Унесенные ветром",
            "Сумерки. Сага",
            "Код да Винчи",
            "Алхимик",
            "Властелин колец",
            "Гарри Поттер",
            "Цитаты Мао Цзэдун",
            "Хитроумный идальго Дон Кихот Ламанчский",
            "Лолита",
            "Десять негритят",
            "Над пропастью во ржи",
            "Энн из Зеленых крыш",
            "Повесть о двух городах",
            "Алиса в стране чудес",
            "Она",
            "Сон в красном тереме"};

    private final String[] authors = {
            "Цао Сюэцинь",
            "Генри Райдер Хаггард",
            "Льюис Кэрролл",
            "Чарльз Диккенс",
            "Люси Мод Монтгомери",
            "Джером Дэвид Сэлинджер",
            "Агата Кристи",
            "Владимир Набоков",
            "Мигель де Сервантес",
            "Мао Цзэдун",
            "Джоан Роулинг",
            "Дж. Р. Р. Толкин",
            "Пауло Коэльо",
            "Дэн Браун",
            "Стефани Майер",
            "Маргарет Митчелл",
            "Наполеон Хилл",
            "Анна Франк"};

    private final String[] covers = {
            "Твердый переплет — 7",
            "Твердый переплет — 7БЦ",
            "Твердый переплет — 7Б",
            "Твердый переплет — 7Т",
            "Мягкий переплет (КБС)",
            "Мягкий переплет (ШКС)",
            "Интегральный переплет",
            "Переплет на металлическую пружину",
            "Брошюровка металлической скобой",
            "Крепление на болтах"};

    private final String[] publishers = {
            "Pearson",
            "Reed Elsevier",
            "ThomsonReuters",
            "Wolters Kluwer",
            "Hachette Livre",
            "Grupo Planeta",
            "McGraw–Hill Education",
            "Random House",
            "Holtzbrinck",
            "Scholastic"};

    private final Random random = new Random();

    public Books(int count) {
        books = generateBooksList(count);
    }

    public Book[] getBooks() {
        return books;
    }

    private Book[] generateBooksList(int length) {
        Book[] result;
        result = new Book[length];
        for (int i = 0; i < length; i++) {
            result[i] = new Book(generateRandomId(), generateRandomTitle(), generateRandomAuthors(), generateRandomPublisher(),
                    generateRandomYear(), generateRandomPages(), generateRandomPrice(), generateRandomCover());
        }
        return result;
    }

    private String generateRandomAuthor() {
        return authors[random.nextInt(authors.length)];
    }

    private String[] generateRandomAuthors() {
        int count = (random.nextInt(3) + 1);
        String[] result = new String[count];
        for (int i = 0; i < count; i++) {
            result[i] = generateRandomAuthor();
        }
        return result;
    }

    private String generateRandomTitle() {
        return titles[random.nextInt(titles.length)];
    }

    private ISBN generateRandomId() {
        return new ISBN(random.nextInt(90) + 10, random.nextInt(900_000) + 100_000);
    }

    private String generateRandomPublisher() {
        return publishers[random.nextInt(publishers.length)];
    }

    private int generateRandomYear() {
        return (1900 + random.nextInt(122));
    }

    private int generateRandomPages() {
        return (100 + random.nextInt(450));
    }

    private double generateRandomPrice() {
        return random.nextDouble() * 100 + 5.0D;
    }

    private String generateRandomCover() {
        return covers[random.nextInt(covers.length)];
    }

    public Book[] filterByAuthor(String author) {
        int count = 0;
        for (Book book : books) {
            if (book.containsAuthor(author)) {
                count++;
            }
        }

        Book[] result = new Book[count];
        int index = -1;
        for (Book book : books) {
            if (book.containsAuthor(author)) {
                index++;
                result[index] = book;
            }
        }
        return result;
    }

    public Book[] filterByPublisher(String publisher) {
        int count = 0;
        for (Book book : books) {
            if (book.getPublisher().equals(publisher)) {
                count++;
            }
        }

        Book[] result = new Book[count];
        int index = -1;
        for (Book book : books) {
            if (book.getPublisher().equals(publisher)) {
                index++;
                result[index] = book;
            }
        }
        return result;
    }

    public Book[] filterByYear(int year) {
        int count = 0;
        for (Book book : books) {
            if (book.getYear() > year) {
                count++;
            }
        }

        Book[] result = new Book[count];
        int index = -1;
        for (Book book : books) {
            if (book.getYear() > year) {
                index++;
                result[index] = book;
            }
        }
        return result;
    }
}
