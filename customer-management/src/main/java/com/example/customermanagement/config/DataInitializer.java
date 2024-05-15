package com.example.customermanagement.config;

import com.example.customermanagement.domain.models.Customer;
import com.example.customermanagement.domain.repository.CustomerRepository;
import com.example.customermanagement.xport.rest.CustomerResource;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.sharedkernel.domain.info.Address;
import mk.ukim.finki.emt.sharedkernel.domain.info.PhoneNumber;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@AllArgsConstructor
public class DataInitializer {

    private final CustomerRepository customerRepository;

    @PostConstruct
    public void initData() {
        Customer c1 = Customer.build("Dime","Dimsoki",Address.valueOf("Braka Lameski br 13","Skopje","Makedonija")
                ,PhoneNumber.valueOf("078824567")
                );
        Customer c2 = Customer.build("Andrej","Petreski" , Address.valueOf("Aleksandar Makedonski br 167","Prilep","Makedonija")
                ,PhoneNumber.valueOf("072176432")
               );
        if (customerRepository.findAll().isEmpty()) {
            customerRepository.saveAll(Arrays.asList(c1,c2));
        }
    }
}

