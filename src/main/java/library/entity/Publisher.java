package library.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Publisher implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @Embedded
    private Address address;

    @OneToOne(mappedBy = "publisher", cascade = CascadeType.ALL)
    @Setter(AccessLevel.NONE)
    private PublisherMetadata publisherMetadata;

    @OneToMany(mappedBy = "publisher", cascade = CascadeType.ALL)
    @Setter(AccessLevel.NONE)
    private List<Book> books = new ArrayList<>();

    @OneToMany(mappedBy = "publisher", cascade = CascadeType.ALL)
    @Setter(AccessLevel.NONE)
    private List<Magazine> magazines = new ArrayList<>();

    public void addPublisherMetadata(PublisherMetadata publisherMetadata) {
        this.publisherMetadata = publisherMetadata;
        publisherMetadata.setPublisher(this);
    }

    public void removePublisherMetadata() {
        Optional.ofNullable(publisherMetadata).ifPresent(item -> item.setPublisher(null));
    }

    public void addBook(Book book) {
        this.books.add(book);
        book.setPublisher(this);
    }

    public void removeBook(Book book) {
        this.books.remove(book);
        book.setPublisher(null);
    }

    public void addMagazine(Magazine magazine) {
        this.magazines.add(magazine);
        magazine.setPublisher(this);
    }

    public void removeMagazine(Magazine magazine) {
        this.magazines.remove(magazine);
        magazine.setPublisher(null);
    }
}