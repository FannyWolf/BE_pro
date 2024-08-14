package de.ait.books.service;

import de.ait.books.entity.Book;

import java.util.List;

public interface BookService {

    List<Book> findAllBooks();

    Book saveBook(Book book) throws Exception;

    Book findBookById(Integer id);

    Book updateBook(Integer id, Book book) throws Exception;

    void deleteBook(Integer id) throws Exception;

}
