package tv.alphanetworks.booksmanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tv.alphanetworks.booksmanagement.entities.Genre;

public interface GenreRepository extends JpaRepository<Genre, Long> {
}
