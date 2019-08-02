package xyz.cybersapien.tech.reviews.repository;

import xyz.cybersapien.tech.reviews.entity.Comment;
import xyz.cybersapien.tech.reviews.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

    List<Comment> findAllByReview(Review review);

}
