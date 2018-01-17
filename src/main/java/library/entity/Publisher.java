package library.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Publisher implements Serializable {

    private static final long serialVersionUID = 1L;

    public Publisher(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @Embedded
    private Address address;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}