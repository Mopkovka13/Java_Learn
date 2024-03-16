package org.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Book {
    @Value("Преступление и наказание")
    private String name;
    @Value("Фёдор Михайлович Достоевский")
    private String author;
    @Value("1966")
    private int year;

    public String getName() {
        return name;
    }
    public String getAuthor() {
        return author;
    }
    public int getYear() {
        return year;
    }
    @Override
    public String toString() {
        return "Book{" + "name='" + name + '\'' + ", author='" + author + '\'' + ", year=" + year + '}';
    }
}
