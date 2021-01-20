package hw5.steps;

import hw5.pages.DifferentElementPage;
import hw5.pages.HomePage;
import org.openqa.selenium.WebDriver;

public abstract class AbstractStep {
    protected WebDriver driver;
    protected HomePage homePage;
    protected DifferentElementPage differentElementPage;
    public AbstractStep(WebDriver driver, String url) {
        this.driver = driver;
        driver.get(url);
        homePage = new HomePage(driver);
        differentElementPage = new DifferentElementPage(driver);
    }
}
