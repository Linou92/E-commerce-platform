package se.lexicon.E_commerce_platform.mapper;

import org.springframework.stereotype.Component;
import se.lexicon.E_commerce_platform.dto.ProductRequest;
import se.lexicon.E_commerce_platform.dto.ProductResponse;
import se.lexicon.E_commerce_platform.entity.Category;
import se.lexicon.E_commerce_platform.entity.Product;

@Component
public class ProductMapper {

    public ProductResponse toResponse(Product product) {
        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getPrice(),
                product.getCategory().getName()
        );
    }

    public Product toEntity(ProductRequest request, Category category) {

        Product product = new Product();
        product.setName(request.name());
        product.setPrice(request.price());
        product.setCategory(category);

        return product;
    }
}
