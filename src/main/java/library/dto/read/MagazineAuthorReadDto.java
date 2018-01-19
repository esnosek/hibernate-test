package library.dto.read;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MagazineAuthorReadDto {
    private Integer id;
    private String title;
}
