package xyz.cybersapien.tech.reviews.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import xyz.cybersapien.tech.reviews.entity.Product;
import xyz.cybersapien.tech.reviews.repository.ProductRepository;
import xyz.cybersapien.tech.reviews.utils.ProductUtils;

import javax.validation.Valid;
import java.util.List;

/**
 * Spring REST controller for working with product entity.
 */
@RestController
@Validated
@RequestMapping("/products")
public class ProductsController {

    private final ProductRepository productRepository;

    public ProductsController(@Autowired ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    /**
     * Creates a product.
     */
    @PostMapping(value = "/")
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@Valid @RequestBody Product product) {
        productRepository.save(product);
    }

    /**
     * Finds a product by id.
     *
     * @param id The id of the product.
     * @return The product if found, or a 404 not found.
     */
    @GetMapping(value = "/{id}")
    public ResponseEntity<Product> findById(@PathVariable("id") Integer id) {
        Product product = ProductUtils.findProductById(productRepository, id);
        return ResponseEntity.ok(product);
    }

    /**
     * Lists all products.
     *
     * @return The list of products.
     */
    @GetMapping(value = "/")
    public ResponseEntity<List<Product>> listProducts() {
        return ResponseEntity.ok(productRepository.findAll());
    }
}
