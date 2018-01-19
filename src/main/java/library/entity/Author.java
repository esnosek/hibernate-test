package library.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Author implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToMany(mappedBy = "authors")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Magazine> magazines = new ArrayList<>();

    private String firstName;
    private String lastName;

    public void addMagazine(Magazine magazine) {
        this.magazines.add(magazine);
    }
}
