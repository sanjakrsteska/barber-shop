package mk.ukim.finki.emt.appointmentmanagement.services.form;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import mk.ukim.finki.emt.sharedkernel.domain.info.Address;
import mk.ukim.finki.emt.sharedkernel.domain.info.PhoneNumber;


@Data
public class CustomerForm {
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    private Address address;
    @NotNull
    private PhoneNumber phoneNumber;

}
