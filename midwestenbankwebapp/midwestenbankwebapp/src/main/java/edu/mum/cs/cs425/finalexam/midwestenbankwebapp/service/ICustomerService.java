package edu.mum.cs.cs425.finalexam.midwestenbankwebapp.service;

import edu.mum.cs.cs425.finalexam.midwestenbankwebapp.model.Customer;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ICustomerService {
    List<Customer> getAllCustomers();
    Page<Customer> getAllCustomers(int pageNo);
    Customer registerNewCustomer(Customer customer);
}
