package com.learning.service;

import com.learning.dto.UserDto;
import com.learning.entity.UserEntity;

import java.util.List;

public interface UserService {

    void addUser(UserDto userDto);

    UserDto getUserById(Long id);

    List<UserDto> getAllUsers();

    void deleteUserById(Long id);

    boolean existsByEmailAndPassword(String email, String password);

}
