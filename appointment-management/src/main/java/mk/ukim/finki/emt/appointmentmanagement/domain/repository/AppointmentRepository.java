package mk.ukim.finki.emt.appointmentmanagement.domain.repository;

import mk.ukim.finki.emt.appointmentmanagement.domain.models.Appointment;
import mk.ukim.finki.emt.appointmentmanagement.domain.models.AppointmentId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, AppointmentId> {
}
