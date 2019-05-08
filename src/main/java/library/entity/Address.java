package library.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
public class Address implements Serializable{

    private static final long serialVersionUID = 1L;

    private String street;
    private String city;
    private String email;
}
