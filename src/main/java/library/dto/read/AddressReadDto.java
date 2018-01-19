package library.dto.read;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AddressReadDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private String street;
    private String city;
    private String email;
}

