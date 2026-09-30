package se.lexicon.E_commerce_platform.service;

import se.lexicon.E_commerce_platform.entity.Product;
import se.lexicon.E_commerce_platform.entity.Promotion;

import java.util.List;
import java.util.Optional;

public interface PromotionService {

    List<Promotion> getActivePromotions();
    Optional<Promotion> calculateDiscount(Product product);
}
