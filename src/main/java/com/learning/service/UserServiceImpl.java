package com.learning.service;

import com.learning.dto.UserDto;
import com.learning.entity.UserEntity;
import com.learning.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;


    @Override
    public void addUser(UserDto userDto) {
        if (Objects.nonNull(userDto)) {
            UserEntity userEntity = new UserEntity();
            BeanUtils.copyProperties(userDto, userEntity);
            userRepository.save(userEntity);
        }
    }

    @Override
    public UserDto getUserById(Long id) {
        UserEntity userEntity = userRepository.findById(id).orElseThrow(() -> new RuntimeException("user not found"));
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(userEntity, userDto);
        return userDto;
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<UserEntity> userEntityList = userRepository.findAll();
        UserDto userDto = new UserDto();
        List<UserDto> userDtoList = userEntityList.stream().map(userEntity -> {
            BeanUtils.copyProperties(userEntity, userDto);
            return userDto;
        }).collect(Collectors.toList());
        return userDtoList;
    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.findById(id);
    }

    public boolean existsByEmailAndPassword(String email, String password) {
        return userRepository.existsByEmailAndPassword(email, password);

    }

}
