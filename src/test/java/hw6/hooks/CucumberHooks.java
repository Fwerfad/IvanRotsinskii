package hw6.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import hw6.context.TestContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CucumberHooks {

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        TestContext.getInstance().setDriver(driver);
    }

    @After
    public void tearDown() {
        TestContext.getInstance().getDriver().quit();
        TestContext.getInstance().getTestData().clear();
    }
}