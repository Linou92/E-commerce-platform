package se.lexicon.E_commerce_platform.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode

public class UserProfile {

    private long id;
    private String nickname;
    private String phoneNumber;
    private String bio;
}
