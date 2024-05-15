package mk.ukim.finki.emt.appointmentmanagement.services.form;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import mk.ukim.finki.emt.appointmentmanagement.domain.valueobjects.*;

import java.time.LocalDateTime;

@Data
public class AppointmentForm {
    @NotNull
    private LocalDateTime dateFrom;
    @NotNull
    private LocalDateTime dateTo;
    @NotNull
    private Treatment treatment;
    @NotNull
    private Salon salon;
    @NotNull
    private Customer customer;

}
