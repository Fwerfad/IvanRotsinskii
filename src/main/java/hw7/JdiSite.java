package hw7;

import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import hw7.pages.JdiHomePage;
import hw7.pages.JdiMetalsAndColor;

@JSite("http://jdi-testing.github.io/jdi-light/")
public class JdiSite {

    public static String METALSANDCOLOR = "Metal and Colors";

    @Url("/index.html")
    public static JdiHomePage jdiHomePage;

    @Url("/metals-colors.html")
    public static JdiMetalsAndColor jdiMetalsAndColor;

    public static void openHomePage() {
        jdiHomePage.open();
    }

    public static void openMetalsAndColor() {
        jdiMetalsAndColor.open();
    }
}
