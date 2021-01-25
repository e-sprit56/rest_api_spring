package pl.coderslab.repositories;

import pl.coderslab.models.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {

    void addBook(Book book);

    List<Book> getAllBooks();

    boolean deleteBook(int id);

    Optional<Book> getBook(int id);
}
