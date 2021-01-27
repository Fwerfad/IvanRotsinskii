package hw7.elements;

import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;

public class Summary extends Form {
    @Css("#p1")
    private WebElement one;
    @Css("#p2")
    private WebElement three;
    @Css("#p3")
    private WebElement five;
    @Css("#p4")
    private WebElement seven;
    @Css("#p5")
    private WebElement two;
    @Css("#p6")
    private WebElement four;
    @Css("#p7")
    private WebElement six;
    @Css("#p8")
    private WebElement eight;
    private ArrayList<WebElement> summary;
    public Summary() {
        summary = new ArrayList<WebElement>(Arrays.asList(one,two,three,four,five,six,seven,eight));
    }

    public void selectSummary(int index1, int index2) {
        summary.get(index1).click();
        summary.get(index2).click();
    }
}
