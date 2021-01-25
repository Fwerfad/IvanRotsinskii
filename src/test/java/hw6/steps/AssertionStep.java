package hw6.steps;

import gherkin.ast.DataTable;
import hw6.context.TestContext;
import hw6.pages.DifferentElementPage;
import hw6.pages.UserTableData;
import io.cucumber.java.Transpose;
import io.cucumber.java.en.Then;
import javafx.util.Pair;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class AssertionStep {

    @Then("UserName should be {string}")
    public void checkUserName(String name) {
        Assert.assertEquals(name, TestContext.getInstance().getUserName(), "Login is not valid");
    }
    @Then("Title is {string}")
    public void checkTitle(String name) {
        Assert.assertEquals(TestContext.getInstance().getDriver().getTitle(), name, "Wrong page");
    }
    @Then("There should be {int} rows in logs, each corresponding to one of the previous actions")
    public void checkLogs(int number, @Transpose List<String> entities){
        ArrayList<Pair<String, String>> arr = new ArrayList<>();
        for (String s : entities) {
            String[] tempArr = s.split(":");
            arr.add(new Pair<String, String>(tempArr[0], tempArr[1]));
        }
        Assert.assertFalse(new DifferentElementPage(TestContext.getInstance().getDriver()).checkLogs(arr).contains(false), "Something wrong with logs");
    }
    @Then("Close the browser")
    public void closeBrowser() {
        TestContext.getInstance().getDriver().close();
    }

    @Then("\"User Table\" page should be opened")
    public void checkUserTable(){
        Assert.assertEquals(TestContext.getInstance().getDriver().getTitle(), "User Table");
        TestContext.getInstance().setUserTableData(new UserTableData(TestContext.getInstance().getDriver()).getData());
    }

    @Then("{int} Number Type Dropdowns should be displayed on Users Table on User Table Page")
    public void number_Type_Dropdowns_should_be_displayed_on_Users_Table_on_User_Table_Page(Integer int1) {

        Assert.assertTrue(new UserTableData(TestContext.getInstance().getDriver()).checkImages() == int1, "wrong number type");
    }

    @Then("{int} Usernames should be displayed on Users Table on User Table Page")
    public void usernames_should_be_displayed_on_Users_Table_on_User_Table_Page(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertTrue(new UserTableData(TestContext.getInstance().getDriver()).checkUsers() == int1, "wrong number of users");
    }

    @Then("{int} Description texts under images should be displayed on Users Table on User Table Page")
    public void description_texts_under_images_should_be_displayed_on_Users_Table_on_User_Table_Page(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertTrue(new UserTableData(TestContext.getInstance().getDriver()).checkDescriptions() == int1, "wrong number of images");
    }

    @Then("{int} checkboxes should be displayed on Users Table on User Table Page")
    public void checkboxes_should_be_displayed_on_Users_Table_on_User_Table_Page(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertTrue(new UserTableData(TestContext.getInstance().getDriver()).checkCheckboxes() == int1, "wrong number of checkboxes");
    }

    @Then("User table should contain following values:")
    public void user_table_should_contain_following_values(List<List<String>> dataTable) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.
        ArrayList<Boolean> results = new ArrayList<>();
        ArrayList<ArrayList<String>> userTableData = TestContext.getInstance().getUserTableData();
        for (List list : dataTable) {
            if (!list.contains("Number")) {
                int index = Integer.parseInt((String) list.get(0)) - 1;
                ArrayList<String> arr = userTableData.get(index);
                if (arr.contains(list.get(1).toString().replace(" ", ""))
                        && arr.contains(list.get(2).toString().replace(" ", "")))
                    results.add(true);
                else
                    results.add(false);
            }
        }
        Assert.assertFalse(results.contains(false), "unexpected data in tables");
    }

    @Then("droplist should contain values in column Type for user {}")
    public void droplist_should_contain_values_in_column_Type_for_user_Roman(String name) {
        // Write code here that turns the phrase above into concrete actions
        ArrayList<ArrayList<String>> userTableData = TestContext.getInstance().getUserTableData();
        boolean result = false;
        for (ArrayList<String> arr : userTableData) {
            if (arr.contains(name)) {
                result = true;
            }
        }
        Assert.assertTrue(result, "data for " + name + " is missing");
    }

    @Then("{int} log row has {string} text in log section")
    public void checkLogs(int number, String text) {
        Assert.assertTrue( new UserTableData(TestContext.getInstance().getDriver()).checkLogs(number, text), "there is an error in log display");
    }

}
