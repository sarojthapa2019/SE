package edu.mum.cs.cs425.finalexam.midwestenbankwebapp.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="ACCOUNTS")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountId;

    @NotNull(message = "* Account Number is required")
    @Digits(integer = 9, fraction = 0, message = "* Account number must be numeric; and a positive, integral value")
    @Column(name = "accountnumber", nullable = false, unique = true)
    private Long accountNumber;

    @NotNull(message = "* Balance amount is required")
    @Digits(integer = 9, fraction = 2, message = "* Balance must be a numeric/monetary amount in decimal (money) format such as 'x,xxx.xx'")
    @NumberFormat(pattern = "#,###.##")
    private Double balance;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customerId", nullable = false)
    @NotNull(message = "* Customer is required")
    private Customer customer;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "accountTypeId", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private AccountType accountType;

    public Account() {
    }

    public Account(Long accountId, Long accountNumber, Double balance, Customer customer, AccountType accountType) {
        this.accountId = accountId;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.customer = customer;
        this.accountType = accountType;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }
}
