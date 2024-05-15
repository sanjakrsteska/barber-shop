package mk.ukim.finki.emt.appointmentmanagement.config;


import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.appointmentmanagement.domain.models.Appointment;
import mk.ukim.finki.emt.appointmentmanagement.domain.models.Currency;
import mk.ukim.finki.emt.appointmentmanagement.domain.repository.AppointmentRepository;
import mk.ukim.finki.emt.appointmentmanagement.domain.valueobjects.Customer;
import mk.ukim.finki.emt.appointmentmanagement.domain.valueobjects.Price;
import mk.ukim.finki.emt.appointmentmanagement.domain.valueobjects.Salon;
import mk.ukim.finki.emt.appointmentmanagement.domain.valueobjects.Treatment;
import mk.ukim.finki.emt.sharedkernel.domain.info.Address;
import mk.ukim.finki.emt.sharedkernel.domain.info.PhoneNumber;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;

@Component
@AllArgsConstructor
public class DataInitializer {

    private final AppointmentRepository appointmentRepository;

    @PostConstruct
    public void initData() {
        Salon salon = Salon.newSalon("Salon 1",PhoneNumber.valueOf("078956784"),
                Address.valueOf("Oktomvriska br 5","Prilep","Makedonija"));
        Customer customer = Customer.newCustomer("Angela", "Angeleska",
                Address.valueOf("Petta Prilepska br 15","Prilep","Makedonija"),PhoneNumber.valueOf("076451234"));
        Appointment a1 = new Appointment(LocalDateTime.of(2024, 5, 18, 12, 0),LocalDateTime.of(2024, 5, 18, 13, 0),
                Treatment.valueOf("brichenje", Price.valueOf(Currency.EUR,10)),salon.getId(),customer.getId());

        Appointment a2 =  new Appointment(LocalDateTime.of(2024, 6, 14, 11, 0),LocalDateTime.of(2024, 6, 14, 13, 0),
                Treatment.valueOf("farbanje", Price.valueOf(Currency.MKD,500)),salon.getId(),customer.getId());

        if (appointmentRepository.findAll().isEmpty()) {
            appointmentRepository.saveAll(Arrays.asList(a1,a2));
        }
    }
}
