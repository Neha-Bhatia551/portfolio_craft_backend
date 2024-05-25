package com.depaul.edu.portfoliocraft.controller;

import com.depaul.edu.portfoliocraft.model.UserInfo;
import com.depaul.edu.portfoliocraft.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/users")
@Tag(name = "users", description = "Get  all user details")
public class UserController {

    @Autowired
    UserService userService;
    @GetMapping("/liststring")
    public ResponseEntity<String> list() {
        try {
            return new ResponseEntity<>("hello neha", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/info")
    public ResponseEntity<List<UserInfo>> getAllUsers() {
        try {
            List<UserInfo> users = new ArrayList<UserInfo>();

            users = userService.list();

            if (users.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(users, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/info/{id}")
    public ResponseEntity<UserInfo> getCandidateById(@PathVariable int id) {
        UserInfo info = userService.getInfoById(id);
        return info != null ? ResponseEntity.ok(info) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<UserInfo> createCandidate(@RequestBody UserInfo info) {
        UserInfo savedCandidate = userService.saveInfo(info);
        return ResponseEntity.ok(savedCandidate);
    }

}
