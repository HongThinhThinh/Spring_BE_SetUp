package com.JWT.utils;

import com.JWT.model.entity.User;
import com.JWT.model.response.AuthenticationResponse;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class AccountUtils {
    public AuthenticationResponse getCurrentUser(){
        User user=  (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String token = (String) SecurityContextHolder.getContext().getAuthentication().getCredentials();
        return AuthenticationResponse.builder()
                .role(user.getRole())
                .username(user.getUsername())
                .lastname(user.getLastName())
                .token(token)
                .firstname(user.getFirstName()).build();
        }
}
