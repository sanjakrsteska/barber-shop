package mk.ukim.finki.emt.saloncatalog.services.impl;


import jakarta.validation.Validator;
import mk.ukim.finki.emt.saloncatalog.domain.models.Salon;
import mk.ukim.finki.emt.saloncatalog.domain.models.SalonId;
import mk.ukim.finki.emt.saloncatalog.domain.repository.SalonRepository;
import mk.ukim.finki.emt.saloncatalog.services.SalonService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;
@Service
@Transactional
public class SalonServiceImpl implements SalonService {
    private final SalonRepository salonRepository;
    private final Validator validator;
    public SalonServiceImpl(SalonRepository salonRepository, Validator validator) {
        this.salonRepository = salonRepository;
        this.validator = validator;
    }

    @Override
    public Optional<Salon> findById(SalonId id) {
       return salonRepository.findById(id);
    }


    @Override
    public List<Salon> getAll() {
        return salonRepository.findAll();
    }

}
