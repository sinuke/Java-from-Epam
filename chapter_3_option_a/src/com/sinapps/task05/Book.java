package com.sinapps.task05;

public class Book {
    private ISBN id;
    private String title;
    private String[] authors;
    private String publisher;
    private int year;
    private int pages;
    private double price;
    private String cover;

    public Book(ISBN id, String title, String[] authors, String publisher, int year, int pages, double price, String cover) {
        setId(id);
        setTitle(title);
        setAuthors(authors);
        setPublisher(publisher);
        setYear(year);
        setPages(pages);
        setPrice(price);
        setCover(cover);
    }

    public ISBN getId() {
        return id;
    }

    public void setId(ISBN id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String[] getAuthors() {
        return authors;
    }

    public void setAuthors(String[] authors) {
        this.authors = authors;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    @Override
    public String toString() {

        StringBuilder authorsString = new StringBuilder();
        for (int i = 0; i < getAuthors().length; i++) {
            authorsString.append(getAuthors()[i]);
            if (i < getAuthors().length - 1) {
                authorsString.append(", ");
            }
        }

        return authorsString.toString() + ". " + getTitle()  + ". - " +
               getPublisher() + ", " + getYear() + ". - " + getPages() + " c. " + "\tISBN " + getId().toString() +
               "\tСтоимость: " + String.format("%.2f", getPrice())  + " BYN.\tПереплет: " + getCover();
    }

    public boolean containsAuthor(String author) {
        boolean result = false;
        for (String currentAuthor : authors) {
            if (currentAuthor.equals(author)) {
                result = true;
                break;
            }
        }
        return result;
    }
}
