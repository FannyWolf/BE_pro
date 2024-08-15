package de.ait.books.controller;

import de.ait.books.entity.Book;
import de.ait.books.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
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
    public ResponseEntity<Book> saveBook(@RequestBody Book book) {
        try {
            Book savedBook = bookService.saveBook(book);
            return ResponseEntity.ok(savedBook);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @GetMapping("/books/{id}")
    public Book getBookById(@PathVariable Integer id) {
         return  bookService.findBookById(id);
    }

    // GET /books
    // GET /books?author=

    @GetMapping("/books")
    public List<Book> getBooks(@RequestParam(name = "author", required = false, defaultValue = "")
                                   String author) {
        return bookService.findBooks(author);
    }

    @DeleteMapping ("/books/{id}")
    public void  deleteBook(@PathVariable Integer id) throws Exception {
        bookService.deleteBook(id);
    }
}
