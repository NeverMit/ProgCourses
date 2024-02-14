package com.progcourses.progcourses.controllers;

import com.progcourses.progcourses.repositories.models.RegistrationForm;
import com.progcourses.progcourses.repositories.models.User;
import com.progcourses.progcourses.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
public class RegistrationController {
    private final UserService userService;
    @GetMapping("/login")
    public String login() {
        return "login";
    }
    @GetMapping("/register")
    public String registration() {
        return "registration";
    }
    @PostMapping("/register")
    public String createUser(User user, Model model) {
        if (!userService.createUser(user)) {
            model.addAttribute("errorMessage",
                    "Пользователь с email: "
                            + user.getUsername()
                            + " уже существует");
            return "registration";
        }
        return "redirect:/login";
    }
}
