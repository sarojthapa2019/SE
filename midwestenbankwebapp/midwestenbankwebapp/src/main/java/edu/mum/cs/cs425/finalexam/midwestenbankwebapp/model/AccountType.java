package edu.mum.cs.cs425.finalexam.midwestenbankwebapp.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="ACCOUNTTYPES")
public class AccountType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "accounttypeid")
    private Integer accountTypeId;

    @NotNull
    @NotBlank
    @Column(name = "accounttypename", unique = true)
    private String accountTypeName;

    public AccountType() {
    }

    public AccountType(Integer accountTypeId, String accountTypeName) {
        this.accountTypeId = accountTypeId;
        this.accountTypeName = accountTypeName;
    }

    public Integer getAccountTypeId() {
        return accountTypeId;
    }

    public void setAccountTypeId(Integer accountTypeId) {
        this.accountTypeId = accountTypeId;
    }

    public String getAccountTypeName() {
        return accountTypeName;
    }

    public void setAccountTypeName(String accountTypeName) {
        this.accountTypeName = accountTypeName;
    }
}
