package hw7.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.settings.WebSettings;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Checkbox;
import hw7.elements.*;
import hw7.entities.DataEntry;
import org.openqa.selenium.WebElement;

import java.util.*;

public class JdiMetalsAndColor  extends WebPage {
    private Summary summary = new Summary();
    private Elements elements = new Elements();
    private Colors colors = new Colors();
    private Metals metals = new Metals();
    private Vegetables vegetables = new Vegetables();
    private ResultForm resultForm = new ResultForm();


    private void runTests(DataEntry data) {
        summary.selectSummary(data.getSummary());
        elements.selectElements(data.getElements());
        metals.selectMetal(data.getMetals());
        colors.selectColor(data.getColor());
        vegetables.selectVegetables(data.getVegetables());
    }

    private void reset(DataEntry data) {
        vegetables.reset(data.getVegetables());
        elements.reset(data.getElements());
    }

    public Map<String, Boolean> fillData(DataEntry data) {
        this.runTests(data);
        ArrayList<Boolean> elementResult = (elements.checkElements(data.getElements()));
        ArrayList<Boolean> summaryResult = summary.checkSummary(data.getSummary());
        ArrayList<Boolean> vegetableResult = vegetables.checkVegetables(data.getVegetables());
        boolean metalResult = metals.checkMetal(data.getMetals());
        boolean colorsResult = colors.checkColor(data.getColor());
        this.reset(data);
        Map<String, Boolean> wholeResult = new HashMap<>();
        wholeResult.put("Summary", !summaryResult.contains(false));
        wholeResult.put("Elements", !elementResult.contains(false));
        wholeResult.put("Vegetable", !vegetableResult.contains(false));
        wholeResult.put("Color", colorsResult);
        wholeResult.put("Metal", metalResult);
        return wholeResult;
    }

    public Map<String, String> checkSubmission(DataEntry data) {
        this.runTests(data);
        Map<String, String> actualData = resultForm.getData();
        this.reset(data);
        return actualData;
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
