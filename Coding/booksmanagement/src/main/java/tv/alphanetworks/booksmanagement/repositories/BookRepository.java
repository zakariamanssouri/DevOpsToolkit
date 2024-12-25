package tv.alphanetworks.booksmanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tv.alphanetworks.booksmanagement.entities.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}
