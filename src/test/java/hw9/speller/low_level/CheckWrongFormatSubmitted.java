package hw9.speller.low_level;

import hw9.speller.dto.ResponseDto;
import hw9.speller.dto.TextDto;
import hw9.speller.service.RestTextAssertions;
import hw9.speller.service.RestTextService;
import io.restassured.response.Response;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class CheckWrongFormatSubmitted {
    @DataProvider(name = "data-provider")
    public Iterator<Object> dataProviderMethod() {
        Collection<Object> dp = new ArrayList<>(Arrays.asList(
                new TextDto().setText("lilte").setLang("en").setExpectedResult("little").setFormat("plain"),
                new TextDto().setText("lilte").setLang("en").setExpectedResult("little").setFormat("html"),
                new TextDto().setText("малоко").setLang("ru").setExpectedResult("молоко").setFormat("plain"),
                new TextDto().setText("малоко").setLang("ru").setExpectedResult("молоко").setFormat("utf-8"),
                new TextDto().setText("lilte").setLang("en").setExpectedResult("little").setEndpoint(2).setFormat("plain"),
                new TextDto().setText("lilte").setLang("en").setExpectedResult("little").setEndpoint(2).setFormat("html"),
                new TextDto().setText("малоко").setLang("ru").setExpectedResult("молоко").setEndpoint(2).setFormat("plain"),
                new TextDto().setText("малоко").setLang("ru").setExpectedResult("молоко").setEndpoint(2).setFormat("utf-8")));
        return dp.iterator();
    }

    @Test(dataProvider = "data-provider")
    void checkWrongLanguageSubmitted(TextDto textDto) {
        Response request = RestTextService.getInstance()
                .getResponse(textDto.getText(), textDto.getEndpoint(), textDto.getFormat());
        ResponseDto actualResult = RestTextService.getInstance()
                .getPrettyResult(request);
        RestTextAssertions.getInstance()
                .assertStatusCode(request, 200)
                .assertTexts(textDto, actualResult);
    }
}
