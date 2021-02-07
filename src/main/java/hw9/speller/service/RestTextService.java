package hw9.speller.service;

import hw9.speller.dto.ResponseDto;
import io.restassured.response.Response;

import java.util.ArrayList;
import java.util.Arrays;

public class RestTextService extends CommonService{
    private static RestTextService restTextService;

    public static RestTextService getInstance() {
        if (restTextService == null)
            restTextService = new RestTextService();

        return restTextService;
    }

    public ResponseDto getPrettyText(Response request) {
        return new ResponseDto().setTexts(new ArrayList<String>(Arrays.asList(request.getBody().jsonPath().get("s").toString()
                .replaceAll("\\[", "")
                .replaceAll("]", "")
                .split(", "))));
    }
}
