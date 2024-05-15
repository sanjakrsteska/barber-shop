package mk.ukim.finki.emt.appointmentmanagement.services.form;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import mk.ukim.finki.emt.sharedkernel.domain.info.Address;
import mk.ukim.finki.emt.sharedkernel.domain.info.PhoneNumber;


@Data
public class SalonForm {
    @NotNull
    private  String name;
   @NotNull
    private  PhoneNumber phoneNumber;
    @NotNull
   private  Address address;

}
