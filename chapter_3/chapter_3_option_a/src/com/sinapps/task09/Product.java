package com.sinapps.task09;

public class Product {
    private int id;
    private String name;
    private String upc;
    private String brand;
    private double price;
    private int bestBefore;
    private int count;

    public Product(int id, String name, String upc, String brand, double price, int bestBefore, int count) {
        this.id = id;
        this.name = name;
        this.upc = upc;
        this.brand = brand;
        this.price = price;
        this.bestBefore = bestBefore;
        this.count = count;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUpc() {
        return upc;
    }

    public void setUpc(String upc) {
        this.upc = upc;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getBestBefore() {
        return bestBefore;
    }

    public void setBestBefore(int bestBefore) {
        this.bestBefore = bestBefore;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return getId() + ".\t" + getName() + "\t" + getBrand() + "\t" + getUpc() + "\t$" + String.format("%.2f", getPrice()) + "\t" +
                getBestBefore() + "\t" + getCount();
    }
}
