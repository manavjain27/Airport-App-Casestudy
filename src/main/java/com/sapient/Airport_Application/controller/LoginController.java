package com.sapient.Airport_Application.controller;

import com.sapient.Airport_Application.jwt.AuthenticationRequest;
import com.sapient.Airport_Application.jwt.AuthenticationResponse;
import com.sapient.Airport_Application.jwt.JwtUtil;
import com.sapient.Airport_Application.jwt.MyUserDetailsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Validated
@Slf4j
@RestController
public class LoginController {


    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private MyUserDetailsService userDetailsService;

    @Autowired
    private JwtUtil jwtToken;

    @PostMapping("/api/token")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest)
            throws Exception {

        // authenticating user credentials
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    authenticationRequest.getUsername(), authenticationRequest.getPassword()));
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }

        // if user has been successfully authenticated, generate token.

        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());

        final String jwt = jwtToken.generateToken(userDetails);


        log.info("JWT Generated Successfully: {} ",jwt);
        // send token in response.
        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }

}
