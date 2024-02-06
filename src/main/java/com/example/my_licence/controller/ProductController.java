package com.example.my_licence.controller;

import com.example.my_licence.Services.ProductService;
import com.example.my_licence.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/add")
    public ResponseEntity<Product> addProduct(
            @RequestParam("productName") String productName,
            @RequestParam("productPrice") double productPrice,
            @RequestParam("image") MultipartFile image) {

        Product product = new Product();
        product.setProductName(productName);
        product.setProductPrice(productPrice);

        try {
            product.setImageFilename(product.getImageFilename());
        } catch (Exception e) {
            // Handle exception appropriately
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        Product savedProduct = productService.addProduct(product);
        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Optional<Product> productOptional = productService.getProductById(id);
        return productOptional.map(product -> new ResponseEntity<>(product, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Product> updateProduct(
            @PathVariable Long id,
            @RequestParam("productName") String productName,
            @RequestParam("productPrice") double productPrice,
            @RequestParam("image") MultipartFile image) {

        Product updatedProduct = new Product();
        updatedProduct.setProductName(productName);
        updatedProduct.setProductPrice(productPrice);

        try {
            updatedProduct.setImageFilename(updatedProduct.getImageFilename());
        } catch (Exception e) {
            // Handle exception appropriately
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        Product result = productService.updateProduct(id, updatedProduct);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
        try {
            productService.deleteProduct(id);
            return new ResponseEntity<>("Product deleted successfully", HttpStatus.OK);
        } catch (Exception e) {
            // Handle exception appropriately
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

}
