package hw7.pages;

import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Text;
import hw7.entities.User;
import hw7.forms.JdiLoginForm;

public class JdiHomePage extends WebPage {

    @Css(".benefit")
    private WebList benefits;

    @Css("#user-name")
    public Text userName;

    @Css("#user-icon")
    private Button userIcon;

    private JdiLoginForm jdiLoginForm;

    public int getBenefitsCount() {
        return benefits.size();
    }

    public void login(User user) {
        userIcon.click();
        jdiLoginForm.login(user);
    }

    public String getUserName() {
        return userName.getValue();
    }
}
