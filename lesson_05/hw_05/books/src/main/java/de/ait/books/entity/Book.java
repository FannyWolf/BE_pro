package de.ait.books.entity;

public class Book {
    private Integer id;
    private String title;
    private String author;
    private String isbn;
    private Integer readerId;

    public Book(Integer id, String title, String author, String isbn, Integer readerId) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.readerId = readerId;
    }

    public Integer getId() {
        return id;
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

    public Integer getReaderId() {
        return readerId;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setReaderId(Integer readerId) {
        this.readerId = readerId;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", isbn='" + isbn + '\'' +
                ", readerId=" + readerId +
                '}';
    }
}
