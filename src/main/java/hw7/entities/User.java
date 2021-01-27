package hw7.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class User {

    public static User ROMAN = new User("Roman", "Jdi1234", "ROMAN IOVLEV");

    private String name;
    private String password;
    private String fullName;
}
