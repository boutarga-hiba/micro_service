package net.youssfi.inventoryservice.web;

import net.youssfi.inventoryservice.entities.Product;
import net.youssfi.inventoryservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductRestController {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/getAllProducts")
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable String id) {
        return productRepository.findById(id).orElse(null);
    }

    @PostMapping("/saveProduct")
    public Product createProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable String id, @RequestBody Product product) {
        Optional<Product> existing = productRepository.findById(id);
        if (existing.isPresent()) {
            product.setId(id);
            return productRepository.save(product);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable String id) {
        productRepository.deleteById(id);
    }
} 