package com.example.demo.dao;

import com.example.demo.model.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fakeDao")
public class FakePersonDataAccessService implements PersonDao {
    public static List<Book> DB = new ArrayList<>();
    @Override
    public int insertBook(UUID id, Book book) {
        DB.add(new Book(id, book.getName(), book.getAuthor()
        , book.getYear(), book.getPublisher(),
                book.getCounter()));
        return 1;
    }

    @Override
    public List<Book> selectAllBooks() {
        return DB;
    }


    @Override
    public Optional<Book> selectBookById(UUID id) {
        return DB.stream().
                filter(book -> book.getId().equals(id)).findFirst();
    }

    @Override
    public int deleteBookById(UUID id) {
        Optional<Book> personMaybe = selectBookById(id);
        if(personMaybe.isEmpty()) {
            return 0;
        }
        DB.remove(personMaybe.get());
        return 1;
    }

    @Override
    public int updateBookById(UUID id, Book update) {
        return selectBookById(id).map(book ->{
            int indexOfPersonToDelete = DB.indexOf(book);
            if(indexOfPersonToDelete >= 0) {
                DB.set(indexOfPersonToDelete, new Book(id, update.getName(),update.getAuthor(),
                        update.getYear(),update.getPublisher(), update.getCounter()));
                return 1;
            }
            return 0;
        }).orElse(0);

    }

    @Override
    public int deleteAllBooks() {
        DB.clear();
        return 1;
    }

    @Override
    public Optional<Book> selectByAuthor(String author) {
        return DB.stream().filter(book -> book.getAuthor().equals(author)).findFirst();

    }

    @Override
    public Optional<Book> selectByPublisher(String publisher) {
        return DB.stream().filter(book -> book.getPublisher().equals(publisher)).findFirst();
    }
}
