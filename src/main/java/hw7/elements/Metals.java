package hw7.elements;

import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;

public class Metals {
    @Css("#metals")
    @JDropdown(expand="div > button > span.caret")
    private Dropdown metals;
    public void selectMetal(String metal) {
        metals.expand();
        metals.select(metal);
    }
    public boolean checkMetal(String metal) {
        return metals.selected(metal);
    }
}
