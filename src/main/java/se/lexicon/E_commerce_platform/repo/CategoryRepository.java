package se.lexicon.E_commerce_platform.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import se.lexicon.E_commerce_platform.entity.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    Optional<Category> findByNameIgnoreCase(String name);

    boolean existsByNameIgnoreCase(String name);

    List<Category> findByNameContainingIgnoreCase(String keyword);

    long count();
}
