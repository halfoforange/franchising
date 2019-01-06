package com.s0rInb.service;

import com.s0rInb.configuration.EmailServiceImpl;
import com.s0rInb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.s0rInb.entity.User;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final EmailServiceImpl emailService;

    @Autowired
    public UserService(UserRepository userRepository, EmailServiceImpl emailService) {
        this.userRepository = userRepository;
        this.emailService = emailService;
    }

    public User registerNewUser(User user) throws Exception {
        if (isEmailPresent(user.getEmail())) {
            throw new Exception("User with this email already exists: " + user.getEmail());
        }
        if (isLoginPresent(user.getLogin())) {
            throw new Exception("User with this login already exists: " + user.getEmail());
        }
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        //emailService.sendSimpleMessage(user.getEmail(), "Вы успешно зарегистрировались", "Поздравляем с успешной регистрацией!");
        return userRepository.save(user);
    }

    public User findByEmail(String email) {
        return userRepository.findByEmailIgnoreCase(email);
    }

    private Boolean isEmailPresent(String email) {
        return findByEmail(email) != null;
    }

    private User findByLogin(String login) {
        return userRepository.findByLoginIgnoreCase(login);
    }

    private Boolean isLoginPresent(String login) {
        return findByLogin(login) != null;
    }
}
