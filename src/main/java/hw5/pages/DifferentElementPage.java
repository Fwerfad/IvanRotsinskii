package hw5.pages;

import javafx.util.Pair;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class DifferentElementPage extends BasePage{
    private WebDriver driver;
    @FindBys(@FindBy (className = "label-checkbox"))
    private List<WebElement> labelsCheckbox;
    @FindBys(@FindBy (className = "label-radio"))
    private List<WebElement> labelsRadio;
    @FindBy (className = "panel-body-list")
    private WebElement panelBodyList;
    @FindBy (tagName = "select")
    private WebElement select;

    public DifferentElementPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public ArrayList<Boolean> switchCheckboxes(ArrayList<String> names) {
        ArrayList<Boolean> arr = new ArrayList<>();
        ArrayList<String> actualNames = new ArrayList<>();
        for (WebElement elem : labelsCheckbox) {
            actualNames.add(elem.getText());
            if (names.contains(elem.getText()))
                elem.click();
        }
        return checkOneInAnother(names, actualNames);
    }

    public boolean selectRadio(String name) {
        for (WebElement elem : labelsRadio) {
            if (elem.getText().equals(name)) {
                elem.findElement(By.tagName("input")).click();
                return true;
            }
        }
        return false;
    }

    public boolean selectInDropdown(String name) {
        for (WebElement elem : select.findElements(By.tagName("option"))) {
            if (elem.getText().equals(name)) {
                elem.click();
                return true;
            }
        }
        return false;
    }

    public ArrayList<Boolean> checkLogs(ArrayList<Pair<String, String>> names) {
        ArrayList<Pair<String, String>> actualNames = new ArrayList<>();
        for (WebElement elem : panelBodyList.findElements(By.tagName("li"))) {
            String[] str = elem.getText().split(" ");
            actualNames.add(new Pair<>(str[1], str[5]));
        }
        return checkOneInAnother(names, actualNames);
    }
}
