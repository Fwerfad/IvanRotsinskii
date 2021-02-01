package hw7.elements;

import com.epam.jdi.light.elements.complex.Checklist;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.ui.html.elements.complex.MultiSelector;
import org.openqa.selenium.By;

import java.util.ArrayList;

public class Vegetables {
    @Css("$salad-dropdown")
    private Checklist vegetables;

    public ArrayList<Boolean> selectVegetables(ArrayList<String> veg) {
        vegetables.get(1).webElement.get().findElement(By.tagName("button")).click();
        return null;
    }
}
