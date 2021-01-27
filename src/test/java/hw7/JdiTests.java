package hw7;

import hw7.TestContext.TestContext;
import hw7.entities.DataEntry;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;
import static com.epam.jdi.light.elements.init.PageFactory.initElements;
import static java.lang.String.format;
import static hw7.entities.User.*;
import org.json.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Set;

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
    public void jdi1LoadData() throws IOException {
        String jsonString = new String(Files.readAllBytes(Paths.get("src/test/resources/hw7/JDI_ex8_metalsColorsDataSet.json")), StandardCharsets.UTF_8);; //assign your JSON String here
        JSONObject obj = new JSONObject(jsonString);
        Set<String> keys = obj.keySet();
        TestContext testContext = TestContext.getInstance();
        for (String key : keys) {
            JSONObject entry = obj.getJSONObject(key);
            testContext.addData(new DataEntry(
                    entry.getJSONArray("summary"),
                    entry.getJSONArray("elements"),
                    entry.getString("color"),
                    entry.getString("metals"),
                    entry.getJSONArray("vegetables")));
        }
//        System.out.println(obj.keySet());
//        System.out.println(testContext.getData().toString());
    }

    @Test
    public void jdi2LoginTest() {
        JdiSite.openHomePage();
        JdiSite.jdiHomePage.login(ROMAN);
        JdiSite.jdiHomePage.checkUserLoggedIn();
    }

    @Test
    public void jdiOpenMetalsAndColors(){
        JdiSite.openHomePage();
        JdiSite.jdiHomePage.navToMetalsAndColors();
        System.out.println(JdiSite.jdiHomePage.url);
        System.out.println(JdiSite.jdiHomePage.checkUrl);
        System.out.println(JdiSite.jdiHomePage.isOpened());
        System.out.println(JdiSite.jdiMetalsAndColor.isOpened());
        Assert.assertEquals(JdiSite.jdiHomePage.driver().getTitle(), JdiSite.METALSANDCOLOR); //Доставать тайтл не через драйвер
    }

    @Test
    public void jdiFillFormMetalsAndColors(){
        List<DataEntry> data = TestContext.getInstance().getData();
        JdiSite.openMetalsAndColor();
        for (DataEntry entry : data) {
            JdiSite.jdiMetalsAndColor.fillData(entry);
        }
    }
}
