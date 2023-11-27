package com.learning.controller;

import com.learning.dto.UserDto;
import com.learning.model.request.UserLoginRequestModel;
import com.learning.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@RequiredArgsConstructor
public class UIController {

    private final UserService userService;

    @GetMapping("/signIn")
    public String login() {
        return "login";
    }

    @GetMapping("/signup")
    public String signUp() {
        return "signUp";
    }

    @PostMapping("/verify-login")
    public String verify(@ModelAttribute UserLoginRequestModel userLoginRequestModel, Model model) {
        String email = userLoginRequestModel.getEmail();
        String password = userLoginRequestModel.getPassword();
        if (userService.existsByEmailAndPassword(email, password)) {
            return "welcome";
        }
        return "login";
    }

    @PostMapping("/registers")
    public String userRegistration(@ModelAttribute UserDto userDto, Model model) {
        userService.addUser(userDto);
        return "login";
    }

    @GetMapping("/menu")
    public String menu() {
        return "_menu";
    }

}

