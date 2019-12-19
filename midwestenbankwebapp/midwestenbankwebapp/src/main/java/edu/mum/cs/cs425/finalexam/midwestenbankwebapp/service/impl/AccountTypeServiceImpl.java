package edu.mum.cs.cs425.finalexam.midwestenbankwebapp.service.impl;

import edu.mum.cs.cs425.finalexam.midwestenbankwebapp.model.AccountType;
import edu.mum.cs.cs425.finalexam.midwestenbankwebapp.repository.IAccountTypeRepository;
import edu.mum.cs.cs425.finalexam.midwestenbankwebapp.service.IAccountTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountTypeServiceImpl implements IAccountTypeService {

    @Autowired
    private IAccountTypeRepository accountTypeRepository;

    @Override
    public List<AccountType> getAllAccountTypes() {
        return accountTypeRepository.findAll(Sort.by("accountTypeName"));
    }

}
