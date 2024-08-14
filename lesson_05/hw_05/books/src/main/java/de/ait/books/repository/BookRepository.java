package de.ait.books.repository;

import de.ait.books.entity.Book;

import java.util.List;

public interface BookRepository {

   List<Book> findAll();

   Book save(Book book) throws Exception;

   Book findById(int id);

   void delete(Integer id) throws Exception;


}
