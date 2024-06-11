package com.depaul.edu.portfoliocraft.service;

import com.depaul.edu.portfoliocraft.model.SignupInfo;
import com.depaul.edu.portfoliocraft.model.User;
import com.depaul.edu.portfoliocraft.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class SignupService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public SignupInfo registerUser(SignupInfo signupInfo) {
        User user = new User();
        user.setUsername(signupInfo.getUsername());
        user.setPassword(bCryptPasswordEncoder.encode(signupInfo.getPassword()));
        userRepository.save(user);
        return signupInfo;
    }
}
