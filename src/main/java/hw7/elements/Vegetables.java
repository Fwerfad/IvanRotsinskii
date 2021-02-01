package hw7.elements;

import com.epam.jdi.light.elements.complex.Checklist;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Vegetables {
    @Css("#salad-dropdown")
    private Checklist vegetables;
    private Map<String, Integer> keys = new HashMap<String, Integer>(){{
        put("Cucumber", 0);
        put("Tomato", 1);
        put("Vegetables", 2);
        put("Onion", 3);
    }
    };

    public void selectVegetables(ArrayList<String> veg) {
        vegetables.get(1).webElement.get().findElement(By.tagName("button")).click();
        for (String s : veg) {
            WebElement label = vegetables.get(1).webElement.get().findElements(By.tagName("label")).get(keys.get(s));
            WebElement element = vegetables.get(1).webElement.get().findElements(By.tagName("input")).get(keys.get(s));
            if (!element.isSelected())
                label.click();
        }
    }

    public ArrayList<Boolean> checkVegetables(ArrayList<String> veg) {
        ArrayList<Boolean> result = new ArrayList<>();
        for (String s : veg) {
            WebElement label = vegetables.get(1).webElement.get().findElements(By.tagName("label")).get(keys.get(s));
            WebElement element = vegetables.get(1).webElement.get().findElements(By.tagName("input")).get(keys.get(s));
            result.add(element.isSelected());
        }
        vegetables.get(1).webElement.get().findElement(By.tagName("button")).click();
        return result;
    }

    public void reset(ArrayList<String> veg) {
        vegetables.get(1).webElement.get().findElement(By.tagName("button")).click();
        for (String s : veg) {
            WebElement label = vegetables.get(1).webElement.get().findElements(By.tagName("label")).get(keys.get(s));
            WebElement element = vegetables.get(1).webElement.get().findElements(By.tagName("input")).get(keys.get(s));
            if (element.isSelected())
                label.click();
        }
        vegetables.get(1).webElement.get().findElement(By.tagName("button")).click();
    }
}
