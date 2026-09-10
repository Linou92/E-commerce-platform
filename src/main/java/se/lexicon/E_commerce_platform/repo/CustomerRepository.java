package se.lexicon.E_commerce_platform.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import se.lexicon.E_commerce_platform.entity.Customer;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    // Find a customer by their unique email
    Optional<Customer> findByEmail(String email);

    // Find customers by last name (case-insensitive)
    List<Customer> findByLastNameIgnoreCase(String lastName);

    // Find customers living in a specific city
    List<Customer> findByAddressCity(String city);

    // Find customers whose email contains a given keyword
    List<Customer> findByEmailContainingIgnoreCase(String keyword);

    // Find customers created after a specific date
    List<Customer> findByCreatedAtAfter(Instant date);

    // Find customers created between two dates
    List<Customer> findByCreatedAtBetween(Instant start, Instant end);

    // Count how many customers live in a specific city
    long countByAddressCity(String city);

    // Check if a customer exists by email
    boolean existsByEmail(String email);
}
