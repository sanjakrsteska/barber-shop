package mk.ukim.finki.emt.appointmentmanagement.services.impl;

import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import mk.ukim.finki.emt.appointmentmanagement.domain.models.Appointment;
import mk.ukim.finki.emt.appointmentmanagement.domain.models.AppointmentId;
import mk.ukim.finki.emt.appointmentmanagement.domain.repository.AppointmentRepository;
import mk.ukim.finki.emt.appointmentmanagement.services.AppointmentService;
import mk.ukim.finki.emt.appointmentmanagement.services.form.AppointmentForm;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
@Service
@Transactional
public class AppointmentServiceImpl implements AppointmentService {
    private final AppointmentRepository appointmentRepository;
    private final Validator validator;
    public AppointmentServiceImpl(AppointmentRepository appointmentRepository,Validator validator) {
        this.appointmentRepository = appointmentRepository;
        this.validator = validator;
    }

    @Override
    public Optional<Appointment> findById(AppointmentId id) {
       return appointmentRepository.findById(id);
    }

    @Override
    public AppointmentId createAppointment(AppointmentForm form) {
        Objects.requireNonNull(form,"Appointment must not be null.");
        var constraintViolations = validator.validate(form);
        if (constraintViolations.size()>0) {
            throw new ConstraintViolationException("The appointment form is not valid", constraintViolations);
        }
        var appointment = appointmentRepository.saveAndFlush(toDomainObject(form));
       //newOrder.getOrderItemList().forEach(item->domainEventPublisher.publish(new OrderItemCreated(item.getProductId().getId(),item.getQuantity())));
        return appointment.getId();
    }

    @Override
    public List<Appointment> getAll() {
        return appointmentRepository.findAll();
    }
    private Appointment toDomainObject(AppointmentForm form) {
        Appointment appointment = new Appointment(form.getDateFrom(),form.getDateTo(),form.getTreatment(),form.getSalon().getId()
                ,form.getCustomer().getId());
        return appointment;
    }
}
