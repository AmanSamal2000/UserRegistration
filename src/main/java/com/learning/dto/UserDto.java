package com.learning.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDto {

    private Long id;
    private String name;
    private String email;
    private String course;
    private Long number;
    private String password;
}
