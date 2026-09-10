package se.lexicon.E_commerce_platform.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import se.lexicon.E_commerce_platform.entity.UserProfile;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {

    // Find a profile by nickname
    Optional<UserProfile> findByNickname(String nickname);

    // Search profiles by a partial phone number
    List<UserProfile> findByPhoneNumberContaining(String phoneNumber);

    // Find profiles where bio is not null
    List<UserProfile> findByBioIsNotNull();

    // Find profiles by nickname starting with a prefix
    List<UserProfile> findByNicknameStartingWith(String prefix);

    // Count profiles whose phone starts with a specific prefix
    long countByPhoneNumberStartingWith(String prefix);
}
