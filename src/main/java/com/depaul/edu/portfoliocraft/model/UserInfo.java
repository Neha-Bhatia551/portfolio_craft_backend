package com.depaul.edu.portfoliocraft.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "userinfo")
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int templateid;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "role", length = 100)
    private String role;

    @Column(name = "university", length = 100)
    private String university;

    @Column(name = "education")
    private String education;

    @Column(name = "experience")
    private String experience;

    @Column(name = "tech_stack")
    private String techStack;

    @Column(name = "projects")
    private String projects;

    @Column(name = "summary")
    private String summary;

    @Column(name = "email", nullable = false, unique = true, length = 255)
    private String email;

    @Column(name = "phone_number", length = 20)
    private String phoneNumber;

    @Column(name = "linked_in", length = 255)
    private String linkedIn;
}
