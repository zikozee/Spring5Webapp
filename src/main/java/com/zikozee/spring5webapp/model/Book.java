package com.zikozee.spring5webapp.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //if using auto and working with SET, (Remember set takes a unique value)
    // since sequence is shared across the table, if 3 entities, at persistence,
    // each entity picks off where the last persister left off
    // And more so we might have author with same name hence no unique identifier
    // u must implement
    // hashCode and equals as below or, just have lombok do it for u as i hav done.
    //IDENTITY solves the above issue.
    //OR WE COULD USE SEQUENCE. i.e for those databases like Apache Derby that doesn't support Identity
    //@Id
    //@SequenceGenerator(name="sequence1", allocationSize=1, initialValue=1)
    //@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="sequence1")
    //private long id;
    @EqualsAndHashCode.Include
    private Long id;
    private String title;
    private String isbn;


    //@ManyToMany(cascade=CascadeType.ALL )
    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name = "author_book", joinColumns = @JoinColumn(name = "book_id"),
    inverseJoinColumns = @JoinColumn(name = "author_id"))
    private Set<Author> authors = new HashSet<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "publisher_id", referencedColumnName = "id")
    private Publisher publisher;

    public Book(String title, String isbn, Publisher publisher) {
        this.title = title;
        this.isbn = isbn;
        this.publisher = publisher;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Book book = (Book) o;
//        return Objects.equals(id, book.id);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id);
//    }
}
