package com.depaul.edu.portfoliocraft.service;

import com.depaul.edu.portfoliocraft.model.UserTable;
import com.depaul.edu.portfoliocraft.repository.UserRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Log4j2
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserTable> list() {
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
}
