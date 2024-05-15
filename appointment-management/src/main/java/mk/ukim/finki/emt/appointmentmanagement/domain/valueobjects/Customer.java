package mk.ukim.finki.emt.appointmentmanagement.domain.valueobjects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;
import mk.ukim.finki.emt.sharedkernel.domain.base.ValueObject;
import mk.ukim.finki.emt.sharedkernel.domain.info.Address;
import mk.ukim.finki.emt.sharedkernel.domain.info.PhoneNumber;

@Getter
public class Customer implements ValueObject {
    private final CustomerId id;
    private final String firstName;
    private final String lastName;
    private final Address address;
    private final PhoneNumber phoneNumber;


    private Customer() {
        this.id=CustomerId.randomId(CustomerId.class);
        this.firstName= "";
        this.lastName= "";
        this.phoneNumber = PhoneNumber.valueOf("");
        this.address = Address.valueOf("","","");
    }
    @JsonCreator
    public Customer(@JsonProperty("id") CustomerId id, @JsonProperty("firstName") String firstName,
                    @JsonProperty("lastName") String lastName, @JsonProperty("address") Address address,
                    @JsonProperty("phoneNumber") PhoneNumber phoneNumber) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public static Customer newCustomer(String firstName,String lastName, Address address,PhoneNumber phoneNumber) {
        Customer c =  new Customer(CustomerId.randomId(CustomerId.class), firstName,lastName,address,phoneNumber);
        return c;
    }
}
