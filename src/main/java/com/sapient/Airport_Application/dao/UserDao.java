package com.sapient.Airport_Application.dao;

import com.sapient.Airport_Application.domain.Registration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<Registration,String> {
}
