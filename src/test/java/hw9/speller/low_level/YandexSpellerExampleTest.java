package hw9.speller.low_level;

import com.google.gson.JsonObject;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Arrays;
import java.util.List;

public class YandexSpellerExampleTest {



	@Test(dataProvider = "data-provider")
	void yandexSpellerPositiveTest(String text, String expectedResult) {
		JsonObject requestParams = new JsonObject();
		requestParams.addProperty("text", text);
		Response request = RestAssured.given()
				.formParam("text", "liltle")
				.when()
				.post("https://speller.yandex.net/services/spellservice.json/checkText")
				.then()
				.statusCode(200)
				.and()
				.extract().response();
		List<String> actualResult = Arrays.asList(request.getBody().jsonPath().get("s").toString()
				.replaceAll("\\[", "")
				.replaceAll("]", ""));
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(request.statusCode(),200);
		softAssert.assertTrue(actualResult.contains(expectedResult));
		softAssert.assertAll();
	}
}
