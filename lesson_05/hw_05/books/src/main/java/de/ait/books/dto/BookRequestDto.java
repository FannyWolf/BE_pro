package de.ait.books.dto;

import de.ait.books.entity.Book;

public class BookRequestDto {

    private String title;
    private String author;
    private String isbn;
    private Integer readerId;

    public BookRequestDto(String title, String author, String isbn, Integer readerId) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.readerId = readerId;
    }

    public Integer getReaderId() {
        return readerId;
    }

    public BookRequestDto() {
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    @Override
    public String toString() {
        return "BookRequestDto{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", isbn='" + isbn + '\'' +
                '}';
    }


    public static Book toEntity(BookRequestDto dto) {
        return new Book(null, dto.getTitle(), dto.getAuthor(), dto.getIsbn(), null);
    }
}
