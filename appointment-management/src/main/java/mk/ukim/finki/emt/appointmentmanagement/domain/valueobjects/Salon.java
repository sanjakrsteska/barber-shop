package mk.ukim.finki.emt.appointmentmanagement.domain.valueobjects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Value;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.emt.sharedkernel.domain.base.ValueObject;
import mk.ukim.finki.emt.sharedkernel.domain.info.Address;
import mk.ukim.finki.emt.sharedkernel.domain.info.PhoneNumber;

@Getter
public class Salon implements ValueObject {
    private final SalonId id;
    private final String name;
    private final PhoneNumber phoneNumber;
    private final Address address;

    private Salon() {
        this.id=SalonId.randomId(SalonId.class);
        this.name= "";
        this.phoneNumber = PhoneNumber.valueOf("");
        this.address = Address.valueOf("","","");
    }

    @JsonCreator
    public Salon(@JsonProperty("id") SalonId id,
                   @JsonProperty("salonName") String name,
                   @JsonProperty("phoneNumber") PhoneNumber phoneNumber,
                   @JsonProperty("address") Address address) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }
    public static Salon newSalon(String name,PhoneNumber phoneNumber, Address address) {
        Salon p = new Salon(SalonId.randomId(SalonId.class), name, phoneNumber, address);
        return p;
    }
}
