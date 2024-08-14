package de.ait.books.repository;

import de.ait.books.entity.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BookRepositoryImp implements BookRepository {

    private List<Book> books = new ArrayList<>(List.of(
            new Book(456, "The Silent Forest", "Emily Harper", "978-3-16-148410-0", 101),
            new Book(457, "Journey to the Stars", "Michael Connor", "978-1-59-327584-6", 102),
            new Book(458, "Echoes of the Past", "Laura Jameson", "978-0-14-312774-1", 104),
            new Book(428, "The Lost Kingdom", "John Harrison", "978-0-06-265248-1", 107),
            new Book(498, "Whispers in the Wind", "Ava Morgan", "978-0-385-51346-4", 108),
            new Book(434, "The Final Countdown", "David Mitchell", "978-1-84195-799-4", 145),
            new Book(447, "Mysteries of the Deep", "Samantha Lee", "978-0-7432-7356-5", 195)
    ));

    @Override
    public List<Book> findAll() {
        return new ArrayList<>(books);
    }

    @Override
    public Book save(Book book) throws Exception {
        // Проверяем существует ли книга с таким ID
        for (Book existingBook : books) {
            if (existingBook.getId().equals(book.getId())) {
                throw new Exception("Book with ID " + book.getId() + " already exists.");
            }
        }
        books.add(book);
        return book;
    }

    @Override
    public Book findById(int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }

    @Override
    public void delete(Integer id) throws Exception {
        Book book = findById(id);
        if (book != null) {
            books.remove(book);
        } else {
            throw new Exception("Book with ID " + id + " not found.");
        }
    }
}
