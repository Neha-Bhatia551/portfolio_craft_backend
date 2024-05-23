package com.depaul.edu.portfoliocraft;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class PortfoliocraftApplication {
    public static void main(String[] args) {
        SpringApplication.run(PortfoliocraftApplication.class, args);
    }

}
