package xyz.cybersapien.tech.reviews.controller;

import xyz.cybersapien.tech.reviews.entity.Comment;
import xyz.cybersapien.tech.reviews.entity.Review;
import xyz.cybersapien.tech.reviews.repository.CommentRepository;
import xyz.cybersapien.tech.reviews.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static xyz.cybersapien.tech.reviews.utils.ReviewUtils.findReviewById;

/**
 * Spring REST controller for working with comment entity.
 */
@RestController
@RequestMapping("/comments")
public class CommentsController {


    private final CommentRepository commentRepository;
    private final ReviewRepository reviewRepository;

    public CommentsController(@Autowired CommentRepository commentRepository,
                              @Autowired ReviewRepository reviewRepository) {
        this.commentRepository = commentRepository;
        this.reviewRepository = reviewRepository;
    }

    /**
     * Creates a comment for a review.
     *
     * @param reviewId The id of the review.
     */
    @RequestMapping(value = "/reviews/{reviewId}", method = RequestMethod.POST)
    public ResponseEntity<Comment> createCommentForReview(
            @PathVariable("reviewId") Integer reviewId,
            @RequestBody Comment comment
    ) {
        Review review = findReviewById(reviewRepository, reviewId);
        comment.setReview(review);
        return ResponseEntity.ok(commentRepository.save(comment));
    }

    /**
     * List comments for a review.
     *
     * @param reviewId The id of the review.
     */
    @RequestMapping(value = "/reviews/{reviewId}", method = RequestMethod.GET)
    public ResponseEntity<List<Comment>> listCommentsForReview(@PathVariable("reviewId") Integer reviewId) {
        Review review = findReviewById(reviewRepository, reviewId);
        return ResponseEntity.ok(commentRepository.findAllByReview(review));
    }

}
