package com.learning.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.learning.dto.UserDto;
import com.learning.entity.UserEntity;
import com.learning.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

//    @GetMapping("/from")
//    public String home(){
//        return "signup";
//    }
//
//    @PostMapping("/register")
//    public String register(@ModelAttribute UserEntity userEntity, HttpSession session){
//        System.out.println(userEntity);
//        userService.save(userEntity);
//        session.setAttribute("message", "User Register Sucessfully..");
//        return "redirect";
//    }



    @PostMapping
    void addUser(@RequestBody UserDto userDto) {
        userService.addUser(userDto);
    }

    @GetMapping
    UserDto getUserById(@RequestParam Long id) {
        return userService.getUserById(id);
    }

    @GetMapping("/all-user")
    List<UserDto> getAllUsers() {
        return userService.getAllUsers();
    }

    @DeleteMapping
    void deleteUserById(@RequestParam Long id) {
        userService.deleteUserById(id);
    }

}
