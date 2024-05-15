package mk.ukim.finki.emt.appointmentmanagement.domain.models;

import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;
import org.springframework.lang.NonNull;

public class AppointmentId extends DomainObjectId {
    private AppointmentId() {
        super(AppointmentId.randomId(AppointmentId.class).getId());
    }

    public AppointmentId(@NonNull String uuid) {
        super(uuid);
    }

    public static AppointmentId of(String uuid) {
        AppointmentId s = new AppointmentId(uuid);
        return s;
    }
}
