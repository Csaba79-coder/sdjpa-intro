package guru.springframework.sdjpaintro;

import guru.springframework.sdjpaintro.domain.Book;
import guru.springframework.sdjpaintro.repositories.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest // instead of @SpringBootTest annotation
public class SpringBootJPATestSplice {

    @Autowired
    BookRepository bookRepository;

    @Test
    void testJPATestSplice() {

        Long countBefore = bookRepository.count();

        bookRepository.save(new Book("My new book", "26", "mySelf"));

        Long countAfter = bookRepository.count();

        assertThat(countBefore).isLessThan(countAfter);
    }
}
