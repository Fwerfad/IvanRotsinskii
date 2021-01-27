package hw7.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.settings.WebSettings;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Checkbox;
import hw7.elements.Elements;
import hw7.elements.Summary;
import hw7.entities.DataEntry;
import org.openqa.selenium.WebElement;

import java.util.*;

public class JdiMetalsAndColor  extends WebPage {
    private Summary summary = new Summary();
    private Elements elements = new Elements();



    public void fillData(DataEntry data) {
        ArrayList<Integer> sum = data.getSummary();
        ArrayList<String> elem = data.getElements();
        ArrayList<String> veg = data.getVegetables();
        String col = data.getColor();
        String met = data.getMetals();
        System.out.println(data);
        elements.selectElements(elem);
    }
}


//
//    @Css("#elements-checklist")
//    public Checkbox elements;
//
//    @Css("#salad-dropdown")
//    public MultiSelector vegetables;
//
//    @Css("#colors > div > div > ul")
//    public Dropdown color;
//
//    @Css("#metals > div > div > ul")
//    public Combobox metals;
