package mk.ukim.finki.emt.appointmentmanagement.services;

import mk.ukim.finki.emt.appointmentmanagement.domain.models.Appointment;
import mk.ukim.finki.emt.appointmentmanagement.domain.models.AppointmentId;
import mk.ukim.finki.emt.appointmentmanagement.services.form.AppointmentForm;

import java.util.List;
import java.util.Optional;

public interface AppointmentService {
    Optional<Appointment> findById(AppointmentId id);
    AppointmentId createAppointment(AppointmentForm form);
    List<Appointment> getAll();
}
