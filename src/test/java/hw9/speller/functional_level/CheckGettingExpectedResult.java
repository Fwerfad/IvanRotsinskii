package hw9.speller.functional_level;

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

public class CheckGettingExpectedResult {
    @DataProvider(name = "data-provider")
    public Iterator<Object> dataProviderMethod() {
        Collection<Object> dp = new ArrayList<>(Arrays.asList(
                new TextDto().setText("lilte").setExpectedResult("little"),
                new TextDto().setText("малоко").setExpectedResult("молоко"),
                new TextDto().setText("lilte").setExpectedResult("little").setEndpoint(2),
                new TextDto().setText("малоко").setExpectedResult("молоко").setEndpoint(2)));
        return dp.iterator();
    }

    @Test(dataProvider = "data-provider")
    void checkResult(TextDto textDto) {
        Response request = RestTextService.getInstance()
                .getResponse(textDto.getText(), textDto.getEndpoint());
        ResponseDto actualResult = RestTextService.getInstance()
                .getPrettyResult(request);
        RestTextAssertions.getInstance()
                .assertStatusCode(request, 200)
                .assertTexts(textDto, actualResult);
    }
}
