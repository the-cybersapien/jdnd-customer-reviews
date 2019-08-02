package xyz.cybersapien.tech.reviews;

import xyz.cybersapien.tech.reviews.entity.Product;
import xyz.cybersapien.tech.reviews.repository.ProductRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ProductRepositoryTests {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void whenFindByName_thenReturnProduct() {
        // given
        Product testProduct = new Product("Oneplus 7 Pro", "The fastest one yet!");
        testEntityManager.persistAndFlush(testProduct);

        // when
        Product found = productRepository.findByName(testProduct.getName());

        // then
        assertThat(found.getName())
                .isEqualTo(testProduct.getName());
    }

}
