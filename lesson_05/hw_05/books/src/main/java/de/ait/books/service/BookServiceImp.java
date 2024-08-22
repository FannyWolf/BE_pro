package de.ait.books.service;

import de.ait.books.dto.BookRequestDto;
import de.ait.books.dto.BookResponseDto;
import de.ait.books.entity.Book;
import de.ait.books.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Predicate;

@Service
public class BookServiceImp implements BookService {

    private final BookRepository bookRepository;
    private final ModelMapper ;

    @Autowired
    public BookServiceImp(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    public List<BookResponseDto> findAllBooks() {
        return BookResponseDto.of(bookRepository.findAll());
    }

    @Override
    public Book saveBook(BookRequestDto bookDto) throws Exception {
        Book book = bookRepository.save(mapper.map(bookDto, Book.class));
        return mapper.map((bookDto, Book.class));
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
    public List<BookResponseDto> findBooks(String author) {
        Predicate<Book> predicateByAuthor = (author.equals("")) ? b -> true : b -> b.getAuthor().toLowerCase().contains(author.toLowerCase());

        List<Book> bookList = bookRepository.findAll()
                .stream()
                .filter(predicateByAuthor)
                .toList();
        return BookResponseDto.of(bookList);
    }


    @Override
    public Book updateBook(Integer id, BookRequestDto bookDto, Integer readerId) throws Exception {
        Book existingBook = bookRepository.findById(id);
        if (existingBook != null) {
            existingBook.setTitle(bookDto.getTitle());
            existingBook.setAuthor(bookDto.getAuthor());
            existingBook.setIsbn(bookDto.getIsbn());
            existingBook.setReaderId(readerId);

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
