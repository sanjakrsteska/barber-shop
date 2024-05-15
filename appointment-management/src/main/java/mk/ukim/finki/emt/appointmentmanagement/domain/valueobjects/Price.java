package mk.ukim.finki.emt.appointmentmanagement.domain.valueobjects;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.NonNull;
import mk.ukim.finki.emt.appointmentmanagement.domain.models.Currency;
import mk.ukim.finki.emt.sharedkernel.domain.base.ValueObject;

@Embeddable
@Getter
public class Price implements ValueObject {
    private final int price;
    @Enumerated(EnumType.STRING)
    private final Currency currency;

    protected Price() {
        this.price = 0;
        this.currency = null;
    }
    public static Price valueOf(Currency currency, int price) {
        return new Price(currency, price);
    }
    public Price(@NonNull Currency currency, @NonNull int price) {
        this.price = price;
        this.currency = currency;
    }
    public Price add(Price price) {
        if (!currency.equals(price.currency)) {
            throw new IllegalArgumentException("Cannot add two Price objects with different currencies");
        }
        return new Price(currency,Price.this.price + price.price);
    }

    public Price subtract(Price price) {
        if (!currency.equals(price.currency)) {
            throw new IllegalArgumentException("Cannot add two Price objects with different currencies");
        }
        return new Price(currency,Price.this.price - price.price);
    }

    public Price multiply(int m)  {
        return new Price(currency,price*m);
    }
}
