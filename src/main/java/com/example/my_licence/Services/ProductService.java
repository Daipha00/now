package com.example.my_licence.Services;

import com.example.my_licence.Repository.ProductRepository;
import com.example.my_licence.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product addProduct(Product product) {

        return productRepository.save(product);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    public Product updateProduct(Long id, Product product) {
        Product existingProduct = productRepository.findById(id).orElse(null);
        if (existingProduct != null) {
            existingProduct.setProductName(product.getProductName());
            existingProduct.setProductPrice(product.getProductPrice());
            existingProduct.setImageFilename(product.getImageFilename());

            productRepository.save(existingProduct);
        }
        return existingProduct;
    }

    public void deleteProduct(Long id) {
        // Add validation or additional logic if needed
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
        } else {
            // Handle the case where the product with the given ID doesn't exist
            throw new RuntimeException("Product not found with id: " + id);
        }
    }
}
