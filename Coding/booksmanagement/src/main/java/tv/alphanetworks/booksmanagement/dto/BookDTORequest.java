package tv.alphanetworks.booksmanagement.dto;


import lombok.Getter;
import lombok.Setter;
import tv.alphanetworks.booksmanagement.entities.Author;
import tv.alphanetworks.booksmanagement.entities.Genre;
public record BookDTORequest(
    Long id,
    String title,
    String publisher,
    String isbn,
    Author author,
    Genre genre
) {}