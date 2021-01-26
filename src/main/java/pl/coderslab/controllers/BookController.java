package pl.coderslab.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pl.coderslab.models.Book;
import pl.coderslab.repositories.BookService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {

    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping("/helloBook")
    public Book helloBook() {
        return new Book(1L, "9788324631766", "Thinking in Java",
                "Bruce Eckel", "Helion", "programming");
    }

    @GetMapping("")
    public List<Book> getList() {
        return bookService.getAllBooks();
    }

    @PostMapping("")
    public void addBook(@RequestBody Book book){
        bookService.addBook(book);
    }


    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable("id") int id){
        bookService.deleteBook(id);

    }

    @GetMapping("/{id}")
    public Book getBook(@PathVariable("id") int id){

        if(bookService.getBook(id).isPresent()){
            return bookService.getBook(id).get();
        }
        return new Book();

    }

    @PutMapping("")
    public void updateBook(@RequestBody Book book){
        bookService.update(book);
    }


}
