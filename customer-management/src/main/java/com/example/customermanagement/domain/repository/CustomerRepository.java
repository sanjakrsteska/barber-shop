package com.example.customermanagement.domain.repository;

import com.example.customermanagement.domain.models.Customer;
import com.example.customermanagement.domain.models.Username;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Username> {
}
