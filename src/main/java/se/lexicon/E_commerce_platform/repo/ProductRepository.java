package se.lexicon.E_commerce_platform.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import se.lexicon.E_commerce_platform.entity.Product;

import java.math.BigDecimal;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByCategoryName(String name);

    List<Product> findByPriceBetween(BigDecimal minPrice, BigDecimal maxPrice);

    List<Product> findByNameContainingIgnoreCase(String keyword);

    List<Product> findByPriceLessThan(BigDecimal price);

    List<Product> findAllByOrderByPriceAsc();

    List<Product> findAllByOrderByPriceDesc();

    long countByCategoryName(String name);

    List<Product> findByCategoryId(Long categoryId);
}
