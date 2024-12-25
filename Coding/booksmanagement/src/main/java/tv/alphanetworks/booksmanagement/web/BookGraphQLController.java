package tv.alphanetworks.booksmanagement.web;

import lombok.AllArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import tv.alphanetworks.booksmanagement.dto.BookDTORequest;
import tv.alphanetworks.booksmanagement.entities.Book;
import tv.alphanetworks.booksmanagement.repositories.BookRepository;

import java.util.List;

@Controller
@AllArgsConstructor
public class BookGraphQLController {
    private BookRepository bookRepository;

    @QueryMapping
    public List<Book> booksList() {
        return bookRepository.findAll();
    }

    @MutationMapping
    public Book saveBook(@Argument BookDTORequest book) {
        Book newbook = new Book();
        newbook.setTitle(book.title());
        newbook.setAuthor(book.author());
        newbook.setPublisher(book.publisher());
        newbook.setIsbn(book.isbn());
        newbook.setGenre(book.genre());

        return bookRepository.save(newbook);
    }

}
