package mk.ukim.finki.emt.appointmentmanagement.domain.valueobjects;

import jakarta.persistence.Embeddable;
import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;

@Embeddable
public class CustomerId extends DomainObjectId {
    protected CustomerId() {
        super(CustomerId.randomId(CustomerId.class).getId());
    }

    public CustomerId(String uuid) {
        super(uuid);
    }
}
