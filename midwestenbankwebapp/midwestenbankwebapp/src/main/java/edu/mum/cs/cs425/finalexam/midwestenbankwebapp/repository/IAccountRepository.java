package edu.mum.cs.cs425.finalexam.midwestenbankwebapp.repository;

import edu.mum.cs.cs425.finalexam.midwestenbankwebapp.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAccountRepository extends JpaRepository<Account, Long> {
}
