package com.example.customermanagement.services.impl;

import com.example.customermanagement.domain.models.Customer;
import com.example.customermanagement.domain.models.Username;
import com.example.customermanagement.domain.repository.CustomerRepository;
import com.example.customermanagement.services.CustomerService;
import jakarta.validation.Validator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final Validator validator;
    public CustomerServiceImpl(CustomerRepository customerRepository, Validator validator) {
        this.customerRepository = customerRepository;
        this.validator = validator;
    }

    @Override
    public Optional<Customer> findById(Username id) {
       return customerRepository.findById(id);
    }

    @Override
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }


}
