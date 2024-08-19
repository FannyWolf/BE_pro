package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCDemo {
    private static final String DRIVER = "org.postgresql.Driver";
    private static final String URL = "jdbc:postgresql://localhost:5432/";
    private static final String DB = "app_43";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "qwerty007";

    public static void loadDriver() {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Load driver failed: " + DRIVER);
        }
    }

    public static Connection getConnection() {
        try {
            Connection connection = DriverManager.getConnection(URL + DB, USERNAME, PASSWORD);
            return connection;
        } catch (SQLException e) {
            throw new RuntimeException("Create connection failed");
        }
    }

    public static List<Book> getBooks() {
        String query = "select * from t_book";

        try (Connection connection = getConnection()) {
            if (connection == null) {
                throw new SQLException("Connection fail");
            }
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            List<Book> result = new ArrayList<Book>();
            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String title = resultSet.getString("title");
                String author = resultSet.getString("author");
                String isbn = resultSet.getString("isbn");

                result.add(new Book(id, title, author, isbn));
            }
            return result;

        } catch (SQLException e) {
              throw new RuntimeException("Get books failed");
        }
    }


}
