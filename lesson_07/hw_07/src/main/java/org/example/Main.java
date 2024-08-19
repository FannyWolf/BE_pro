package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        JDBCDemo.loadDriver();

        List<Book> books = JDBCDemo.getBooks();
        System.out.println(books);
    }
}