package hw6.context;

import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestContext {

    private static TestContext instance;

    private WebDriver driver;

    private List<String> testData = new ArrayList<>();

    private String userName;

    private ArrayList<ArrayList<String>> userTableData = new ArrayList<>();

    private TestContext() {
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public List<String> getTestData() {
        return testData;
    }

    public void setTestData(List<String> testData) {
        this.testData = testData;
    }

    public String getUserName() {return userName;}
    public void setUserName(String userName) {this.userName = userName;}

    public void setUserTableData(ArrayList<String> data) {
        ArrayList<ArrayList<String>> prettifiedData = new ArrayList<>();
        for (String s : data) {
            String temp = "";
            ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(s.split(":")));
            arrayList.remove(1);
            if (arrayList.size() > 7)
                if (arrayList.get(6).equals("somedescription")) {
                    arrayList.set(6, arrayList.get(5) + "somedescription");
                }
            prettifiedData.add(arrayList);
        }
        this.userTableData = prettifiedData;
    }

    public ArrayList<ArrayList<String>> getUserTableData() {
        return userTableData;
    }

    public void addDataToUserTable(ArrayList<String> data) {
        userTableData.add(data);
    }

    public static TestContext getInstance() {
        if (instance == null) {
            instance = new TestContext();
        }
        return instance;
    }
}
