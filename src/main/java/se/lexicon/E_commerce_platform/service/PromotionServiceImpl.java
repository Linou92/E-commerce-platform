package se.lexicon.E_commerce_platform.service;

import org.springframework.stereotype.Service;
import se.lexicon.E_commerce_platform.entity.Product;
import se.lexicon.E_commerce_platform.entity.Promotion;
import se.lexicon.E_commerce_platform.repository.PromotionRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PromotionServiceImpl implements PromotionService {

    private final PromotionRepository promotionRepository;

    public PromotionServiceImpl(PromotionRepository promotionRepository) {
        this.promotionRepository = promotionRepository;
    }

    @Override
    public List<Promotion> getActivePromotions() {

        LocalDate today = LocalDate.now();
        return promotionRepository.findByActiveOnDate(today);
    }

    @Override
    public Optional<Promotion> calculateDiscount(Product product) {

        LocalDate today = LocalDate.now();
        List<Promotion> activePromotions = promotionRepository.findByActiveOnDate(today);
        return activePromotions.stream()
                .filter(promotion -> promotion.getProducts().contains(product))
                .findFirst();
    }
}
