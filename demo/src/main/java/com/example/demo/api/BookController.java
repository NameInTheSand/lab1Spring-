package com.example.demo.api;

import com.example.demo.model.Book;
import com.example.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/book")
@RestController
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public void addBook(@RequestBody Book book) {
        bookService.addBook(book);
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping(path = "{id}")
    public Book getBookByID(@PathVariable("id") UUID id) {
        return bookService.getBookById(id).orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deleteBookById(@PathVariable("id") UUID id) {
        bookService.deleteBook(id);
    }

    @PutMapping(path = "{id}")
    public void updateBook(@PathVariable("id") UUID id, @Valid @NonNull @RequestBody Book book) {
        bookService.updateBook(id, book);
    }
    @DeleteMapping
    public int DeleteAllBooks()
    {
        return bookService.deleteAllBooks();
    }

    @GetMapping(path = "/get/{author}")
    public Book getBookByAuthor(@PathVariable("author") String author)
    {return bookService.getBookByAuthor(author).orElse(null);}

    @GetMapping(path = "/get/publisher/{publisher}")
    public Book getBookByPublisher(@PathVariable("publisher") String publisher)
    {return bookService.getBookByPublisher(publisher).orElse(null);}
}
