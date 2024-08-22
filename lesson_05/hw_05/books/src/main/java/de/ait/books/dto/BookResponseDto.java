package de.ait.books.dto;

import de.ait.books.entity.Book;

import java.util.List;
import java.util.stream.Collectors;

public class BookResponseDto {
    private Integer id;
    private String title;
    private String author;
    private String isbn;
    private Integer readerId;

    public BookResponseDto(Integer id, String title, String author, String isbn, Integer readerId) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.readerId = readerId;
    }

    public BookResponseDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Integer getReaderId() {
        return readerId;
    }

    public void setReaderId(Integer readerId) {
        this.readerId = readerId;
    }

    //User -> UserResponseDto
    public static BookResponseDto of(Book book) {
        return new BookResponseDto(book.getId(), book.getTitle(),
                book.getAuthor(), book.getIsbn(), book.getReaderId());
    }

    public static List<BookResponseDto> of(List<Book> user) {
        return user.stream()
                .map(BookResponseDto::of)
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "BookResponseDto{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", isbn='" + isbn + '\'' +
                ", readerId=" + readerId +
                '}';
    }
}
