package com.example.demo.service;

import com.example.demo.dao.PersonDao;
import com.example.demo.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BookService {
    private final PersonDao personDao;

    @Autowired
    public BookService(@Qualifier("fakeDao") PersonDao personDao) {
        this.personDao = personDao;
    }

    public int addBook(Book book) {
        return personDao.insertBook(book);
    }

    public List<Book> getAllBooks() {
        return personDao.selectAllBooks();
    }

    public Optional<Book> getBookById(UUID id) {
        return personDao.selectBookById(id);
    }

    public int deleteBook(UUID id) {
        return personDao.deleteBookById(id);
    }

    public int updateBook(UUID id, Book newBook) {
        return personDao.updateBookById(id, newBook);
    }
    public int deleteAllBooks()
    {
        return  personDao.deleteAllBooks();
    };
    public Optional<Book> getBookByAuthor(String author) {
        return personDao.selectByAuthor(author);
    }
    public Optional<Book> getBookByPublisher(String publisher) {
        return personDao.selectByPublisher(publisher);
    }
}
