package com.example.customermanagement.domain.models;

import jakarta.persistence.Entity;
import lombok.CustomLog;
import lombok.Getter;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;
import mk.ukim.finki.emt.sharedkernel.domain.info.Address;
import mk.ukim.finki.emt.sharedkernel.domain.info.PhoneNumber;
@Entity
@Getter
public class Customer extends AbstractEntity<Username> {

    private String firstName;
    private String lastName;
    private Address address;
    private PhoneNumber phoneNumber;

    public Customer(String firstName, String lastName, Address address, PhoneNumber phoneNumber) {
        super(DomainObjectId.randomId(Username.class));
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }
    public static Customer build(String firstName, String lastName, Address address, PhoneNumber phoneNumber) {
        Customer s = new Customer();
        s.firstName = firstName;
        s.lastName = lastName;
        s.phoneNumber = phoneNumber;
        s.address = address;
        return s;
    }
    public Customer() {
        super(DomainObjectId.randomId(Username.class));
    }
}
