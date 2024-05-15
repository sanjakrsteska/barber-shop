package com.example.customermanagement.xport.rest;

import com.example.customermanagement.domain.models.Customer;
import com.example.customermanagement.domain.models.Username;
import com.example.customermanagement.services.CustomerService;
import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/customer")
@AllArgsConstructor
public class CustomerResource {

    private final CustomerService customerService;

    @GetMapping
    public List<Customer> getAll() {
        return customerService.getAll();
    }
    @GetMapping("/{id}")
    public Optional<Customer> getById(@PathVariable String id) {
        return customerService.findById(Username.of(id));
    }

}
