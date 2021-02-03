package hw9.speller.low_level;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.*;

public class YandexSpellerExampleTest {
	@DataProvider(name = "data-provider")
	public Object[][] dataProviderMethod() {
		return new Object[][] { { "lilte", "little" }, { "bog", "big" }, { "сонце", "солнце"}};
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
		softAssert.assertTrue(actualResult.contains(expectedResult));
		softAssert.assertAll();
	}
}
