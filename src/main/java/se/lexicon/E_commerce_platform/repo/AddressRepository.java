package se.lexicon.E_commerce_platform.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import se.lexicon.E_commerce_platform.entity.Address;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Long> {

    // Find all addresses in a specific zip code
    List<Address> findAllByZipCode(String zipCode);

    // Find all addresses in a specific city
    List<Address> findAllByCity(String city);

    // Find addresses by street name
    List<Address> findByStreetContainingIgnoreCase(String street);

    // Count addresses/customers in a given zip code
    long countByZipCode(String zipCode);

    // Find addresses where zip code starts with a prefix
    List<Address> findByZipCodeStartingWith(String prefix);
}
