package se.lexicon.E_commerce_platform.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public record ProductRequest(

        @NotBlank
        @Size(max = 150)
        String name,

        @NotNull
        @Positive
        BigDecimal price,

        @NotNull
        Long categoryId
) {
}
