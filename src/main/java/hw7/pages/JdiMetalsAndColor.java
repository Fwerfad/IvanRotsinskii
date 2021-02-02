package hw7.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import hw7.entities.DataEntry;
import hw7.forms.*;

import java.util.*;

public class JdiMetalsAndColor  extends WebPage {
    private SummaryForm summaryForm;

    private ElementsForm elementsForm;

    private ColorsForm colorsForm;

    private MetalsForm metalsForm;

    private VegetablesForm vegetablesForm;

    private ResultForm resultForm;


    private void runTests(DataEntry data) {
        summaryForm.selectSummary(data.getSummary());
        elementsForm.selectElements(data.getElements());
        metalsForm.selectMetal(data.getMetals());
        colorsForm.selectColor(data.getColor());
        vegetablesForm.selectVegetables(data.getVegetables());
    }

    private void reset(DataEntry data) {
        vegetablesForm.reset(data.getVegetables());
        elementsForm.reset(data.getElements());
    }

    public Map<String, Boolean> fillData(DataEntry data) {
        this.runTests(data);
        ArrayList<Boolean> elementResult = (elementsForm.checkElements(data.getElements()));
        ArrayList<Boolean> summaryResult = summaryForm.checkSummary(data.getSummary());
        ArrayList<Boolean> vegetableResult = vegetablesForm.checkVegetables(data.getVegetables());
        boolean metalResult = metalsForm.checkMetal(data.getMetals());
        boolean colorsResult = colorsForm.checkColor(data.getColor());
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
