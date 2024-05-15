package mk.ukim.finki.emt.saloncatalog.xport.rest;

import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.saloncatalog.domain.models.Salon;
import mk.ukim.finki.emt.saloncatalog.domain.models.SalonId;
import mk.ukim.finki.emt.saloncatalog.services.SalonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/salon")
@AllArgsConstructor
public class SalonResource {

    private final SalonService salonService;

    @GetMapping
    public List<Salon> getAll() {
        return salonService.getAll();
    }
    @GetMapping("/{id}")
    public Optional<Salon> getById(@PathVariable String id) {
        return salonService.findById(SalonId.of(id));
    }

}
