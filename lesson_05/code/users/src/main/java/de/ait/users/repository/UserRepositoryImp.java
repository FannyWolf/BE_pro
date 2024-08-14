package de.ait.users.repository;

import de.ait.users.entity.User;

import java.util.List;

public class UserRepositoryImp implements UserRepository{





    @Override
    public List<User> findAll() {
        return List.of();
    }

    @Override
    public User save(User user) {
        return null;
    }
}
