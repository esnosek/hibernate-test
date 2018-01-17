package library.dto;

import java.io.Serializable;

public class PublisherDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;
    private AddressDto address;

    public PublisherDto(String name, AddressDto address) {
        this.name = name;
        this.address = address;
    }

    public PublisherDto(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AddressDto getAddress() {
        return address;
    }

    public void setAddress(AddressDto addressDto) {
        this.address = addressDto;
    }
}
