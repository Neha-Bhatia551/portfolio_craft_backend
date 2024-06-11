package com.depaul.edu.portfoliocraft.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

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

    @ElementCollection
    @CollectionTable(name = "experience_list", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "experience")
    private List<String> experiences;

    @Column(name = "tech_stack")
    private String techStack;

    @ElementCollection
    @CollectionTable(name = "project_list", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "project")
    private List<String> projects;

    @Column(name = "summary")
    private String summary;

    @Column(name = "gpa")
    private String gpa;

    @Column(name = "email", nullable = false, unique = true, length = 255)
    private String email;

    @Column(name = "phone_number", length = 20)
    private String phoneNumber;

    @Column(name = "linked_in", length = 255)
    private String linkedIn;
}
