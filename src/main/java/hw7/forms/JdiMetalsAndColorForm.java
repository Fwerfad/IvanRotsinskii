package hw7.forms;

import com.epam.jdi.light.elements.complex.Checklist;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.complex.RadioButtons;
import hw7.entities.MetalsAndColor;

import java.util.HashMap;
import java.util.Map;

public class JdiMetalsAndColorForm extends Form<MetalsAndColor> {
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

    public Map<String, Integer> elemKeys = new HashMap<String, Integer>() {{
        put("Water", 1);
        put("Earth", 2);
        put("Wind", 3);
        put("Fire", 4);
    }};

    private Map<String, Integer> vegKeys = new HashMap<String, Integer>(){{
        put("Cucumber", 1);
        put("Tomato", 2);
        put("Vegetables", 3);
        put("Onion", 4);
    }};



    public void submit(MetalsAndColor metalsAndColorDataEntry) {
        odd.select(metalsAndColorDataEntry.getOdd() / 2 + 1);
        even.select(metalsAndColorDataEntry.getEven() / 2);
        colors.select(metalsAndColorDataEntry.getColor());
        elements.select(metalsAndColorDataEntry.getElements().stream().mapToInt(s -> elemKeys.get(s)).toArray());
        metals.select(metalsAndColorDataEntry.getMetals());
        vegetablesButton.click();
        vegetables.select("Vegetables");
        vegetables.select(metalsAndColorDataEntry.getVegetables().stream().mapToInt(s -> vegKeys.get(s)).toArray());
        vegetablesButton.click();
        submitButton.click();
    }
}
