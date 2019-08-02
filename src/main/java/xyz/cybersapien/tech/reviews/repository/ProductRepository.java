package xyz.cybersapien.tech.reviews.repository;

import xyz.cybersapien.tech.reviews.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    public Product findByName(String name);
}
