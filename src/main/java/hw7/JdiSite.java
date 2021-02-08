package hw7;

import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import hw7.pages.JdiHomePage;
import hw7.pages.JdiMetalsAndColorPage;

@JSite("http://jdi-testing.github.io/jdi-light/")
public class JdiSite {
    @Url("/index.html")
    public static JdiHomePage jdiHomePage;

    @Url("/metals-colors.html")
    @Title("Metal and Colors")
    public static JdiMetalsAndColorPage jdiMetalsAndColorPage;
}
