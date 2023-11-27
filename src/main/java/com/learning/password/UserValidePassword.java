package com.learning.password;

import com.learning.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

import java.util.Scanner;

@Controller
@RequiredArgsConstructor

public class UserValidePassword {

//    private final UserService userPassword;

    // Hardcoded correct password for demonstration purposes
    private static final String CORRECT_PASSWORD = "secret123";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your userEmail: ");
        String username = scanner.nextLine();

        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        if (isPasswordCorrect(password)) {
            System.out.println("Welcome, " + username + "!");
        } else {
            System.out.println("Sorry Wrong password Please try again.");
        }

        scanner.close();
    }

    private static boolean isPasswordCorrect(String enteredPassword) {
        // Compare the entered password with the correct password
        return CORRECT_PASSWORD.equals(enteredPassword);
    }
}

