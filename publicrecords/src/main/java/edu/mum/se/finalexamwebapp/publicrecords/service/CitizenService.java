package edu.mum.se.finalexamwebapp.publicrecords.service;


import edu.mum.se.finalexamwebapp.publicrecords.model.Citizen;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CitizenService {
    Page<Citizen> getAllCitizenPaged(int pageNo);
    void registerCitizen(Citizen citizen);
    double getTotalIncome();
}
