package xyz.cybersapien.tech.reviews.repository;

import xyz.cybersapien.tech.reviews.entity.Product;
import xyz.cybersapien.tech.reviews.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {
    List<Review> findAllByProduct(Product product);
}
