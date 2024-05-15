package mk.ukim.finki.emt.saloncatalog.domain.repository;

import mk.ukim.finki.emt.saloncatalog.domain.models.Salon;
import mk.ukim.finki.emt.saloncatalog.domain.models.SalonId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalonRepository extends JpaRepository<Salon, SalonId> {
}
