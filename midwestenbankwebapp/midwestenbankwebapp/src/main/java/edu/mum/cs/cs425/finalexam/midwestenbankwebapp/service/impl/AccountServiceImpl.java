package edu.mum.cs.cs425.finalexam.midwestenbankwebapp.service.impl;

import edu.mum.cs.cs425.finalexam.midwestenbankwebapp.model.Account;
import edu.mum.cs.cs425.finalexam.midwestenbankwebapp.repository.IAccountRepository;
import edu.mum.cs.cs425.finalexam.midwestenbankwebapp.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private IAccountRepository accountRepository;

    @Override
    public List<Account> getAllAccounts() {
        return accountRepository.findAll(Sort.by("accountNumber"));
    }

    @Override
    public Account addNewAccount(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Double computeNetLiquidity() {
        Double netLiquidity = 0.0;
        List<Account> accounts = accountRepository.findAll();
        for(Account account : accounts) {
            if(!account.getAccountType().getAccountTypeName().equalsIgnoreCase("loan")) {
                netLiquidity += account.getBalance();
            } else {
                netLiquidity -= account.getBalance();
            }
        }
        return netLiquidity;
    }
}
