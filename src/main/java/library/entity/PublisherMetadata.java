package library.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import java.io.Serializable;

@Entity
public class PublisherMetadata implements Serializable {

    @Id
    private Integer id;
    @OneToOne
    @MapsId
    private Publisher publisher;

    public PublisherMetadata() {
    }

    public PublisherMetadata(Publisher publisher) {
        this.publisher = publisher;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }
}
