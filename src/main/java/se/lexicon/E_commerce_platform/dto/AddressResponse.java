package se.lexicon.E_commerce_platform.dto;

public record AddressResponse(
        Long id,
        String street,
        String city,
        String zipCode
) {
}
