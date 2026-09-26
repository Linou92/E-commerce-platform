package se.lexicon.E_commerce_platform.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import se.lexicon.E_commerce_platform.entity.Category;
import se.lexicon.E_commerce_platform.entity.Product;
import se.lexicon.E_commerce_platform.repository.CategoryRepository;
import se.lexicon.E_commerce_platform.repository.ProductRepository;

import java.math.BigDecimal;
import java.util.List;

@Component
public class DataSeeder implements CommandLineRunner {

    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    public DataSeeder(CategoryRepository categoryRepository, ProductRepository productRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        // Create categories first
        Category electronics = createCategoryIfNotExists("Electronics");
        Category books = createCategoryIfNotExists("Books");
        Category clothing = createCategoryIfNotExists("Clothing");

        // Create products after categories exist
        createProductIfNotExists(
                "Wireless Headphones",
                new BigDecimal("799.00"),
                List.of("https://example.com/headphones.jpg"),
                electronics
        );

        createProductIfNotExists(
                "Java Programming Book",
                new BigDecimal("499.00"),
                List.of("https://example.com/java-book.jpg"),
                books
        );

        createProductIfNotExists(
                "T-Shirt",
                new BigDecimal("199.00"),
                List.of("https://example.com/tshirt.jpg"),
                clothing
        );
    }


    private Category createCategoryIfNotExists(String name) {

        return categoryRepository.findByNameIgnoreCase(name)
                .orElseGet(() -> {
                    Category category = new Category();
                    category.setName(name);
                    return categoryRepository.save(category);
                });
    }

    private void createProductIfNotExists(
            String name,
            BigDecimal price,
            List<String> imageUrls,
            Category category) {

        if (!productRepository.existsByName(name)) {

            Product product = new Product();
            product.setName(name);
            product.setPrice(price);
            product.setImageUrls(imageUrls);
            product.setCategory(category);

            productRepository.save(product);
        }
    }
}
