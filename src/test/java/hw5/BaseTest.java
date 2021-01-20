package hw5;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected WebDriver driver;
    @BeforeClass
    @Step("Настройка вебдрайвера")
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }
    @BeforeMethod
    @Step("Инициализация вебдрайвера")
    public void setupTest(ITestContext testContext) {
        this.driver = new ChromeDriver();
        testContext.setAttribute("driver", driver);
    }
    @AfterMethod
    @Step("Завершение работы")
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
