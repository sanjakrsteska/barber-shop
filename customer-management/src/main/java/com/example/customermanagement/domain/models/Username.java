package com.example.customermanagement.domain.models;

import jakarta.persistence.Embeddable;
import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;
import org.springframework.lang.NonNull;

public class Username extends DomainObjectId {

    private Username() {
        super(Username.randomId(Username.class).getId());
    }

    public Username(@NonNull String uuid) {
        super(uuid);
    }

    public static Username of(String uuid) {
        Username s = new Username(uuid);
        return s;
    }
}
