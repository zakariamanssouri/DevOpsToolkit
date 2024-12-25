package tv.alphanetworks.booksmanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tv.alphanetworks.booksmanagement.entities.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
