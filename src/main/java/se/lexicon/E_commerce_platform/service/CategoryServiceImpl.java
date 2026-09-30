package se.lexicon.E_commerce_platform.service;

import se.lexicon.E_commerce_platform.dto.CategoryResponse;
import se.lexicon.E_commerce_platform.entity.Category;
import se.lexicon.E_commerce_platform.exception.DuplicateResourceException;
import se.lexicon.E_commerce_platform.mapper.CategoryMapper;
import se.lexicon.E_commerce_platform.repository.CategoryRepository;

import java.util.List;

public class CategoryServiceImpl implements CategoryService{

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public CategoryServiceImpl(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }

    @Override
    public CategoryResponse create(String name){

        if(categoryRepository.existsByNameIgnoreCase(name)){
            throw new DuplicateResourceException("Category " + name + " already exists");
        }

        Category category = new Category();
        category.setName(name);
        Category savedCategory = categoryRepository.save(category);
        return categoryMapper.toResponse(savedCategory);
    }

    @Override
    public List<CategoryResponse> findAll(){
        return categoryRepository.findAll()
                .stream()
                .map(categoryMapper::toResponse)
                .toList();
    }
}
