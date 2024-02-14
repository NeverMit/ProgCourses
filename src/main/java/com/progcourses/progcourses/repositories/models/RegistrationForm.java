package com.progcourses.progcourses.repositories.models;

import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;

@Data
public class RegistrationForm {
    private String username;
    private String password;
    private String fullName;
    private String phoneNumber;
    public User toUser(PasswordEncoder passwordEncoder){
        return new User(
                username,
                passwordEncoder.encode(password),
                fullName,
                phoneNumber
        );
    }
}
