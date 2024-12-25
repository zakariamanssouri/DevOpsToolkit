package tv.alphanetworks.booksmanagement.web;


import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import tv.alphanetworks.booksmanagement.entities.Book;
import tv.alphanetworks.booksmanagement.entities.Book;
import tv.alphanetworks.booksmanagement.repositories.BookRepository;

import java.util.List;

@AllArgsConstructor
@Transactional
@RestController
public class BookController {

    private final BookRepository bookRepository;


    @PostMapping("/api/books")
    public Book create(@RequestBody Book book) {
        book=bookRepository.save(book);
        return book;
    }

    @GetMapping( "/api/books")
    public List<Book> all() {
        return bookRepository.findAll();
    }

    @GetMapping("/api/books/{id}")
    public Book findById(@PathVariable Long id) {
        return bookRepository.findById(id).orElse(null);
    }


    @PutMapping("/api/books")
    public Book update(@RequestBody Book updatedBook) {
        Book book =bookRepository.findById(updatedBook.getId()).orElse(null);
        if (book !=null) {
            book.setTitle(updatedBook.getTitle());
            book.setAuthor(updatedBook.getAuthor());
            book.setPublisher(updatedBook.getPublisher());
            book.setGenre(updatedBook.getGenre());
            book =bookRepository.save(book);
            return book;
        }
        return null;
    }

    @DeleteMapping("/api/books/{id}")
    public void deleteById(@PathVariable Long id) {
        bookRepository.deleteById(id);
    }


}
