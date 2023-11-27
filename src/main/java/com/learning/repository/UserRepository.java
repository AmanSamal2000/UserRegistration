package com.learning.repository;

import com.learning.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    UserEntity findByEmail(String email);

    Boolean existsByEmailAndPassword(String email,String password);

}
