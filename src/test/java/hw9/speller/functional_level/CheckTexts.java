package hw9.speller.functional_level;

import data_provider.DataProvider;
import hw9.speller.dto.ResponseDto;
import hw9.speller.dto.TextDto;
import hw9.speller.service.RestTextAssertions;
import hw9.speller.service.RestTextService;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class CheckTexts {

    @Test(dataProvider = "PositiveMany", dataProviderClass = DataProvider.class)
    void checkTexts(TextDto textDto) {
        Response request = RestTextService.getInstance()
                .makeRequestWithTexts(textDto.getTexts());
        ResponseDto[] actualResult = RestTextService.getInstance()
                .getResponseDtos(request);
        RestTextAssertions.getInstance()
                .assertMultipleTexts(textDto, actualResult);
    }
}
