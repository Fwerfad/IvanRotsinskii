package hw7;

import hw7.entities.MetalsAndColor;
import org.testng.Assert;
import org.testng.annotations.*;

import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;
import static com.epam.jdi.light.elements.init.PageFactory.initElements;
import static hw7.entities.User.*;

import java.util.*;


public class JdiTests {

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() {
        initElements(JdiSite.class);
    }

    @AfterSuite(alwaysRun = true)
    public void afterSuite() {
        killAllSeleniumDrivers();
    }

    @BeforeTest()
    public void login() {
        JdiSite.jdiHomePage.open();
        JdiSite.jdiHomePage.login(ROMAN);
        JdiSite.jdiHomePage.checkUserLoggedIn(ROMAN);
        JdiSite.jdiHomePage.navToMetalsAndColors();
    }

    @Test(dataProvider = "data-provider", dataProviderClass = JdiDataProvider.class)
    public void jdiMetalsAndColorFormTest(MetalsAndColor data){
        JdiSite.jdiMetalsAndColorPage.open();
        JdiSite.jdiMetalsAndColorPage.submit(data);
        Map<String, String> actualResult = JdiSite.jdiMetalsAndColorPage.getData();
        Map<String, String> expectedResult = data.returnMap();
        Assert.assertEquals(actualResult, expectedResult, "wrong data in submit logs");
    }
}
