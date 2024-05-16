package com.JWT.controller;

import com.JWT.model.entity.User;
import com.JWT.model.response.AuthenticationResponse;
import com.JWT.utils.AccountUtils;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SecurityRequirement(name ="api")
public class TestController {
    @Autowired
    AccountUtils accountUtils;
    @GetMapping("/currentUser")
    public AuthenticationResponse getCurrentUser(){
        return accountUtils.getCurrentUser();
    }
}
