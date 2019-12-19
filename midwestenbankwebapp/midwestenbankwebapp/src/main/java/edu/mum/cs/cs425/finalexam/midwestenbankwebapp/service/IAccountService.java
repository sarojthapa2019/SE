package edu.mum.cs.cs425.finalexam.midwestenbankwebapp.service;

import edu.mum.cs.cs425.finalexam.midwestenbankwebapp.model.Account;

import java.util.List;

public interface IAccountService {

    public List<Account> getAllAccounts();
    public Account addNewAccount(Account account);
    public Double computeNetLiquidity();
}
