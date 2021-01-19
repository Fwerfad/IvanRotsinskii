package hw5.pages;

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
    public void login(String username, String password) {
        userIcon.click();
        name.sendKeys(username);
        this.password.sendKeys(password);
        loginButton.click();
    }
    public String getUserName() {
                return (userName.getText());
    }
    public ArrayList<Boolean> checkNavbarElementsNames(ArrayList<String> names) {
        ArrayList<String> actualNames = new ArrayList<>();
        for (WebElement elem : navbar.findElements(By.tagName("li")))
            actualNames.add(elem.getText());
        return checkOneInAnother(names, actualNames);
    }
    public int getNumberOfBenefitIcons() {
        int counter = 0;
        WebElement root = driver.findElement(By.cssSelector("div[class='row clerafix benefits']"));
        for (WebElement elem : root.findElements(By.className("icons-benefit"))) {
            if (elem.isDisplayed()) {
                counter++;
            }
        }
        return counter;
    }

    public int getNumberOfBenefitTexts() {
        int counter = 0;
        for (WebElement elem : driver.findElements(By.className("benefit"))) {
            if (!elem.findElement(By.className("benefit-txt")).getText().equals("")) {
                counter++;
            }
        }
        return counter;
    }

    public boolean checkIsFrameDisplayed() {
        return frame.isDisplayed();
    }

    public boolean checkIsFrameButtonIsDisplayed() {
        driver.switchTo().frame(frame);
        boolean flag = frameButton.isDisplayed();
        driver.switchTo().defaultContent();
        return flag;
    }

    public ArrayList<Boolean> checkSideBarElements(ArrayList<String> names) {
        ArrayList<String> actualNames = new ArrayList<>();
        for (WebElement elem : sidebar.findElements(By.tagName("li")))
            actualNames.add(elem.getText());
        return checkOneInAnother(names, actualNames);
    }

    public void navToDifferentElementPage() {
        for (WebElement elem : navbar.findElements(By.tagName("li"))) {
            if (elem.getText().equals("SERVICE")) {
                elem.click();
                for (WebElement elem2 : dropdownMenu.findElements(By.tagName("li"))) {
                    if (elem2.getText().equals("DIFFERENT ELEMENTS")) {
                        elem2.findElement(By.tagName("a")).click();
                        break;
                    }
                }
                break;
            }
        }
    }
}
