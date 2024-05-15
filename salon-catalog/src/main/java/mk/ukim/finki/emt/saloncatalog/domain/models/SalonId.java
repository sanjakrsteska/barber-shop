package mk.ukim.finki.emt.saloncatalog.domain.models;

import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;
import org.springframework.lang.NonNull;

public class SalonId extends DomainObjectId {
    private SalonId() {
        super(SalonId.randomId(SalonId.class).getId());
    }

    public SalonId(@NonNull String uuid) {
        super(uuid);
    }

    public static SalonId of(String uuid) {
        SalonId s = new SalonId(uuid);
        return s;
    }
}
