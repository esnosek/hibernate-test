package library.dto.read;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PublisherReadDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String name;
    private AddressReadDto address;
    private PublisherMetadataReadDto publisherMetadata;
    private List<BookReadDto> books;
    private List<MagazineReadDto> magazines;
}
