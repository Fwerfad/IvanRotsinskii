package hw6.steps;

import gherkin.ast.DataTable;
import gherkin.ast.TableCell;
import hw6.context.TestContext;
import hw6.pages.DifferentElementPage;
import hw6.pages.HomePage;
import hw6.pages.UserTableData;
import io.cucumber.java.Transpose;
import io.cucumber.java.en.When;
import java.util.ArrayList;
import java.util.List;

public class ActionStep{

    @When("I login as user {string}")
    public void i_login_as_user(String name) {
        String username = "Roman", password = "Jdi1234";
        TestContext.getInstance().setUserName(new HomePage(TestContext.getInstance().getDriver()).login(username, password).getUserName());
    }
    @When("I click on {string} button in Header")
    public void i_click_on_button_in_header(String name1) {
        new HomePage(TestContext.getInstance().getDriver()).openServiceDropdown();
    }
    @When("I click on {string} button in Service dropdown")
    public void i_click_on_button_in_dropdown(String name1) {
        new HomePage(TestContext.getInstance().getDriver()).navToDifferentElementPage();

    }
    @When("I select checkboxes")
    public void selectCheckboxes(@Transpose List<String> list){
        new DifferentElementPage(TestContext.getInstance().getDriver()).switchCheckboxes(new ArrayList<String>(list));
    }
    @When("I select radio {string}")
    public void i_select_radio(String name){
        new DifferentElementPage(TestContext.getInstance().getDriver()).selectRadio(name);
    }
    @When("I select in dropdown {string}")
    public void i_select_in_dropdown(String name) {
        new DifferentElementPage(TestContext.getInstance().getDriver()).selectInDropdown(name);
    }

    @When("I click on Service button in Header")
    public void i_click_on_Service_button() {
        new HomePage(TestContext.getInstance().getDriver()).clickServiceButton();
    }

    @When("I click on User Table button in Service dropdown")
    public void i_click_on_User_table_button() {
        new HomePage(TestContext.getInstance().getDriver()).clickButtonInServiceDropdown();
    }

    @When("I select {string} checkbox for {string}")
    public void i_select_checkbox_for(String checkboxName, String userName) throws InterruptedException {
        new UserTableData(TestContext.getInstance().getDriver()).selectCheckbox(checkboxName, userName);
    }
}
