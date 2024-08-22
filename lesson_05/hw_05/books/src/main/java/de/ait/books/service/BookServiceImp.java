package de.ait.books.service;

import de.ait.books.dto.BookRequestDto;
import de.ait.books.dto.BookResponseDto;
import de.ait.books.entity.Book;
import de.ait.books.repository.BookRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Predicate;

@Service
public class BookServiceImp implements BookService {

    private final BookRepository bookRepository;
    private final ModelMapper mapper;

    @Autowired
    public BookServiceImp(BookRepository bookRepository, ModelMapper mapper) {
        this.bookRepository = bookRepository;
        this.mapper = mapper;
    }


    public List<BookResponseDto> findAllBooks() {
        return BookResponseDto.of(bookRepository.findAll());
    }

    @Override
    public BookResponseDto saveBook(BookRequestDto bookDto) {
        Book book = bookRepository.save(mapper.map(bookDto, Book.class));
        return mapper.map(book, BookResponseDto.class);
    }


    @Override
    public BookResponseDto findBookById(Integer id) {
        return findAllBooks()
                .stream()
                .filter(b->b.getId().equals(id))
                .findAny()
                .orElse(null);
    }

    @Override
    public List<BookResponseDto> findBooks(String author) {
        Predicate<Book> predicateByAuthor = (author.equals("")) ?
                                            b -> true : b -> b.getAuthor().toLowerCase().contains(author.toLowerCase());

        List<Book> bookList = bookRepository.findAll()
                .stream()
                .filter(predicateByAuthor)
                .toList();
        return BookResponseDto.of(bookList);
    }


//    @Override
//    public BookResponseDto updateBook(Integer id, BookRequestDto bookDto) {
//        Book existingBook = bookRepository.findById(id);
//        if (existingBook != null) {
//            existingBook.setTitle(bookDto.getTitle());
//            existingBook.setAuthor(bookDto.getAuthor());
//            existingBook.setIsbn(bookDto.getIsbn());
//            existingBook.setReaderId(bookDto.getReaderId());
//
//            Book book_1 = bookRepository.save(existingBook);
//
//            return mapper.map(book_1, BookResponseDto.class);
//        } else {
//            throw new RuntimeException("Book with ID " + id + " not found.");
//        }
//    }

    @Override
    public BookResponseDto updateBook(Integer id, BookRequestDto bookDto) {
        Book existingBook = bookRepository.findById(id);

        if (existingBook != null) {

            existingBook.setTitle(bookDto.getTitle());
            existingBook.setAuthor(bookDto.getAuthor());
            existingBook.setIsbn(bookDto.getIsbn());
            existingBook.setReaderId(bookDto.getReaderId());

            Book updatedBook = bookRepository.save(existingBook);

            return mapper.map(updatedBook, BookResponseDto.class);
        } else {
            Book newBook = mapper.map(bookDto, Book.class);
            newBook.setId(id);

            Book savedBook = bookRepository.save(newBook);

            return mapper.map(savedBook, BookResponseDto.class);
        }
    }


    @Override
    public void deleteBook(Integer id){
        Book existingBook = bookRepository.findById(id);
        if (existingBook != null) {
            bookRepository.delete(existingBook.getId());
        } else {
            throw new RuntimeException("Book with ID " + id + " not found.");
        }
    }
}
