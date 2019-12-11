package hibernate.model;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
    private String street;
    private Integer nr;

    public Address() {
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getNr() {
        return nr;
    }

    public void setNr(Integer nr) {
        this.nr = nr;
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", number=" + nr +
                '}';
    }
}
