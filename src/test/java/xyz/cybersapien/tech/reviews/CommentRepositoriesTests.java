package xyz.cybersapien.tech.reviews;

import xyz.cybersapien.tech.reviews.entity.Comment;
import xyz.cybersapien.tech.reviews.entity.Product;
import xyz.cybersapien.tech.reviews.entity.Review;
import xyz.cybersapien.tech.reviews.repository.CommentRepository;
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
public class CommentRepositoriesTests {
    @Autowired
    TestEntityManager testEntityManager;

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    ReviewRepository reviewRepository;

    @Before
    public void setup() {
        Product product = new Product("Oneplus 7", "Flagship killer");
        testEntityManager.persistAndFlush(product);
        Review review = new Review();
        review.setTitle("Oneplus 7");
        review.setProduct(product);
        review.setReviewText("An amazing phone yar!");
        review.setRecommended(true);
        testEntityManager.persistAndFlush(review);
    }

    @Test
    public void whenFindAllByReview_thenReturnEmptyList() {
        // given
        Review review = reviewRepository.findAll().get(0);

        // when
        List<Comment> comments = commentRepository.findAllByReview(review);

        // then
        assertThat(comments.size()).isEqualTo(0);
    }

    @Test
    public void whenFindAllByReview_thenReturnNonEmptyList() {
        // given
        Review review = reviewRepository.findAll().get(0);
        Comment comment = new Comment();
        comment.setTitle("Super Fast Phone!");
        comment.setCommentText("Amazing review!");
        comment.setReview(review);
        testEntityManager.persistAndFlush(comment);

        // when
        List<Comment> comments = commentRepository.findAllByReview(review);

        // then
        assertThat(comments.size()).isNotEqualTo(0);
    }
}
