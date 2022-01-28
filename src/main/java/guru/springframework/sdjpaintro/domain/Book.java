package guru.springframework.sdjpaintro.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Book {

    // the package called domain or model or entity

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    // @Column(name = "id", nullable = false)
    private Long id;

    private String title;
    private String isbn;
    private String publisher;

    public Book() {
    }

    public Book(String title, String isbn, String publisher) {
        this.title = title;
        this.isbn = isbn;
        this.publisher = publisher;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        // return id != null ? id.equals(book.id) : book.id == null;
        return Objects.equals(id, book.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
}
