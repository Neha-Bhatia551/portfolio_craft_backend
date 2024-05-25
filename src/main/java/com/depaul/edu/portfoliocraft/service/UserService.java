package com.depaul.edu.portfoliocraft.service;

import com.depaul.edu.portfoliocraft.model.UserInfo;
import com.depaul.edu.portfoliocraft.repository.UserRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@Log4j2
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserInfo> list() {
        log.info("Entering the list user method.");
        try {
            var retval = userRepository.findAll();
            log.info("Exiting the list user method successfully with size = " +  retval.size());
            return retval;
        } catch (Exception e) {
            log.error("Exception caught in list user method: " + e.getMessage());
            throw e;
        }
    }

    public UserInfo getInfoById(int id) {
        Optional<UserInfo> info = userRepository.findById(id);
        return info.orElse(null);
    }

    public UserInfo saveInfo(UserInfo info) {
        return userRepository.save(info);
    }
}
