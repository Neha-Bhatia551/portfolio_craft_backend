package com.depaul.edu.portfoliocraft.repository;

import com.depaul.edu.portfoliocraft.model.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserInfo, Integer> {

}
