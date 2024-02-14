package com.progcourses.progcourses.services;

import com.progcourses.progcourses.repositories.UserRepository;
import com.progcourses.progcourses.repositories.models.Role;
import com.progcourses.progcourses.repositories.models.User;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    public boolean createUser(User user){
        String username=user.getUsername();
        if(userRepository.findByUsername(username)!=null)return false;
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.getRoles().add(Role.ROLE_USER);
        userRepository.save(user);
        return true;
    }
    public List<User> findAll(){
        return userRepository.findAll();
    }
}
