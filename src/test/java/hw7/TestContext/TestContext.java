package hw7.TestContext;

import hw7.entities.DataEntry;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestContext {

    private static TestContext instance;

    private WebDriver driver;

    private List<DataEntry> Data = new ArrayList<>();

    private TestContext() {}

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public List<DataEntry> getData() {
        return Data;
    }

    public void addData(DataEntry dataEntry) {
        Data.add(dataEntry);
    }

    public static TestContext getInstance() {
        if (instance == null) {
            instance = new TestContext();
        }
        return instance;
    }
}