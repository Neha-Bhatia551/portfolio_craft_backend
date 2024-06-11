package com.depaul.edu.portfoliocraft.service;

import com.depaul.edu.portfoliocraft.model.SignupInfo;
import com.depaul.edu.portfoliocraft.repository.SignupInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private SignupInfoRepository signupInfoRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SignupInfo signupInfo = signupInfoRepository.findByUsername(username);
        if (signupInfo == null) {
            throw new UsernameNotFoundException("User not found: " + username);
        }
        return User.withUsername(signupInfo.getUsername())
                   .password(signupInfo.getPassword())
                   .authorities("USER") // You can set roles/authorities here
                   .build();
    }
}
