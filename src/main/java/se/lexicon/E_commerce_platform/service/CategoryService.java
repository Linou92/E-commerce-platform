package se.lexicon.E_commerce_platform.service;

import se.lexicon.E_commerce_platform.dto.CategoryResponse;

import java.util.List;

public interface CategoryService {
    CategoryResponse create(String name);
    List<CategoryResponse> findAll();
}
