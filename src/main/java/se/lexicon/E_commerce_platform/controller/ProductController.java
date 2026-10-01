package se.lexicon.E_commerce_platform.controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import se.lexicon.E_commerce_platform.dto.ProductRequest;
import se.lexicon.E_commerce_platform.dto.ProductResponse;
import se.lexicon.E_commerce_platform.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<ProductResponse> create(@Valid @RequestBody ProductRequest request) {
        ProductResponse productResponse = productService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(productResponse);
    }

    @GetMapping
    public ResponseEntity<List<ProductResponse>> findAll() {
        List<ProductResponse> products = productService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(products);
    }

    @GetMapping("/search")
    public ResponseEntity<List<ProductResponse>> searchByName (@RequestParam String name) {
        List<ProductResponse> products = productService.searchByName(name);
        return ResponseEntity.status(HttpStatus.OK).body(products);
    }
}
