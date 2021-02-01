package hw7.elements;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.Checklist;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.ui.html.elements.common.Checkbox;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Elements extends Form {
//    @Css("#g1")
//    private Checkbox water;
//    @Css("#g2")
//    private Checkbox earth;
//    @Css("#g3")
//    private Checkbox wind;
//    @Css("#g4")
//    private Checkbox fire;
    @Css("#elements-checklist")
    private Checklist elements;
    public Map<String, Integer> keys = new HashMap<String, Integer>() {{
        put("Water", 0);
        put("Earth", 1);
        put("Wind", 2);
        put("Fire", 3);
    }};
    public void selectElements(ArrayList<String> elem) {
        for (String s : elem) {
            WebElement label = elements.get(1).webElement.get().findElements(By.tagName("label")).get(keys.get(s));
            if (label.getText().equals(s))
                label.click();
        }
    }
    public ArrayList<Boolean> checkElements(ArrayList<String> elem) {
        ArrayList<Boolean> result = new ArrayList<>();
        for (String s : elem) {
            WebElement label = elements.get(1).webElement.get().findElements(By.tagName("label")).get(keys.get(s));
            WebElement element = elements.get(1).webElement.get().findElements(By.tagName("input")).get(keys.get(s));
            if (label.getText().equals(s))
                result.add(element.isSelected());
            else
                result.add(false);
        }
        return result;
    }

    public void reset(ArrayList<String> elem) {
        for (String s : elem) {
            WebElement label = elements.get(1).webElement.get().findElements(By.tagName("label")).get(keys.get(s));
            WebElement element = elements.get(1).webElement.get().findElements(By.tagName("input")).get(keys.get(s));
            if (label.getText().equals(s)) {
                boolean temp = element.isSelected();
                if (temp)
                    label.click();
            }
        }
    }
}
