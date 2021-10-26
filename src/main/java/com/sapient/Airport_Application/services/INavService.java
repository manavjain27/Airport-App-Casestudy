package com.sapient.Airport_Application.services;

import com.sapient.Airport_Application.domain.NavAid;

import java.util.List;
import java.util.Optional;

public interface INavService {

    List<NavAid> listAllNavaids();

    List<NavAid> findNavaidByName(String name);

    Optional<NavAid> findNavaidById(Long id);
}
