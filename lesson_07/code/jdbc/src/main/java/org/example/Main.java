package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        JDBCDemo.loadDriver();

        List<User> users = JDBCDemo.getAll();
        System.out.println(users);

        User u1 = new User("Georg_1", "georg@mail.com", "tzzuijj");
        User createdUser = JDBCDemo.create(u1);

        users = JDBCDemo.getAll();
        System.out.println(users);

        createdUser.setName("Vika_2");
        createdUser.setEmail("vika@mail.com");

        System.out.println();
        System.out.println("-------------------------- UPDATE--------------------------------");
        System.out.println();

        JDBCDemo.update(createdUser);
        users = JDBCDemo.getAll();
        System.out.println(users);

        System.out.println();
        System.out.println("-------------------------- UPDATE--------------------------------");
        System.out.println();

        users = JDBCDemo.getAll();
        User user = users.get(0);
        user.setEmail("123333@mail.com");
        JDBCDemo.update(user);

        users = JDBCDemo.getAll();
        System.out.println(users);

        User user3 = JDBCDemo.findById(3L);
        System.out.println(user3);
    }
}