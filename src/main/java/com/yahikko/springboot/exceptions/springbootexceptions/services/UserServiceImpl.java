package com.yahikko.springboot.exceptions.springbootexceptions.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.yahikko.springboot.exceptions.springbootexceptions.models.domain.Role;
import com.yahikko.springboot.exceptions.springbootexceptions.models.domain.User;

@Service
public class UserServiceImpl implements UserService {

    private List<User> users;

    public UserServiceImpl() {
        this.users = new ArrayList<>();

        users.add(new User(1L, "Luis", "Ramirez",new Role()));
        users.add(new User(2L, "Eduardo", "Flores", new Role()));
        users.add(new User(3L, "Glouw", "Bell",new Role()));
        users.add(new User(4L, "Risk", "Some", new Role()));
    }

    @Override
    public User findById(Long id) {
        return users.stream().filter(user -> user.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public List<User> findAll() {
        return users;
    }

}
