package hw9.speller.low_level;

import hw9.speller.dto.TextDto;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Arrays;
import java.util.List;

public class CheckWrongLanguageSubmitted {
    @DataProvider(name = "data-provider")
    public TextDto[] dataProviderMethod() {
        List<TextDto> arr = Arrays.asList(new TextDto[]{
                new TextDto().setText("lilte").setLang("eng"),
                new TextDto().setText("lilte").setLang("ru"),
                new TextDto().setText("малоко").setLang("ru"),
                new TextDto().setText("малоко").setLang("eng")
        });
        return new arr.iterator();
    }

    @Test(dataProvider = "data-provider")
    void yandexSpellerPositiveTest(String text, String expectedResult) {
        Response request = RestAssured.given()
                .formParam("text", text)
                .when()
                .post("https://speller.yandex.net/services/spellservice.json/checkText")
                .then()
                .statusCode(200)
                .and()
                .extract().response();
        List<String> actualResult = Arrays.asList(request.getBody().jsonPath().get("s").toString()
                .replaceAll("\\[", "")
                .replaceAll("]", "")
                .split(", "));
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(request.statusCode(),200);
        System.out.println(text);
        System.out.println(expectedResult);
        System.out.println(actualResult);
        softAssert.assertTrue(actualResult.contains(expectedResult));
        softAssert.assertAll();
}
