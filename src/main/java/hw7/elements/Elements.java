package hw7.elements;

import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.ui.html.elements.common.Checkbox;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Elements extends Form {
    @Css("#g1")
    private Checkbox water;
    @Css("#g2")
    private Checkbox earth;
    @Css("#g3")
    private Checkbox wind;
    @Css("#g4")
    private Checkbox fire;
    private Map<String, Checkbox> elements;

    public Elements() {
        elements = new HashMap<String, Checkbox>();
        elements.put("Water", water);
        elements.put("Fire", fire);
        elements.put("Earth", earth);
        elements.put("Wind", wind);
    }
    public void selectElements(ArrayList<String> elem) {
        for (String el : elem) {
            elements.get(el).check();
        }
    }
}
