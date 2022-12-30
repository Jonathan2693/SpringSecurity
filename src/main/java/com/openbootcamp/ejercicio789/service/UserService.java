package com.openbootcamp.ejercicio789.service;


import com.openbootcamp.ejercicio789.entities.User;
import com.openbootcamp.ejercicio789.dto.UserDto;

import java.util.List;

public interface UserService {
    User save(UserDto user);
    List<User> findAll();
    User findOne(String username);
}
