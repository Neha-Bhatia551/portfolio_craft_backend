package com.depaul.edu.portfoliocraft.repository;

import com.depaul.edu.portfoliocraft.model.SignupInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SignupInfoRepository extends JpaRepository<SignupInfo, Integer> {
    SignupInfo findByUsername(String username);
    SignupInfo findByEmail(String email);
}
