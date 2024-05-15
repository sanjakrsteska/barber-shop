package mk.ukim.finki.emt.saloncatalog.config;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;

import mk.ukim.finki.emt.saloncatalog.domain.models.Salon;
import mk.ukim.finki.emt.saloncatalog.domain.repository.SalonRepository;
import mk.ukim.finki.emt.sharedkernel.domain.info.Address;
import mk.ukim.finki.emt.sharedkernel.domain.info.PhoneNumber;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@AllArgsConstructor
public class DataInitializer {

    private final SalonRepository salonRepository;

    @PostConstruct
    public void initData() {
        Salon s1 = Salon.build("Salon no:1", PhoneNumber.valueOf("078945678")
                , Address.valueOf("Partizanska br 10","Skopje","Makedonija"));
        Salon s2 = Salon.build("Salon no:2", PhoneNumber.valueOf("074671234")
                , Address.valueOf("Adem Ademoski br 108","Prilep","Makedonija"));
        if (salonRepository.findAll().isEmpty()) {
            salonRepository.saveAll(Arrays.asList(s1,s2));
        }
    }
}
