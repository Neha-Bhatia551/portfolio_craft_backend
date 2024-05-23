package com.depaul.edu.portfoliocraft.repository;

import com.depaul.edu.portfoliocraft.model.UserTable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserTable, Integer> {

}
