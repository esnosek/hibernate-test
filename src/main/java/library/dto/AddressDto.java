package library.dto;

import java.io.Serializable;

public class AddressDto implements Serializable {

    private String street;
    private String city;
    private String email;

    public AddressDto(String street, String city, String email) {
        this.street = street;
        this.city = city;
        this.email = email;
    }

    public AddressDto(){}

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
