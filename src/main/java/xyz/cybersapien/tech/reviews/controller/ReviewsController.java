package xyz.cybersapien.tech.reviews.controller;

import org.springframework.validation.annotation.Validated;
import xyz.cybersapien.tech.reviews.entity.Product;
import xyz.cybersapien.tech.reviews.entity.Review;
import xyz.cybersapien.tech.reviews.repository.ProductRepository;
import xyz.cybersapien.tech.reviews.repository.ReviewRepository;
import xyz.cybersapien.tech.reviews.utils.ProductUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Spring REST controller for working with review entity.
 */
@RestController
@Validated
public class ReviewsController {

    private final ReviewRepository reviewRepository;
    private final ProductRepository productRepository;

    public ReviewsController(@Autowired ReviewRepository reviewRepository, @Autowired ProductRepository productRepository) {

        this.productRepository = productRepository;
        this.reviewRepository = reviewRepository;
    }

    /**
     * Creates a review for a product.
     *
     * @param productId The id of the product.
     * @return The created review or 404 if product id is not found.
     */
    @PostMapping(value = "/reviews/products/{productId}")
    public ResponseEntity<?> createReviewForProduct(@PathVariable("productId") Integer productId, @Valid @RequestBody Review review) {
        Product product = ProductUtils.findProductById(productRepository, productId);
        review.setProduct(product);
        return ResponseEntity.ok(reviewRepository.save(review));
    }

    /**
     * Lists reviews by product.
     *
     * @param productId The id of the product.
     * @return The list of reviews.
     */
    @GetMapping(value = "/reviews/products/{productId}")
    public ResponseEntity<List<?>> listReviewsForProduct(@PathVariable("productId") Integer productId) {
        Product product = ProductUtils.findProductById(productRepository, productId);
        return ResponseEntity.ok(reviewRepository.findAllByProduct(product));
    }
}
