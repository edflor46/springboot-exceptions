package com.yahikko.springboot.exceptions.springbootexceptions.services;

import java.util.List;

import com.yahikko.springboot.exceptions.springbootexceptions.models.domain.User;

public interface UserService {

    User findById(Long id);

    List<User> findAll();

}
