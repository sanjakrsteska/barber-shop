package mk.ukim.finki.emt.appointmentmanagement.xport.rest;

import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.appointmentmanagement.domain.models.Appointment;
import mk.ukim.finki.emt.appointmentmanagement.domain.models.AppointmentId;
import mk.ukim.finki.emt.appointmentmanagement.services.AppointmentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/appointment")
@AllArgsConstructor
public class AppointmentResource {

    private final AppointmentService appointmentService;

    @GetMapping
    public List<Appointment> getAll() {
        return appointmentService.getAll();
    }
    @GetMapping("/{id}")
    public Optional<Appointment> getById(@PathVariable String id) {
        return appointmentService.findById(AppointmentId.of(id));
    }

}
