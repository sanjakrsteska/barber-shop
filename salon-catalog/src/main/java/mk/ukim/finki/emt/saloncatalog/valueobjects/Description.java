package mk.ukim.finki.emt.saloncatalog.valueobjects;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Value;
import mk.ukim.finki.emt.sharedkernel.domain.base.ValueObject;

@Embeddable
@Getter
public class Description implements ValueObject {
    private final String description;
    protected Description() {
        this.description = null;
    }
    public Description(String description) {
        this.description = description;
    }
    public Description changeDescription(String description) {
        return new Description(description);
    }
}
