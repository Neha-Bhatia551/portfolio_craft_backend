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

    @GetMapping("/template/{id}")
    public List<UserInfo> getUserInfoByTemplateid(@PathVariable int id) {
        return userService.getInfoByTemplateId(id);
    }

    @PostMapping
    public UserInfo createUserInfo(@RequestBody UserInfo userInfo) {
        return userService.saveInfo(userInfo);
    }

    @PostMapping("/template/1")
    public UserInfo createUserInfoT1(@RequestBody UserInfo userInfo) {
        userInfo.setTemplateid(1);
        return userService.saveInfo(userInfo);
    }

    @PostMapping("/template/2")
    public UserInfo createUserInfoT2(@RequestBody UserInfo userInfo) {
        userInfo.setTemplateid(2);
        return userService.saveInfo(userInfo);
    }

    @PostMapping("/template/3")
    public UserInfo createUserInfoT3(@RequestBody UserInfo userInfo) {
        userInfo.setTemplateid(3);
        return userService.saveInfo(userInfo);
    }

}
