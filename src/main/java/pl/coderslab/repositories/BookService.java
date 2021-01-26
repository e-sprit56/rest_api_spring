package pl.coderslab.repositories;

import pl.coderslab.models.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {

    void addBook(Book book);

    List<Book> getAllBooks();

    boolean deleteBook(long id);

    Optional<Book> getBook(long id);

    void update (Book book);
}
