package hw5.utils;

import io.qameta.allure.Step;
import hw5.entities.User;
import lombok.NonNull;
import lombok.experimental.UtilityClass;

@UtilityClass
public class LoginUtils {
    public final User DEFAULT_USER = new User("Alice", "pReTtyGoodP@ssw0rt");
    public final User EMPTY_USER = new User("", "");

    @Step("Typing username")
    public void typeLogin(@NonNull final String username) {
        //nop
    }

    @Step("Typing user password")
    public void typePassword(@NonNull final String password) {
        //nop
    }


    @Step("Logging in using {user.name} : {user.password}")
    public void login(@NonNull final User user) {
        if (EMPTY_USER.equals(user)) {
            throw new IllegalArgumentException("Empty user test");
        }
        typeLogin(user.getName());
        typePassword(user.getPassword());
    }

    @Step("Login using Default user")
    public void loginWithDefaultUser() {
        login(DEFAULT_USER);
    }

    @Step
    public void findLogoutButton() {
        //nop
    }

    @Step("Clicking Logout button  and some noisy words")
    public void clickLogoutButton() {
        //nop
    }

    public void logout() {
        findLogoutButton();
        clickLogoutButton();
    }
}
