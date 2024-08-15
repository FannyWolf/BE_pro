package de.ait.books.service;

import de.ait.books.entity.Book;
import de.ait.books.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Predicate;

@Service
public class BookServiceImp implements BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookServiceImp(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book saveBook(Book book) throws Exception {
        return bookRepository.save(book);
    }

    @Override
    public Book findBookById(Integer id) {
        return findAllBooks()
                .stream()
                .filter(b->b.getId().equals(id))
                .findAny()
                .orElse(null);
    }

    @Override
    public List<Book> findBooks(String author) {
        Predicate<Book> predicateByAuthor = (author.equals("")) ? b -> true : b -> b.getAuthor().toLowerCase().contains(author.toLowerCase());

        return findAllBooks()
                .stream()
                .filter(predicateByAuthor)
                .toList();
    }


    @Override
    public Book updateBook(Integer id, Book book) throws Exception {
        Book existingBook = bookRepository.findById(id);
        if (existingBook != null) {
            existingBook.setTitle(book.getTitle());
            existingBook.setAuthor(book.getAuthor());
            existingBook.setIsbn(book.getIsbn());
            existingBook.setReaderId(book.getReaderId());

            return bookRepository.save(existingBook);
        } else {
            throw new Exception("Book with ID " + id + " not found.");
        }
    }

    @Override
    public void deleteBook(Integer id) throws Exception {
        Book existingBook = bookRepository.findById(id);
        if (existingBook != null) {
            bookRepository.delete(existingBook.getId());
        } else {
            throw new Exception("Book with ID " + id + " not found.");
        }
    }
}
