package com.sapient.Airport_Application.controller;

import com.sapient.Airport_Application.domain.Login;
import com.sapient.Airport_Application.domain.Registration;
import com.sapient.Airport_Application.jwt.JwtUtil;
import com.sapient.Airport_Application.jwt.MyUserDetailsService;
import com.sapient.Airport_Application.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Validated
@Slf4j
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private MyUserDetailsService userDetailsService;

    @Autowired
    private JwtUtil jwtToken;

    @PostMapping("/api/register")
    public ResponseEntity<String> register(@RequestBody @Valid Registration registration){
        userService.saveUser(registration);
        return new ResponseEntity<>("User registration successful", HttpStatus.OK);
    }

    @PostMapping("/api/token")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody Login login)
            throws Exception {

        log.info("Login request received for email {}",login.getEmail());
        // authenticating user credentials
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    login.getEmail(), login.getPassword()));
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }

        // if user has been successfully authenticated, generate token.

        final UserDetails userDetails = userDetailsService.loadUserByUsername(login.getEmail());

        final String jwt = jwtToken.generateToken(userDetails);


        log.info("JWT Generated Successfully: {} ",jwt);
        // send token in response.
        return new ResponseEntity<>(jwt,HttpStatus.OK);
    }

}


