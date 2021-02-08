package hw9.speller.functional_level;

import data_provider.DataProvider;
import hw9.speller.dto.ResponseDto;
import hw9.speller.dto.TextDto;
import hw9.speller.service.RestTextAssertions;
import hw9.speller.service.RestTextService;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class CheckDifferentOptionsFunctionality {

    @Test(dataProvider = "Options", dataProviderClass = DataProvider.class)
    void checkResult(TextDto textDto) {
        Response request = RestTextService.getInstance()
                .makeRequestWithTextAndOptions(textDto.getText(), textDto.getOptions());
        ResponseDto actualResult = RestTextService.getInstance()
                .getResponseDto(request);
        RestTextAssertions.getInstance()
                .assertTexts(textDto, actualResult);
    }
}
