package se.lexicon.E_commerce_platform.mapper;

import org.springframework.stereotype.Component;
import se.lexicon.E_commerce_platform.dto.CategoryResponse;
import se.lexicon.E_commerce_platform.entity.Category;

@Component
public class CategoryMapper {

    public CategoryResponse toResponse(Category category) {
        return new CategoryResponse(category.getId(), category.getName());
    }
}
