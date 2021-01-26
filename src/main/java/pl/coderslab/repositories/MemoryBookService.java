package pl.coderslab.repositories;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;
import pl.coderslab.models.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class MemoryBookService implements BookService {

    private static Long nextId = 4L;

    private List<Book> list;

    public MemoryBookService() {
        list = new ArrayList<>();
        list.add(new Book(1L, "9788324631766", "Thiniking in Java", "Bruce Eckel", "Helion", "programming"));
        list.add(new Book(2L, "9788324627738", "Rusz glowa Java.", "Sierra Kathy, Bates Bert", "Helion",
                "programming"));
        list.add(new Book(3L, "9780130819338", "Java 2. Podstawy", "Cay Horstmann, Gary Cornell", "Helion",
                "programming"));
    }


    @Override
    public void addBook(Book book) {
        book.setId(nextId++);
        list.add(book);

    }

    @Override
    public List<Book> getAllBooks() {
        return list;
    }

    @Override
    public boolean deleteBook(long id) {
        return list.removeIf(book -> book.getId() == id);
    }

    @Override
    public Optional<Book> getBook(long id) {

        return list.stream().filter(book -> book.getId()==id).findFirst();
    }

    @Override
    public void update(Book book) {

        if(getBook(book.getId()).isPresent()){
            Book bookToUpdate = getBook(book.getId()).get();
            int bookIndex =list.indexOf(bookToUpdate);
            list.set(bookIndex, book);
        }

    }
}
