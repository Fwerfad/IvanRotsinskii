package hw6.steps;

import hw6.context.TestContext;
import hw6.pages.HomePage;
import io.cucumber.java.en.Given;

public class ModelSteps {

    @Given("I open JDI GitHub site")
    public void I_open_JDI_GitHub_Site() {
        new HomePage(TestContext.getInstance().getDriver()).open();
    }

//    @Given("I login as user {string} {string}")
//    public void i_login_as_user(String name, String password) {
//        TestContext.getInstance().setUserName(new HomePage(TestContext.getInstance().getDriver()).login(name, password).getUserName());
//    }
}
