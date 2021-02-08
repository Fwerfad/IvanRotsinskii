package hw7.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import hw7.entities.MetalsAndColor;
import hw7.forms.*;
import org.openqa.selenium.WebElement;

import java.util.*;

public class JdiMetalsAndColorPage extends WebPage {
    @Css("div.info-panel-body-result > div > ul")
    private WebElement result;

    private JdiMetalsAndColorForm jdiMetalsAndColorForm;

    public void submit(MetalsAndColor data) {
        jdiMetalsAndColorForm.submit(data);
    }

    public Map<String, String> getData() {
        String[] temp = result.getText().split("\n");
        Map<String, String> result = new HashMap<>();
        for (String s : temp) {
            String[] temp2 = s.split(": ");
            result.put(temp2[0], temp2[1]);
        }
        return result;
    }
}