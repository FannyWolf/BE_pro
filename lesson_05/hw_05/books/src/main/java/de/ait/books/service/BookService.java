package de.ait.books.service;

import de.ait.books.dto.BookRequestDto;
import de.ait.books.dto.BookResponseDto;
import de.ait.books.entity.Book;

import java.util.List;

public interface BookService {

   // List<Book> findAllBooks();

    BookResponseDto saveBook( BookRequestDto bookDto);

    BookResponseDto findBookById(Integer id);

    List<BookResponseDto> findBooks(String author);

    BookResponseDto updateBook(Integer id, BookRequestDto bookDto);

    void deleteBook(Integer id);

}
