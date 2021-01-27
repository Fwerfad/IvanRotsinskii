package hw7.pages;

import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.XPath;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Text;
import hw7.entities.User;
import hw7.forms.JdiLoginForm;

import static hw7.entities.User.ROMAN;

public class JdiHomePage extends WebPage {
    @Css("#user-name")
    public Text userName;

    @Css("#user-icon")
    private Button userIcon;

    @Css("ul.uui-navigation.nav.navbar-nav.m-l8 > li:nth-child(4) > a")
    private Button metalsAndColors;

    private JdiLoginForm jdiLoginForm;

    public void login(User user) {
        userIcon.click();
        jdiLoginForm.login(user);
    }

    public void checkUserLoggedIn() {
        userName.is().text(ROMAN.getFullName());
    }

    public void navToMetalsAndColors() {
        metalsAndColors.click();
    }

    public String getUserName() {
        return userName.getValue();
    }
}
