package com.sapient.Airport_Application.services;

import com.sapient.Airport_Application.domain.NavAid;

import java.util.List;

public interface INavService {

    List<NavAid> listAllNavaids();

    List<NavAid> findNavaidByName(String name);

    NavAid findNavaidById(Long id);
}
