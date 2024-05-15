package mk.ukim.finki.emt.sharedkernel.domain.info;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NonNull;
import mk.ukim.finki.emt.sharedkernel.domain.base.ValueObject;
@Embeddable
@Getter
public class PhoneNumber implements ValueObject {
private final String phoneNumber;

    protected PhoneNumber() {
        this.phoneNumber = null;
    }
    public static PhoneNumber valueOf(String phoneNumber) {
        return new PhoneNumber(phoneNumber);
    }
    public PhoneNumber (@NonNull String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public PhoneNumber changePhoneNumber(String phoneNumber) {
        return new PhoneNumber(phoneNumber);
    }
}
