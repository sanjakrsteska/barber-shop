package mk.ukim.finki.emt.appointmentmanagement.domain.models;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NonNull;
import mk.ukim.finki.emt.appointmentmanagement.domain.valueobjects.CustomerId;
import mk.ukim.finki.emt.appointmentmanagement.domain.valueobjects.SalonId;
import mk.ukim.finki.emt.appointmentmanagement.domain.valueobjects.Treatment;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;

import java.time.LocalDateTime;

@Entity
@Getter
public class Appointment extends AbstractEntity<AppointmentId> {
    private LocalDateTime dateFrom;
    private LocalDateTime dateTo;
    private Treatment treatment;
    @AttributeOverride(name = "id", column = @Column(name = "salon_id", nullable = false))
    private SalonId salonId;
    @AttributeOverride(name = "id", column = @Column(name = "customer_id", nullable = false))
    private CustomerId customerId;
    public Appointment() {
        super(DomainObjectId.randomId(AppointmentId.class));

    }
    public Appointment(@NonNull LocalDateTime dateFrom,@NonNull LocalDateTime dateTo,
                 @NonNull Treatment treatment, @NonNull SalonId salonId, @NonNull CustomerId customerId) {
        super(DomainObjectId.randomId(AppointmentId.class));
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.treatment = treatment;
        this.salonId = salonId;
        this.customerId = customerId;
    }


}
