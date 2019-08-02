package xyz.cybersapien.tech.reviews;

import xyz.cybersapien.tech.reviews.entity.Product;
import xyz.cybersapien.tech.reviews.entity.Review;
import xyz.cybersapien.tech.reviews.repository.ProductRepository;
import xyz.cybersapien.tech.reviews.repository.ReviewRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ReviewRepositoryTests {

    @Autowired
    TestEntityManager entityManager;

    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    ProductRepository productRepository;

    @Before
    public void setup() {
        Product product = new Product("Oneplus 7", "The Flagship Killer");
        entityManager.persistAndFlush(product);
    }

    @Test
    public void whenFindAllByProduct_thenReturnEmptyList() {
        // given
        Product product = productRepository.findAll().get(0);

        // when
        List<Review> reviews = reviewRepository.findAllByProduct(product);

        // then
        assertThat(reviews.size()).isEqualTo(0);
    }

    @Test
    public void whenFindAllByProduct_thenReturnNonEmptyList() {
        // given
        Product product = productRepository.findAll().get(0);
        Review review = new Review();
        review.setTitle("Super Fast Phone!");
        review.setProduct(product);
        review.setRecommended(true);
        entityManager.persistAndFlush(review);

        // when
        List<Review> reviews = reviewRepository.findAllByProduct(product);

        // then
        assertThat(reviews.size()).isNotEqualTo(0);
    }

}
