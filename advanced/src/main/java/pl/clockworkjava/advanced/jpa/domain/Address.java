package pl.clockworkjava.advanced.jpa.domain;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
    private String street;
    private String city;
}
