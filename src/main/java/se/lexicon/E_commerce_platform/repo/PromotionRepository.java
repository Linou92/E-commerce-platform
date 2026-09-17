package se.lexicon.E_commerce_platform.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import se.lexicon.E_commerce_platform.entity.Promotion;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface PromotionRepository extends JpaRepository<Promotion, Long> {

    @Query("""
            SELECT p 
            FROM Promotion p 
            WHERE p.startDate <= :date
            AND (p.endDate >= :date OR p.endDate IS NULL)
            """)
    List<Promotion> findByActiveOnDate(@Param("date") LocalDate date);

    Optional<Promotion> findByCode(String code);

    List<Promotion> findByStartDateAfter(LocalDate date);

    List<Promotion> findByEndDateBefore(LocalDate date);

    List<Promotion> findByEndDateIsNull();

}
