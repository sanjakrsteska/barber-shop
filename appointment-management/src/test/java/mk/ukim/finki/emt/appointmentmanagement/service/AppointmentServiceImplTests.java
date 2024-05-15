package mk.ukim.finki.emt.appointmentmanagement.service;

import mk.ukim.finki.emt.appointmentmanagement.domain.exceptions.AppointmentNotFoundException;
import mk.ukim.finki.emt.appointmentmanagement.domain.models.Appointment;
import mk.ukim.finki.emt.appointmentmanagement.domain.models.AppointmentId;
import mk.ukim.finki.emt.appointmentmanagement.domain.models.Currency;
import mk.ukim.finki.emt.appointmentmanagement.domain.valueobjects.Customer;
import mk.ukim.finki.emt.appointmentmanagement.domain.valueobjects.Price;
import mk.ukim.finki.emt.appointmentmanagement.domain.valueobjects.Salon;
import mk.ukim.finki.emt.appointmentmanagement.domain.valueobjects.Treatment;
import mk.ukim.finki.emt.appointmentmanagement.services.AppointmentService;
import mk.ukim.finki.emt.appointmentmanagement.services.form.AppointmentForm;
import mk.ukim.finki.emt.appointmentmanagement.services.form.CustomerForm;
import mk.ukim.finki.emt.appointmentmanagement.services.form.SalonForm;
import mk.ukim.finki.emt.appointmentmanagement.xport.client.CustomerClient;
import mk.ukim.finki.emt.appointmentmanagement.xport.client.SalonClient;
import mk.ukim.finki.emt.sharedkernel.domain.info.Address;
import mk.ukim.finki.emt.sharedkernel.domain.info.PhoneNumber;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
public class AppointmentServiceImplTests {

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private SalonClient salonClient;
    @Autowired
    private CustomerClient customerClient;

    @Test
    public void testCreateAppointment() {

        SalonForm s1 = new SalonForm();
        s1.setAddress(Address.valueOf("Petta Prilepska br 4","Prilep","Makedonija"));
        s1.setName("Frizerski salon kaj Zhane");
        s1.setPhoneNumber(PhoneNumber.valueOf("079867541"));

        SalonForm s2 = new SalonForm();
        s1.setAddress(Address.valueOf("Braka Miladinovci br 45","Prilep","Makedonija"));
        s1.setName("Frizerski salon DiCaprio");
        s1.setPhoneNumber(PhoneNumber.valueOf("076543214"));

        CustomerForm customerForm = new CustomerForm();
        customerForm.setFirstName("Hristi");
        customerForm.setLastName("Angelovski");
        customerForm.setAddress(Address.valueOf("Vera Ciriviri br 14","Prilep","Makedonija"));
        customerForm.setPhoneNumber(PhoneNumber.valueOf("076588900"));

        Customer customer = Customer.newCustomer(customerForm.getFirstName(), customerForm.getLastName(),
                customerForm.getAddress(),customerForm.getPhoneNumber());

        AppointmentForm appointmentForm = new AppointmentForm();
        Salon salon1 = Salon.newSalon(s1.getName(),s1.getPhoneNumber(),s1.getAddress());
        appointmentForm.setSalon(salon1);
        appointmentForm.setTreatment(Treatment.valueOf("farbanje", Price.valueOf(Currency.USD,15)));
        appointmentForm.setDateFrom(LocalDateTime.of(2024,4,12,12,45));
        appointmentForm.setDateTo(LocalDateTime.of(2024,4,12,13,45));
        appointmentForm.setCustomer(customer);
        AppointmentId appointmentId = appointmentService.createAppointment(appointmentForm);

        Appointment appointment = appointmentService.findById(appointmentId)
                .orElseThrow(AppointmentNotFoundException::new);
        System.out.println("Created appointment with id: "+ appointmentId.getId());
        System.out.println("Appointment with id saved in database: " + appointment.getId().getId());
        Assertions.assertEquals(appointmentId,appointment.getId());

    }

    @Test
    public void testCreateAppointmentWithRealData() {
        List<Salon> salons = salonClient.findAll();
        List<Customer> customers = customerClient.findAll();
        AppointmentForm appointmentForm = new AppointmentForm();
        appointmentForm.setSalon(salons.get(0));
        appointmentForm.setTreatment(Treatment.valueOf("brichenje", Price.valueOf(Currency.EUR,13)));
        appointmentForm.setDateFrom(LocalDateTime.of(2024,5,12,12,15));
        appointmentForm.setDateTo(LocalDateTime.of(2024,5,12,13,45));
        appointmentForm.setCustomer(customers.get(0));
        AppointmentId appointmentId = appointmentService.createAppointment(appointmentForm);

        Appointment appointment = appointmentService.findById(appointmentId)
                .orElseThrow(AppointmentNotFoundException::new);
        System.out.println("Created appointment with id: "+ appointmentId.getId());
        System.out.println("Appointment with id saved in database: " + appointment.getId().getId());
        Assertions.assertEquals(appointmentId,appointment.getId());

    }




}

