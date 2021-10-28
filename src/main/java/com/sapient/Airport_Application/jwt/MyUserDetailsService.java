
package com.sapient.Airport_Application.jwt;

import com.sapient.Airport_Application.dao.UserDao;
import com.sapient.Airport_Application.domain.Registration;
import com.sapient.Airport_Application.exceptions.AirportApplicationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Slf4j
@Component
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        log.info("Loading user details for email {}",email);
        Registration registration = userDao.findById(email).orElseThrow(() -> new AirportApplicationException("No User found for mail " + email, HttpStatus.NOT_FOUND));
        return new User(registration.getEmail(), registration.getPassword(), Collections.singletonList(new SimpleGrantedAuthority("USER_ROLE")));

    }
}

