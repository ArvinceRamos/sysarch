package com.Activity.sysarch.service;

import com.Activity.sysarch.model.User;
import com.Activity.sysarch.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public String signup(String username, String password, String email) {
        if (userRepository.findByUsername(username).isPresent()) {
            return "Username already exists.";
        }

        if (userRepository.findByEmail(email).isPresent()) {
            return "Email already exists.";
        }

        String hashedPassword = bCryptPasswordEncoder.encode(password);
        User newUser = new User(username, hashedPassword, email);
        userRepository.save(newUser);
        return "Signup successful.";
    }

    public String login(String username, String password) {
        Optional<User> userOptional = userRepository.findByUsername(username);
        if (userOptional.isEmpty()) {
            return "Username not found.";
        }

        User user = userOptional.get();
        if (!bCryptPasswordEncoder.matches(password, user.getPassword())) {
            return "Incorrect password.";
        }

        return "Login successful.";
    }
}
