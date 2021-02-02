package hw7;

import hw7.TestContext.TestContext;
import hw7.entities.DataEntry;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;
import static com.epam.jdi.light.elements.init.PageFactory.initElements;
import static hw7.entities.User.*;
import org.json.*;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;


public class JdiTests {

    @DataProvider(name = "data-provider")
    public Iterator<Object> dpMethod(){
        Collection<Object> dp = new ArrayList<Object>(TestContext.getInstance().getData());
        return dp.iterator();
    }

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() {
        initElements(JdiSite.class);
    }

    @AfterSuite(alwaysRun = true)
    public void afterSuite() {
        killAllSeleniumDrivers();
    }


    public static <T, U> List<U> convertList(List<T> from, Function<T, U> func) {
        return from.stream().map(func).collect(Collectors.toList());
    }


    @Test
    public void jdi1LoadData() throws IOException {
        String jsonString = new String(Files.readAllBytes(Paths.get("src/test/resources/hw7/JDI_ex8_metalsColorsDataSet.json")), StandardCharsets.UTF_8);; //assign your JSON String here
        JSONObject obj = new JSONObject(jsonString);
        Set<String> keys = obj.keySet();
        TestContext testContext = TestContext.getInstance();
        for (String key : keys) {
            JSONObject entry = obj.getJSONObject(key);
            ArrayList<Integer> summary = (ArrayList<Integer>) entry.getJSONArray("summary").toList().stream().map(s -> (Integer) s).collect(Collectors.toList());
            ArrayList<String> elements = (ArrayList<String>) entry.getJSONArray("elements").toList().stream().map(s -> (String) s).collect(Collectors.toList());;
            String color = entry.getString("color");
            String metals = entry.getString("metals");
            ArrayList<String> vegetables = (ArrayList<String>) entry.getJSONArray("vegetables").toList().stream().map(s -> (String) s).collect(Collectors.toList());;
            testContext.addData(new DataEntry(summary, elements, color, metals, vegetables));
        }
    }

    @Test
    public void jdi2LoginTest() {
        JdiSite.openHomePage();
        JdiSite.jdiHomePage.login(ROMAN);
        JdiSite.jdiHomePage.checkUserLoggedIn();
    }

    @Test
    public void jdi3OpenMetalsAndColors(){
        JdiSite.openHomePage();
        JdiSite.jdiHomePage.navToMetalsAndColors();
        Assert.assertEquals(JdiSite.jdiHomePage.driver().getTitle(), JdiSite.METALSANDCOLOR); //Доставать тайтл не через драйвер
    }

    @Test(dataProvider = "data-provider")
    public void jdi4FillFormMetalsAndColors(DataEntry data){
        JdiSite.openMetalsAndColor();
        SoftAssert softAssert = new SoftAssert();
        Map<String, Boolean> result = JdiSite.jdiMetalsAndColor.fillData(data);
        for (String key : result.keySet()) {
            softAssert.assertTrue(result.get(key), key + " is wrong in " + data.toString());
        }
        softAssert.assertAll();
    }




    @Test(dataProvider = "data-provider")
    public void jdi5SumbitFormMetalsAndColorsData(DataEntry data) {
        JdiSite.openMetalsAndColor();
        Map<String, String> actualData = JdiSite.jdiMetalsAndColor.checkSubmission(data);
        Assert.assertTrue(actualData.size() > 0, "wrong submission on " + data.toString());
    }

    @Test(dataProvider = "data-provider")
    public void jdi6AssertSubmitFormMetalsAndColorsData(DataEntry data) {
        JdiSite.openMetalsAndColor();
        Map<String, String> actualData = JdiSite.jdiMetalsAndColor.checkSubmission(data);
        Map<String, String> expectedData = data.returnMap();
        Assert.assertEquals(actualData, expectedData, "wrong submission on " + data.toString());
    }
}
