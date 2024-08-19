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

    public static List<User> getAll() {
        String query = "select * from t_user";

        try (Connection connection = getConnection()) {  //try-with-resourses
            if (connection == null) {
                throw new SQLException("Get connection failed");
            }
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            List<User> result = new ArrayList<User>();
            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");

                result.add(new User(id, name, email, password));
            }
            return result;

        } catch (SQLException e) {
            throw new RuntimeException("Read data failed");
        }
    }


    public static User create(User user) {
        String query = "INSERT INTO t_user (name, email, password) VALUES (?, ?, ?)";

        try (Connection connection = getConnection()) {
            if (connection == null) {
                throw new SQLException("Get connection failed");
            }
            PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, user.getName());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getPassword());

            int affectedRows = statement.executeUpdate();
            if (affectedRows != 1) {
                throw new SQLException("Create user failed: " + user);
            }
            ResultSet resultSet = statement.getGeneratedKeys();
            if (!resultSet.next()) {
                throw new SQLException("Get new user id failed: ");
            } else {
                Long id = resultSet.getLong(1);
                user.setId(id);
                return user;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static User update(User user) {
        String query = "update t_user set name = ?, email = ?, password = ? where id = ?";

        try (Connection connection = getConnection()) {

            if (connection == null) {
                throw new SQLException("Get connection failed");
            }

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, user.getName());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getPassword());
            statement.setLong(4, user.getId());

            int affectedRows = statement.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Update user with id " + user.getId() + " failed: ");
            }
            if (affectedRows > 1) {
                throw new SQLException("Error! Updated " + affectedRows + " users. Duplicate keys in DB");
            }
            return user;

        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static User findById(Long id) {

        String query = "select * from t_user where id = ?";

        try (Connection connection = getConnection()) {
            if (connection == null) {
                throw new SQLException("Get connection failed");
            }
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setLong(1, id);

            ResultSet resultSet = statement.executeQuery();
            if (!resultSet.next()) {
                return null;
            } else {
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");

                return new User(id, name, email, password);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static User save(User user) {
        if (user.getId() == null) {
            return update(user);
        } else {
            return create(user);
        }
    }

}
