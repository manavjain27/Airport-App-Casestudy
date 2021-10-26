package com.sapient.Airport_Application.dao;

import com.sapient.Airport_Application.domain.NavAid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface INavAidsDAO extends JpaRepository<NavAid,Long> {


    List<NavAid> findByName(String name);
}
