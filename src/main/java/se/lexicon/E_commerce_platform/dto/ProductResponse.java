package se.lexicon.E_commerce_platform.dto;

import java.math.BigDecimal;

public record ProductResponse(
        Long id,
        String name,
        BigDecimal price,
        String categoryName
) {
}
