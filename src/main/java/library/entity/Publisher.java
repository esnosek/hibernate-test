package library.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Publisher implements Serializable {

    private static final long serialVersionUID = 1L;

    public Publisher() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @Embedded
    private Address address;

    @OneToOne(mappedBy = "publisher", cascade = CascadeType.ALL)
    private PublisherMetadata publisherMetadata;

    @OneToMany(mappedBy = "publisher", cascade = CascadeType.ALL)
    private List<Book> books;

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

    public PublisherMetadata getPublisherMetadata() {
        return publisherMetadata;
    }

    public void addPublisherMetadata(PublisherMetadata publisherMetadata) {
        this.publisherMetadata = publisherMetadata;
        publisherMetadata.setPublisher(this);
    }

    public void removePublisherMetadata() {
        if (this.publisherMetadata != null)
            publisherMetadata.setPublisher(null);
    }

    public void addBook(Book book) {
        if (this.books == null) {
            this.books = new ArrayList<>();
        }
        this.books.add(book);
        book.setPublisher(this);
    }

    public void removeBook(Book book) {
        this.books.remove(book);
        book.setPublisher(null);
    }
}