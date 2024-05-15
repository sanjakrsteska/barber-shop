package com.example.customermanagement.services;

import com.example.customermanagement.domain.models.Customer;
import com.example.customermanagement.domain.models.Username;


import java.util.List;
import java.util.Optional;

public interface CustomerService {
    Optional<Customer> findById(Username id);
    List<Customer> getAll();
}
