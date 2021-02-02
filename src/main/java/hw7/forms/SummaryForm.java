package hw7.forms;

import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.ui.html.elements.complex.RadioButtons;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class SummaryForm extends Form {

    @Css("#odds-selector")
    private RadioButtons odd;

    @Css("#even-selector")
    private RadioButtons even;

    private Map<Integer, Integer> keys = new HashMap<Integer, Integer>(){{
        put(1, 0);
        put(2, 0);
        put(3, 1);
        put(4, 1);
        put(5, 2);
        put(6, 2);
        put(7, 3);
        put(8, 3);
    }};

    public void selectSummary(ArrayList<Integer> indexes) {
        for (int i : indexes) {
            if (keys.containsKey(i)) {
                int evenity = i % 2;
                int index = keys.get(i);
                WebElement element;
                if (evenity == 0) {
                    element = even.get(1).webElement.get().findElements(By.tagName("label")).get(index);
                }
                else {
                    element = odd.get(1).webElement.get().findElements(By.tagName("label")).get(index);
                }
                element.click();
            }
        }
    }

    public ArrayList<Boolean> checkSummary(ArrayList<Integer> indexes) {
        ArrayList<Boolean> result = new ArrayList<>();
        for (int i : indexes) {
            if (!keys.containsKey(i)) {
                result.add(false);
            }
            else {
                int evenity = i % 2;
                int index = keys.get(i);
                WebElement element;
                if (evenity == 0) {
                    element = even.get(1).webElement.get().findElements(By.tagName("input")).get(index);
                }
                else {
                    element = odd.get(1).webElement.get().findElements(By.tagName("input")).get(index);
                }
                result.add(element.isSelected());
            }
        }
        return result;
    }

}
