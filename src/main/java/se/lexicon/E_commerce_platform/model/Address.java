package se.lexicon.E_commerce_platform.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode

public class Address {

    private long id;
    private String street;
    private String city;
    private String zipCode;
}
