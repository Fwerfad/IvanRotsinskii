package hw7.elements;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.ui.html.elements.common.Button;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.Map;

public class ResultForm {
    @Css("#mCSB_2_container > section:nth-child(2) > div.info-panel-body.info-panel-body-result > div > ul")
    private WebElement result;
    @Css("#submit-button")
    private Button resultButton;

    public void clickButton() {
        resultButton.click();
    }

    public Map<String, String> getData() {
        this.clickButton();
        String[] temp = result.getText().split("\n");
        Map<String, String> result = new HashMap<>();
        for (String s : temp) {
            String[] temp2 = s.split(": ");
            result.put(temp2[0], temp2[1]);
        }
        return result;
    }
}
