package tv.alphanetworks.booksmanagement.web;


import lombok.AllArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import tv.alphanetworks.booksmanagement.entities.Genre;
import tv.alphanetworks.booksmanagement.repositories.GenreRepository;

import java.util.List;

@AllArgsConstructor
@Transactional
@RestController
public class GenreController {

    private final GenreRepository genreRepository ;


    @GetMapping( "/api/genres")
    public List<Genre> all() {
        return genreRepository.findAll();
    }

    @GetMapping("/api/genres/{id}")
    public Genre findById(@PathVariable Long id) {
        return genreRepository.findById(id).orElse(null);
    }

    @PostMapping("/api/genres")
    public Genre create(@RequestBody Genre genre) {
        genre=genreRepository.save(genre);
        return genre;
    }

    @PutMapping("/api/genres")
    public Genre update(@RequestBody Genre updatedGenre) {
        Genre genre =genreRepository.findById(updatedGenre.getId()).orElse(null);
        if (genre !=null) {
            genre.setName(updatedGenre.getName());
            genre =genreRepository.save(genre);

            return genre;
        }
        return null;
    }

    @DeleteMapping("/api/genres/{id}")
    public void deleteById(@PathVariable Long id) {
        genreRepository.deleteById(id);
    }

}
