package hw7.forms;

import com.epam.jdi.light.elements.complex.Checklist;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.complex.MultiSelector;
import com.epam.jdi.light.ui.html.elements.complex.RadioButtons;
import hw7.entities.MetalsAndColorDataEntry;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class JdiMetalsAndColorForm extends Form<MetalsAndColorDataEntry> {
    @UI("[name=custom_radio_odd]")
    public RadioButtons odd;

    @UI("[name=custom_radio_even]")
    private RadioButtons even;

    @Css("#colors")
    @JDropdown(expand="div > button > span.caret")
    private Dropdown colors;

    @Css("#elements-checklist > p > input")
    private Checklist elements;

    @Css("#metals")
    @JDropdown(expand="div > button > span.caret")
    private Dropdown metals;

    @Css("#submit-button")
    private Button submitButton;

    @Css("#salad-dropdown > button")
    private Button vegetablesButton;

    @Css("#salad-dropdown > ul > li > a > input")
    private Checklist vegetables;

    public void submit(MetalsAndColorDataEntry metalsAndColorDataEntry) {
        odd.select(metalsAndColorDataEntry.getOdd());
        even.select(metalsAndColorDataEntry.getEven());
        colors.select(metalsAndColorDataEntry.getColors());
        elements.select(metalsAndColorDataEntry.getElements());
        metals.select(metalsAndColorDataEntry.getMetals());
        vegetablesButton.click();
        vegetables.select("Vegetables");
        vegetables.select(metalsAndColorDataEntry.getVegetables());
        vegetablesButton.click();
        submitButton.click();
    }
}
