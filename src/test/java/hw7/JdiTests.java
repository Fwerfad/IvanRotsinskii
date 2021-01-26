package hw7;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;
import static com.epam.jdi.light.elements.init.PageFactory.initElements;
import static java.lang.String.format;
import static hw7.entities.User.*;

public class JdiTests {

    public static final int EXPECTED_B_C = 4;

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() {
        initElements(JdiSite.class);
    }

    @AfterSuite(alwaysRun = true)
    public void afterSuite() {
        killAllSeleniumDrivers();
    }

    @Test
    public void jdiBenefitsCountTest() {
        JdiSite.open();
        int actualBenefitsCount = JdiSite.jdiHomePage.getBenefitsCount();

        Assert.assertEquals(actualBenefitsCount, EXPECTED_B_C,
                format("Actual Benefits count: %s but expected: %s", actualBenefitsCount, EXPECTED_B_C));
    }

    @Test
    public void jdiLoginTest() {
        JdiSite.open();
        JdiSite.jdiHomePage.login(ROMAN);
        JdiSite.jdiHomePage.userName.is().text(ROMAN.getFullName());
    }
}
