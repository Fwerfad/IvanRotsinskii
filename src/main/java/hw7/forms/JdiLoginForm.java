package hw7.forms;

import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.TextField;
import hw7.entities.User;

public class JdiLoginForm extends Form<User> {
    @Css("#name")
    private TextField name;

    @Css("#password")
    private TextField password;

    @Css("#login-button")
    private Button submit;
}
