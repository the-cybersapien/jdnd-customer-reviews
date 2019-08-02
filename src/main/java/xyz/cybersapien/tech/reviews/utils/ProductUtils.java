package xyz.cybersapien.tech.reviews.utils;

import xyz.cybersapien.tech.reviews.entity.Product;
import xyz.cybersapien.tech.reviews.repository.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

public final class ProductUtils {

    // Make this constructor private to ensure that this class can't be initialized
    private ProductUtils() {
    }

    public static Product findProductById(ProductRepository productRepository, Integer productId) {
        Optional<Product> optionalProduct = productRepository.findById(productId);

        if (optionalProduct.isPresent())
            return optionalProduct.get();

        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, String.format("Product with ID %d Not Found", productId)
        );
    }
}
