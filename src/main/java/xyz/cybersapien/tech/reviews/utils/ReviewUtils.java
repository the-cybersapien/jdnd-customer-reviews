package xyz.cybersapien.tech.reviews.utils;

import xyz.cybersapien.tech.reviews.entity.Review;
import xyz.cybersapien.tech.reviews.repository.ReviewRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

public final class ReviewUtils {

    // Make this constructor private to ensure that this class can't be initialized
    private ReviewUtils() {
    }

    public static Review findReviewById(ReviewRepository reviewRepository, Integer reviewId) {
        Optional<Review> optionalReview = reviewRepository.findById(reviewId);

        if (optionalReview.isPresent())
            return optionalReview.get();

        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, String.format("Review with ID %d Not Found", reviewId)
        );
    }
}
