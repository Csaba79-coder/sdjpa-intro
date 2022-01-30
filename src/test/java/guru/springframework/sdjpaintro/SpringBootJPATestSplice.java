package guru.springframework.sdjpaintro;

import guru.springframework.sdjpaintro.domain.Book;
import guru.springframework.sdjpaintro.repositories.BookRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DataJpaTest // instead of @SpringBootTest annotation
// regarding this annotation bellow, the DataInitializer is running, so add two more books in results!
@ComponentScan(basePackages = {"guru.springframework.sdjpaintro.bootstrap"}) // list of packages!!!
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class SpringBootJPATestSplice {

    @Autowired
    BookRepository bookRepository;

    // Rollback and Commit annotations make the same result!!! :) newer version both operates, older version only Rollback!
    @Rollback(value = false)
    // @Commit
    @Order(1)
    @Test
    void testJPATestSplice() {

        Long countBefore = bookRepository.count();
        // DataInitializer is not functioning, that reason it fails:
        // assertThat(countBefore).isEqualTo(2); this fails!!!
        assertThat(countBefore).isEqualTo(2);

        bookRepository.save(new Book("My new book", "26", "mySelf"));


        Long countAfter = bookRepository.count();

        assertThat(countBefore).isLessThan(countAfter);
    }

    @Order(2)
    @Test
    void testJPATestSpliceTransaction() {
        // to run this one properly we have to make the Order annotation for tests! to run after eachother!
        Long countBefore = bookRepository.count();
        assertThat(countBefore).isEqualTo(3);

    }
}