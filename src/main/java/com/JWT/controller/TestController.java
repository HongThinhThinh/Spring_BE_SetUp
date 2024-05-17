package com.JWT.controller;

import com.JWT.model.entity.User;
import com.JWT.model.response.AuthenticationResponse;
import com.JWT.utils.AccountUtils;
import com.JWT.utils.SendMailUtils;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SecurityRequirement(name ="api")
public class TestController {
    @Autowired
    AccountUtils accountUtils;
    @Autowired
    SendMailUtils sendMail;
    @GetMapping("/currentUser")
    public AuthenticationResponse getCurrentUser(){
        return accountUtils.getCurrentUser();
    }

    @PostMapping("/testSendMail")
    public void testSendMail(){
        sendMail.threadSendMail(new User(),"hello HT","Hi HT");
    }


}
