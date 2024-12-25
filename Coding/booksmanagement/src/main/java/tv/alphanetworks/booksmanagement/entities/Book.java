package tv.alphanetworks.booksmanagement.entities;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity @Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Book {

    private @Id
    @GeneratedValue Long id;
    private String title;
    private String publisher;
    private String isbn;


    @ManyToOne
    private Author author;

    @ManyToOne
    private Genre genre;
}
