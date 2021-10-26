package com.sapient.Airport_Application.dao;

import java.util.List;
import java.util.Optional;

public interface IDAO<T> {

    List<T> findAll();

    Optional<T> findById(Long id);
}
