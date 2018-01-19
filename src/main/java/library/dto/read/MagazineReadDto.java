package library.dto.read;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MagazineReadDto {

    List<AuthorReadDto> authors;
    private Integer id;
    private String title;
}

