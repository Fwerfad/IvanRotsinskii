package hw9.speller.service;

import hw9.speller.dto.ResponseDto;
import hw9.speller.dto.TextDto;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class RestTextAssertions {
    private static RestTextAssertions restTextAssertions;

    public static RestTextAssertions getInstance() {
        if (restTextAssertions == null) {
            restTextAssertions = new RestTextAssertions();
        }
        return restTextAssertions;
    }

    public RestTextAssertions assertWrongLanguageTexts(TextDto textDto, ResponseDto responseDto) {
        if (textDto.isUnexpectedResult())
            Assert.assertFalse(responseDto.getS().contains(textDto.getExpectedResult()), "Getting expected result with wrong language set");
        else
            Assert.assertTrue(responseDto.getS().contains(textDto.getExpectedResult()), "Not getting expected result");
        return this;
    }

    public RestTextAssertions assertStatusCode(Response request, int expectedStatusCode) {
        Assert.assertEquals(request.statusCode(), expectedStatusCode, "Expected status code:" + expectedStatusCode + ", but got:" + request.statusCode());
        return this;
    }

    public RestTextAssertions assertTexts(TextDto textDto, ResponseDto responseDto) {
        Assert.assertTrue(responseDto.getS().contains(textDto.getExpectedResult()), "Got unexpected result: Expected " + textDto.getExpectedResult() + " but got " + responseDto.getS());
        return this;
    }

    public RestTextAssertions assertMultipleTexts(TextDto textDto, ResponseDto[] responseDto) {
        SoftAssert softAssert = new SoftAssert();
        for (String text : textDto.getExpectedResults()) {
            boolean flag = false;
            for (ResponseDto responseDto1 : responseDto) {
                if (!text.equals(""))
                    if(responseDto1.getS().contains(text))
                        flag = true;
            }
            softAssert.assertTrue(flag, "Got unexpected result: Expected " + text + " but got no response");
        }
        softAssert.assertAll();
        return this;
    }
}
