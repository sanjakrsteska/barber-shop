package mk.ukim.finki.emt.sharedkernel.domain.info;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NonNull;
import mk.ukim.finki.emt.sharedkernel.domain.base.ValueObject;
import org.springframework.cglib.transform.impl.AddDelegateTransformer;

@Embeddable
@Getter
public class Address implements ValueObject {
private final String address;
private final String country;
private final String city;
protected Address() {
    this.address = null;
    this.city = null;
    this.country = null;
}
    public static Address valueOf(String address,String city, String country) {
        return new Address(address,city,country);
    }

    public Address(@NonNull String address, @NonNull String city, @NonNull String country) {
        this.address = address;
        this.country = country;
        this.city = city;
    }
    public Address changeAddress(String address,String city,String country)
    {
        return new Address(address,city,country);
    }
}
