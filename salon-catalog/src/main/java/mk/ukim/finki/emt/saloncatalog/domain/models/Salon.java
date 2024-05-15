package mk.ukim.finki.emt.saloncatalog.domain.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import jakarta.persistence.Entity;
import lombok.Getter;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;
import mk.ukim.finki.emt.sharedkernel.domain.info.Address;
import mk.ukim.finki.emt.sharedkernel.domain.info.PhoneNumber;
@Entity
@Getter
public class Salon extends AbstractEntity<SalonId> {
    private  String name;
    private  PhoneNumber phoneNumber;
    private  Address address;
    protected Salon() {
        super(DomainObjectId.randomId(SalonId.class));

    }
    public static Salon build(String name, PhoneNumber phoneNumber, Address address) {
        Salon s = new Salon();
        s.name = name;
        s.phoneNumber = phoneNumber;
        s.address = address;
        return s;
    }
    public Salon(String name, PhoneNumber phoneNumber, Address address) {
        super(DomainObjectId.randomId(SalonId.class));
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }
}
