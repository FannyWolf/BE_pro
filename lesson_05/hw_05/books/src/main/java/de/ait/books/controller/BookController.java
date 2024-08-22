package de.ait.books.controller;

import de.ait.books.dto.BookRequestDto;
import de.ait.books.dto.BookResponseDto;
import de.ait.books.entity.Book;
import de.ait.books.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    /* @GetMapping("/books")
    public List<Book> getAllBooks() {
        return bookService.findAllBooks();
    } */

    @PostMapping("/books")
    public BookResponseDto saveBook(@RequestBody BookRequestDto bookDto) {
            BookResponseDto savedBook = bookService.saveBook(bookDto);
            return savedBook;
    }

    @GetMapping("/books/{id}")
    public BookResponseDto getBookById(@PathVariable Integer id) {
         return  bookService.findBookById(id);
    }

    // GET /books
    // GET /books?author=

    @GetMapping("/books")
    public List<BookResponseDto> getBooks(@RequestParam(name = "author",
                                    required = false, defaultValue = "")
                                    String author) {
        return bookService.findBooks(author);
    }

    @DeleteMapping ("/books/{id}")
    public void  deleteBook(@PathVariable Integer id) {
        bookService.deleteBook(id);
    }

    @PutMapping("/books/{id}")
    public BookResponseDto updateBook(@PathVariable(name = "id") Integer id,
                           @RequestBody BookRequestDto bookRequestDto) {
        return bookService.updateBook(id, bookRequestDto);
    }
}
