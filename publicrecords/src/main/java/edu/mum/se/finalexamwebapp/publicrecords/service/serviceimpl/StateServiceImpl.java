package edu.mum.se.finalexamwebapp.publicrecords.service.serviceimpl;

import edu.mum.se.finalexamwebapp.publicrecords.model.State;
import edu.mum.se.finalexamwebapp.publicrecords.repository.StateRepository;
import edu.mum.se.finalexamwebapp.publicrecords.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StateServiceImpl implements StateService {
    @Autowired
    StateRepository stateRepository;
    @Override
    public List<State> getAllState() {
        return stateRepository.findAll();
    }
}
