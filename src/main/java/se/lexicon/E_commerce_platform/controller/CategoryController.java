package se.lexicon.E_commerce_platform.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.lexicon.E_commerce_platform.dto.CategoryResponse;
import se.lexicon.E_commerce_platform.service.CategoryService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public ResponseEntity<CategoryResponse> create (@RequestParam String name){
        CategoryResponse response = categoryService.create (name);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<CategoryResponse>> findAll(){
        List<CategoryResponse> response = categoryService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
