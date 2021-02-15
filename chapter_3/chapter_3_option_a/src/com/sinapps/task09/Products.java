package com.sinapps.task09;

import java.util.Random;

public class Products {
    private final Product[] products;

    private final String[] BRANDS = {
            "DANONE",
            "PEPSODENT",
            "BIMBO",
            "SPRITE",
            "PALMOLIVE",
            "DOWNY",
            "SUNLIGHT",
            "NESTLÉ",
            "LUX",
            "DOVE",
            "KNORR",
            "SUNSILK",
            "INDOMIE",
            "NESCAFÉ",
            "PEPSI",
            "LAY’S",
            "LIFEBUOY",
            "MAGGI",
            "COLGATE",
            "COCA-COLA",
    };

    private final String[] NAMES = {
            "Йогурт",
            "Зубная паста",
            "Хлеб",
            "Газированный безалкогольный напиток",
            "Мыло",
            "Кондиционер для белья",
            "Стиральный порошок",
            "Шоколад",
            "Гель для душа",
            "Приправа",
            "Шампунь",
            "Лапша быстрого приготовления",
            "Кофе",
            "Чипсы"
    };

    private final Random random = new Random();

    public Products(int count) {
        products = generateRandomProductsList(count);
    }

    public Product[] getProducts() {
        return products;
    }

    private Product[] generateRandomProductsList(int length) {
        Product[] result = new Product[length];
        for (int i = 0; i < result.length; i++) {
            result[i] = new Product(i, generateRandomName(), generateRandomUPC(), generateRandomBrand(), generateRandomPrice(),
                    generateRandomBestBefore(), generateRandomCount());
        }
        return result;
    }

    private String generateRandomName() {
        return NAMES[random.nextInt(NAMES.length)];
    }

    private String generateRandomUPC() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 12; i++) {
            result.append(String.valueOf(random.nextInt(10)));
        }
        return result.toString();
    }

    private String generateRandomBrand() {
        return BRANDS[random.nextInt(BRANDS.length)];
    }

    private double generateRandomPrice() {
        return random.nextInt(10) + random.nextDouble();
    }

    private int generateRandomBestBefore() {
        return random.nextInt(5) + 1;
    }

    private int generateRandomCount() {
        return random.nextInt(100) + 1;
    }

    public Product[] filterByName(String name) {
        int count = 0;
        for (Product product : getProducts()) {
            if (product.getName().equals(name)) {
                count++;
            }
        }

        Product[] result = new Product[count];
        int index = -1;
        for (Product product : getProducts()) {
            if (product.getName().equals(name)) {
                index++;
                result[index] = product;
            }
        }

        return result;
    }

    public Product[] filterByNameAndPrice(String name, double price) {
        int count = 0;
        for (Product product : getProducts()) {
            if (product.getName().equals(name) && product.getPrice() <= price) {
                count++;
            }
        }

        Product[] result = new Product[count];
        int index = -1;
        for (Product product : getProducts()) {
            if (product.getName().equals(name) && product.getPrice() <= price) {
                index++;
                result[index] = product;
            }
        }

        return result;
    }

    public Product[] filterByBestBefore(int bestBefore) {
        int count = 0;
        for (Product product : getProducts()) {
            if (product.getBestBefore() > bestBefore) {
                count++;
            }
        }

        Product[] result = new Product[count];
        int index = -1;
        for (Product product : getProducts()) {
            if (product.getBestBefore() > bestBefore) {
                index++;
                result[index] = product;
            }
        }

        return result;
    }
}
