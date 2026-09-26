package se.lexicon.E_commerce_platform.dto;

public record CustomerResponse(
        Long id,
        String fullName,
        String email,
        AddressResponse addressResponse
) {
}
