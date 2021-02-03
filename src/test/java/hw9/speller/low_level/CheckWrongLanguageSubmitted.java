package hw9.speller.low_level;

import hw9.speller.dto.ResponseDto;
import hw9.speller.dto.TextDto;
import hw9.speller.service.RestTextAssertions;
import hw9.speller.service.RestTextService;
import io.restassured.response.Response;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.*;

public class CheckWrongLanguageSubmitted {
    @DataProvider(name = "data-provider")
    public Iterator<Object> dataProviderMethod() {
        Collection<Object> dp = new ArrayList<>(Arrays.asList(
                new TextDto().setText("lilte").setLang("en").setExpectedResult("little"),
                new TextDto().setText("lilte").setLang("ru").setExpectedResult("little").setUnexpectedResult(true),
                new TextDto().setText("малоко").setLang("ru").setExpectedResult("молоко"),
                new TextDto().setText("малоко").setLang("en").setExpectedResult("молоко").setUnexpectedResult(true),
                new TextDto().setText("lilte").setLang("en").setExpectedResult("little").setEndpoint(2),
                new TextDto().setText("lilte").setLang("ru").setExpectedResult("little").setUnexpectedResult(true).setEndpoint(2),
                new TextDto().setText("малоко").setLang("ru").setExpectedResult("молоко").setEndpoint(2),
                new TextDto().setText("малоко").setLang("en").setExpectedResult("молоко").setUnexpectedResult(true).setEndpoint(2)));
        return dp.iterator();
    }

    @Test(dataProvider = "data-provider")
    void checkWrongLanguageSubmitted(TextDto textDto) {
        Response request = RestTextService.getInstance()
                .getResponse(textDto.getText(), textDto.getEndpoint());
        ResponseDto actualResult = RestTextService.getInstance()
                .getPrettyResult(request);
        RestTextAssertions.getInstance()
                .assertStatusCode(request, 200)
                .assertWrongLanguageTexts(textDto, actualResult);
    }
}
