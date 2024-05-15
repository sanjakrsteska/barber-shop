package mk.ukim.finki.emt.appointmentmanagement.domain.valueobjects;

import jakarta.persistence.Embeddable;
import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;
@Embeddable
public class SalonId extends DomainObjectId {
    protected SalonId() {
        super(SalonId.randomId(SalonId.class).getId());
    }

    public SalonId(String uuid) {
        super(uuid);
    }
}
