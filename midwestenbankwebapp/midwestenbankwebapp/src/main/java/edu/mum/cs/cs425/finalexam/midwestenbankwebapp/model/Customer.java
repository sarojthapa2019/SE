package edu.mum.cs.cs425.finalexam.midwestenbankwebapp.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="CUSTOMERS")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;

    @NotNull(message = "* Customer Number is required")
    @Digits(integer = 9, fraction = 0, message = "* Customer number must be numeric; and a positive, integral value")
    @Column(name = "customernumber", nullable = false, unique = true)
    private Long customerNumber;

    @NotNull(message = "* First Name is required")
    @NotBlank(message = "* First Name cannot be empty or blank space(s)")
    private String firstName;

    private String middleName;

    @NotNull(message = "* Last Name is required")
    @NotBlank(message = "* Last Name cannot be empty or blank space(s)")
    private String lastName;

    @NotNull(message = "* Email Address is required")
    @NotBlank(message = "* Email Address cannot be empty or blank space(s)")
    private String emailAddress;

    private String contactPhoneNumber;

    @NotNull(message = "* Date of birth is required")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Account> accounts = new ArrayList<>();

    public Customer() {
    }

    public Customer(Long customerId, Long customerNumber, String firstName, String middleName, String lastName, String emailAddress, String contactPhoneNumber, LocalDate dateOfBirth, List<Account> accounts) {
        this.customerId = customerId;
        this.customerNumber = customerNumber;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.contactPhoneNumber = contactPhoneNumber;
        this.dateOfBirth = dateOfBirth;
        this.accounts = accounts;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(Long customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getContactPhoneNumber() {
        return contactPhoneNumber;
    }

    public void setContactPhoneNumber(String contactPhoneNumber) {
        this.contactPhoneNumber = contactPhoneNumber;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }
}
