package hw7.elements;

import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;

import java.util.HashMap;
import java.util.Map;

public class Colors {
    @Css("#colors")
    @JDropdown(expand="div > button > span.caret")
    private Dropdown colors;
    public void selectColor(String color) {
        colors.expand();
        colors.select(color);
    }
    public boolean checkColor(String color) {
        return colors.selected(color);
    }
}
