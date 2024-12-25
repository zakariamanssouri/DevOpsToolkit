package tv.alphanetworks.booksmanagement;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import tv.alphanetworks.booksmanagement.entities.Author;
import tv.alphanetworks.booksmanagement.entities.Book;
import tv.alphanetworks.booksmanagement.entities.Genre;
import tv.alphanetworks.booksmanagement.repositories.AuthorRepository;
import tv.alphanetworks.booksmanagement.repositories.BookRepository;
import tv.alphanetworks.booksmanagement.repositories.GenreRepository;

@SpringBootApplication
public class BooksmanagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(BooksmanagementApplication.class, args);
	}


	@Bean
	CommandLineRunner commandLineRunner(GenreRepository genreRepository, BookRepository bookRepository, AuthorRepository authorRepository) {
		return args -> {

			Genre genre = new Genre();
			genre.setName("Genre 1");
			Author author = new Author();
			author.setName("Zakaria");
			author.setSurname("Mansouri ");

			Book book = new Book();
			book.setTitle("Book 1");
			book.setIsbn("99921-123123BB");
			book.setGenre(genreRepository.save(genre));
			book.setAuthor(authorRepository.save(author));
			bookRepository.save(book);


		};
	}

}
