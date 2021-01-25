package hw6.pages;

import javafx.util.Pair;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class UserTableData extends BasePage{
    private WebDriver driver;
    @FindBy (className = "panel-body-list")
    private WebElement panelBodyList;
    @FindBy(tagName="tbody")
    private WebElement userTable;
    public UserTableData(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public ArrayList<String> getData() {
        ArrayList<String> arr = new ArrayList<>();
        for (WebElement element : userTable.findElements(By.tagName("tr"))) {
            String s = element.getText().replaceAll(" ", "").replaceAll("\n", ":");
            arr.add(s);
        }
        return arr;
    }
    public void selectCheckbox(String checkboxName, String username) throws InterruptedException {
        for (WebElement element : userTable.findElements(By.tagName("tr"))) {
            String s = element.getText().replaceAll(" ", "").replaceAll("\n", ":");
            if (s.contains(username.replace(" ", ""))) {
                element.findElement(By.className("user-descr")).findElement(By.tagName("input")).click();
                break;
            }
        }
    }

    public boolean checkLogs(int number, String text) {
        String logEntry = "";
        int counter = 0;
        for (WebElement elem : panelBodyList.findElements(By.tagName("li"))) {
            logEntry = elem.getText();
            counter++;
        }
        if (counter==number && logEntry.contains(text))
            return true;
        return false;
    }

    public int checkImages() {
        int counter = 0;
        for (WebElement element : userTable.findElements(By.tagName("tr"))) {
            try {
                if (element.findElement(By.tagName("img")) != null)
                    counter++;
            }
            catch(NoSuchElementException ignored) {}
        }
        return counter;
    }
    public int checkUsers() {
        int counter = 0;
        for (WebElement element : userTable.findElements(By.tagName("tr"))) {
            try {
                if (element.findElement(By.tagName("a")) != null)
                    counter++;
            }
            catch(NoSuchElementException ignored) {}
        }
        return counter;
    }
    public int checkDescriptions() {
        int counter = 0;
        for (WebElement element : userTable.findElements(By.tagName("tr"))) {
            try {
                if (element.findElement(By.tagName("span")) != null)
                    counter++;
            }
            catch(NoSuchElementException ignored) {}
        }
        return counter;
    }
    public int checkCheckboxes() {
        int counter = 0;
        for (WebElement element : userTable.findElements(By.tagName("tr"))) {
            try {
                if (element.findElement(By.tagName("input")) != null)
                    counter++;
            }
            catch(NoSuchElementException ignored) {}
        }
        return counter;
    }
}
