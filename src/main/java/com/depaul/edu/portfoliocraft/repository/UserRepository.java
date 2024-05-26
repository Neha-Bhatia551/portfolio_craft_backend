package com.depaul.edu.portfoliocraft.repository;

import com.depaul.edu.portfoliocraft.model.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<UserInfo, Integer> {

    List<UserInfo> findAllByTemplateid(int id);

}
