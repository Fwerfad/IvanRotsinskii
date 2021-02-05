package hw7.TestContext;

import hw7.entities.MetalsAndColorDataEntry;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class TestContext {

    private static TestContext instance;

    private WebDriver driver;

    private List<MetalsAndColorDataEntry> Data = new ArrayList<>();

    private TestContext() {}

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public List<MetalsAndColorDataEntry> getData() {
        return Data;
    }

    public void addData(MetalsAndColorDataEntry metalsAndColorDataEntry) {
        Data.add(metalsAndColorDataEntry);
    }

    public static TestContext getInstance() {
        if (instance == null) {
            instance = new TestContext();
        }
        return instance;
    }
}