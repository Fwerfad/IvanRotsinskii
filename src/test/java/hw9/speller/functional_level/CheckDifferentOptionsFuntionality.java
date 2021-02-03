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

public class CheckDifferentOptionsFuntionality {
    @DataProvider(name = "data-provider")
    public Iterator<Object> dataProviderMethod() {
        Collection<Object> dp = new ArrayList<>(Arrays.asList(
                new TextDto().setText("lilte").setExpectedResult("little").setOptions(TextDto.IGNORE_DIGITS),
                new TextDto().setText("li1l2t5e").setExpectedResult("").setOptions(TextDto.IGNORE_DIGITS),
                new TextDto().setText("lilte").setExpectedResult("little").setOptions(TextDto.IGNORE_URLS),
                new TextDto().setText("lilte.net").setExpectedResult("").setOptions(TextDto.IGNORE_URLS),
                new TextDto().setText("two to tu").setExpectedResult("tu").setOptions(TextDto.FIND_REPEAT_WORDS),
                new TextDto().setText("two to tu tu").setExpectedResult("").setOptions(TextDto.FIND_REPEAT_WORDS),
                new TextDto().setText("москва").setExpectedResult("Москва").setOptions(TextDto.IGNORE_CAPITALIZATION),
                new TextDto().setText("Москва").setExpectedResult("").setOptions(TextDto.IGNORE_CAPITALIZATION)));
        return dp.iterator();
    }

    @Test(dataProvider = "data-provider")
    void checkResult(TextDto textDto) {
        Response request = RestTextService.getInstance()
                .getResponse(textDto.getText(), textDto.getEndpoint(), textDto.getOptions());
        ResponseDto actualResult = RestTextService.getInstance()
                .getPrettyResult(request);
        RestTextAssertions.getInstance()
                .assertStatusCode(request, 200)
                .assertTexts(textDto, actualResult);
    }
}
