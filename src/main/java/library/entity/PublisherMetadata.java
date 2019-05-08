package library.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import java.io.Serializable;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PublisherMetadata implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private int id;

    private int iso;

    @OneToOne
    @MapsId
    private Publisher publisher;

}
