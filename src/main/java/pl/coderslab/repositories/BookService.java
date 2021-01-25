package pl.coderslab.repositories;

import pl.coderslab.models.Book;

import java.util.List;

public interface BookService {

    void addBook(Book book);

    List<Book> getBooks();
}
