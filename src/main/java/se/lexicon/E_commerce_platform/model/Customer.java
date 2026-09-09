package se.lexicon.E_commerce_platform.model;

import lombok.*;

import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode

public class Customer {

    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private Instant createdAt;
    private Address address;
    private UserProfile profile;

}
