package guru.springframework.sdjpaintro.bootstrap;

import guru.springframework.sdjpaintro.domain.Book;
import guru.springframework.sdjpaintro.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final BookRepository bookRepository;

    public DataInitializer(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Book bookDDD = new Book("Domain Driven Design", "9780321125217", "Addison-Wesley Longman Publishing Co.");
        System.out.println("ID (before saving): " + bookDDD.getId());
        Book savedDDD = bookRepository.save(bookDDD);

        System.out.println("ID: " + savedDDD.getId());

        Book bookSIA = new Book("Spring in Action", "9781617294945", "Manning Publications");
        Book savedSIA = bookRepository.save(bookSIA);

        System.out.println("ID: " + savedSIA.getId());

        bookRepository.findAll().forEach(book -> {

            System.out.println("Book ID: " + book.getId());
            System.out.println("Book title: " + book.getTitle());
            System.out.println("Book ISBN: " + book.getIsbn());
            System.out.println("Book publisher: " + book.getPublisher());
                }
        );
    }

    public BookRepository getBookRepository() {
        return bookRepository;
    }
}
