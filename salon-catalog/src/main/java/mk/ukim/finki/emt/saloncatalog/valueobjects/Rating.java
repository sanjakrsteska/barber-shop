package mk.ukim.finki.emt.saloncatalog.valueobjects;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import mk.ukim.finki.emt.sharedkernel.domain.base.ValueObject;
@Embeddable
@Getter
public class Rating implements ValueObject {
private final double rating;
protected Rating() {
    this.rating = 0;
}
public Rating(double rating) {
    this.rating = rating;
}
public Rating changeRating(double rating) {
    return new Rating(rating);
}
}
