package com.JWT.controller;


import com.JWT.model.response.AuthenticationResponse;
import com.JWT.model.request.AuthenticationRequest;
import com.JWT.model.request.LoginRequestDTO;
import com.JWT.service.AuthenticationService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SecurityRequirement(name ="api")
public class AuthenticationController {
    @Autowired
    AuthenticationService authenticationService;


    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody AuthenticationRequest user){
        return ResponseEntity.ok(authenticationService.register(user));
    }

    @PostMapping("/login")
    public  ResponseEntity<AuthenticationResponse> login(@RequestBody LoginRequestDTO loginRequestDTO){
        return ResponseEntity.ok(authenticationService.authenticate(loginRequestDTO));
    }

    @GetMapping("/testRole")
    public ResponseEntity testRole(){
        return ResponseEntity.ok("Test Role User Successfully");
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/admin-only")
    public ResponseEntity admin(){
        return ResponseEntity.ok("Admin Only");
    }




}
