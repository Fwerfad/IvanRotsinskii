package hw9.speller.functional_level;

import data_provider.DataProvider;
import hw9.speller.dto.ResponseDto;
import hw9.speller.dto.TextDto;
import hw9.speller.service.RestTextAssertions;
import hw9.speller.service.RestTextService;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class CheckText {

    @Test(dataProvider = "PositiveOne", dataProviderClass = DataProvider.class)
    void checkText(TextDto textDto) {
        Response request = RestTextService.getInstance()
                .makeRequestWithText(textDto.getText());
        ResponseDto actualResult = RestTextService.getInstance()
                .getResponseDto(request);
        RestTextAssertions.getInstance()
                .assertTexts(textDto, actualResult);
    }
}
