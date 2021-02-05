package hw7.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.ui.html.elements.complex.RadioButtons;
import hw7.entities.MetalsAndColorDataEntry;
import hw7.forms.*;
import org.openqa.selenium.WebElement;

import java.lang.reflect.Field;
import java.util.*;

public class JdiMetalsAndColor  extends WebPage {

    @Css("#mCSB_2_container > section:nth-child(2) > div.info-panel-body.info-panel-body-result > div > ul")
    private WebElement result;

    private JdiMetalsAndColorForm jdiMetalsAndColorForm;

    public Map<String, String> fillData(MetalsAndColorDataEntry data) {
        System.out.println(data);
        jdiMetalsAndColorForm.submit(data);
        return getData();
    }

    private Map<String, String> getData() {
        String[] temp = result.getText().split("\n");
        Map<String, String> result = new HashMap<>();
        for (String s : temp) {
            String[] temp2 = s.split(": ");
            result.put(temp2[0], temp2[1]);
        }
        return result;
    }
}