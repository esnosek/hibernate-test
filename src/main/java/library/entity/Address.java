package library.entity;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class Address implements Serializable{

    private static final long serialVersionUID = 1L;

    public Address(){}

    private String street;
    private String city;
    private String email;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
