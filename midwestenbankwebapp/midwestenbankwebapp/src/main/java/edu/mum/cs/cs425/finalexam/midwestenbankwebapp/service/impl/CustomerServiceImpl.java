package edu.mum.cs.cs425.finalexam.midwestenbankwebapp.service.impl;

import edu.mum.cs.cs425.finalexam.midwestenbankwebapp.model.Customer;
import edu.mum.cs.cs425.finalexam.midwestenbankwebapp.repository.ICustomerRepository;
import edu.mum.cs.cs425.finalexam.midwestenbankwebapp.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll(Sort.by("lastName"));
    }

    @Override
    public Page<Customer> getAllCustomers(int pageNo) {
        return customerRepository.findAll(PageRequest.of(pageNo, 6, Sort.by("lastName")));
    }

    @Override
    public Customer registerNewCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

}
