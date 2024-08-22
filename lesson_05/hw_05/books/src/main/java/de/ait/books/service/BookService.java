package de.ait.books.service;

import de.ait.books.dto.BookRequestDto;
import de.ait.books.entity.Book;

import java.util.List;

public interface BookService {

   // List<Book> findAllBooks();

    Book saveBook( BookRequestDto bookDto) throws Exception;

    Book findBookById(Integer id);

    List<BookResponseDto> findBooks(String author);

    Book updateBook(Integer id, BookRequestDto bookDto, Integer readerId) throws Exception;

    void deleteBook(Integer id) throws Exception;


}
