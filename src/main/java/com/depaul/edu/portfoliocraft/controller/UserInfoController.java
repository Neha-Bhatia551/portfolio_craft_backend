package com.depaul.edu.portfoliocraft.controller;

import com.depaul.edu.portfoliocraft.model.UserInfo;
import com.depaul.edu.portfoliocraft.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/userinfo")
public class UserInfoController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserInfo> getAllUserInfos() {
        return userService.list();
    }

    @GetMapping("/{id}")
    public UserInfo getUserInfoById(@PathVariable int id) {
        return userService.getInfoById(id);
    }

    @PostMapping
    public UserInfo createUserInfo(@RequestBody UserInfo userInfo) {
        return userService.saveInfo(userInfo);
    }
}
