package mk.ukim.finki.emt.appointmentmanagement.domain.valueobjects;

import jakarta.persistence.Embeddable;
import lombok.NonNull;
import mk.ukim.finki.emt.sharedkernel.domain.base.ValueObject;
import mk.ukim.finki.emt.sharedkernel.domain.info.Address;

@Embeddable
public class Treatment implements ValueObject {
    private final String treatmentName;
    private final Price price;
    protected Treatment() {
        this.treatmentName = null;
        this.price = null;
    }
    public Treatment(@NonNull String treatmentName, @NonNull Price price) {
        this.treatmentName = treatmentName;
        this.price = price;
    }
    public static Treatment valueOf(String treatmentName, Price price) {
        return new Treatment(treatmentName,price);
    }
    public Treatment changeTreatmentName(String treatmentName) {
        return new Treatment(treatmentName,this.price);
    }
    public Treatment increaseTreatmentPrice(Price price) {
        Price increasedPrice = this.price.add(price);
        return new Treatment(this.treatmentName,increasedPrice);
    }
    public Treatment increaseTreatmentPrice(int factor) {
        Price increasedPrice = this.price.multiply(factor);
        return new Treatment(this.treatmentName,increasedPrice);
    }

    public Treatment decreaseTreatmentPrice(Price price) {
        Price decreasedPrice = this.price.subtract(price);
        return new Treatment(this.treatmentName,decreasedPrice);
    }


}
