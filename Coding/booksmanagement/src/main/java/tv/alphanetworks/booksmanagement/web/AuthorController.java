package tv.alphanetworks.booksmanagement.web;


import org.springframework.web.bind.annotation.*;
import tv.alphanetworks.booksmanagement.entities.Author;
import tv.alphanetworks.booksmanagement.repositories.AuthorRepository;

import java.util.List;

@RestController
public class AuthorController {

    private final AuthorRepository authorRepository ;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }


    @GetMapping( "/api/authors")
    public List<Author> all() {
        return authorRepository.findAll();
    }

    @GetMapping("/api/authors/{id}")
    public Author findById(@PathVariable Long id) {
        return authorRepository.findById(id).orElse(null);
    }

    @PostMapping("/api/authors")
    public Author create(@RequestBody Author author) {
        author=authorRepository.save(author);
        return author;
    }

    @PutMapping("/api/authors")
    public Author update(@RequestBody Author updatedAuthor) {
        Author author =authorRepository.findById(updatedAuthor.getId()).orElse(null);
        if (author !=null) {
            author.setName(updatedAuthor.getName());
            author.setSurname(updatedAuthor.getSurname());
            author =authorRepository.save(author);
            return author;
        }
        return null;
    }

    @DeleteMapping("/api/authors/{id}")
    public void deleteById(@PathVariable Long id) {
        authorRepository.deleteById(id);
    }
}
