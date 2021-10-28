package com.sapient.Airport_Application.services;

import com.sapient.Airport_Application.dao.UserDao;
import com.sapient.Airport_Application.domain.Registration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserDao userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    public void saveUser(Registration signup) {

        signup.setPassword(passwordEncoder.encode(signup.getPassword()));
        userRepository.save(signup);

    }

}
