package mk.ukim.finki.emt.saloncatalog.services;

import mk.ukim.finki.emt.saloncatalog.domain.models.Salon;
import mk.ukim.finki.emt.saloncatalog.domain.models.SalonId;

import java.util.List;
import java.util.Optional;

public interface SalonService {
    Optional<Salon> findById(SalonId id);
    List<Salon> getAll();
}
