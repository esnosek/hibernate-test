package library.dto.read;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AuthorReadDto {

    private Integer id;
    private String firstName;
    private String lastName;
    private List<MagazineAuthorReadDto> magazines;

}
