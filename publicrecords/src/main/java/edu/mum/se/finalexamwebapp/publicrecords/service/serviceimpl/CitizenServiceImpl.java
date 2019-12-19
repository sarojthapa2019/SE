package edu.mum.se.finalexamwebapp.publicrecords.service.serviceimpl;

import edu.mum.se.finalexamwebapp.publicrecords.model.Citizen;
import edu.mum.se.finalexamwebapp.publicrecords.repository.CitizenRepository;
import edu.mum.se.finalexamwebapp.publicrecords.service.CitizenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CitizenServiceImpl implements CitizenService {

    @Autowired
    CitizenRepository citizenRepository;
    @Override
    public Page<Citizen> getAllCitizenPaged(int pageNo) {
        return citizenRepository.findAll(PageRequest.of(pageNo,3, Sort.by("lastName","firstName")));
    }

    @Override
    public void registerCitizen(Citizen citizen) {
        citizenRepository.save(citizen);
    }

    @Override
    public double getTotalIncome() {
        List<Citizen> citizenList = citizenRepository.findAll();
        double totalIncome = 0;
        for(Citizen c: citizenList){
            totalIncome += c.getYearlyIncome();
        }
        return totalIncome;
    }


}
