package hw6.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;

public class HomePage extends BasePage {
    private WebDriver driver;
    @FindBy(id = "user-icon")
    private WebElement userIcon;
    @FindBy(id = "name")
    private WebElement name;
    @FindBy(id = "password")
    private WebElement password;
    @FindBy(id = "login-button")
    private WebElement loginButton;
    @FindBy(id = "user-name")
    private WebElement userName;
    @FindBy(className = "navbar-nav")
    private WebElement navbar;
    @FindBy(id = "frame")
    private WebElement frame;
    @FindBy(id = "frame-button")
    private WebElement frameButton;
    @FindBy(className = "sidebar-menu")
    private WebElement sidebar;
    @FindBy(className = "dropdown-menu")
    private WebElement dropdownMenu;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public HomePage login(String username, String password) {
        userIcon.click();
        name.sendKeys(username);
        this.password.sendKeys(password);
        loginButton.click();
        return this;
    }
    public void open() {
        driver.get("https://jdi-testing.github.io/jdi-light/index.html");
        driver.manage().window().maximize();
    }
    public String getUserName() {
                return (userName.getText());
    }

    public void clickServiceButton() {
        for (WebElement elem : navbar.findElements(By.tagName("li"))) {
            if (elem.getText().equals("SERVICE")) {
                elem.click();
                break;
            }
        }
    }

    public void clickButtonInServiceDropdown() {
        for (WebElement elem2 : dropdownMenu.findElements(By.tagName("li"))) {
            if (elem2.getText().equals("USER TABLE")) {
                elem2.findElement(By.tagName("a")).click();
                break;
            }
        }
    }

    public void openServiceDropdown() {
        for (WebElement elem : navbar.findElements(By.tagName("li"))) {
            if (elem.getText().equals("SERVICE")) {
                elem.click();
                break;
            }
        }
    }
    public void navToDifferentElementPage() {
        for (WebElement elem2 : dropdownMenu.findElements(By.tagName("li"))) {
            if (elem2.getText().equals("DIFFERENT ELEMENTS")) {
                elem2.findElement(By.tagName("a")).click();
                break;
            }
        }
    }
}
