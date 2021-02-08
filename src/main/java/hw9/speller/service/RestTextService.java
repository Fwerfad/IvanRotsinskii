package hw9.speller.service;

import com.google.gson.Gson;
import hw9.speller.dto.ResponseDto;
import io.restassured.internal.path.json.mapping.JsonPathGsonObjectDeserializer;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class RestTextService extends CommonService{
    private static RestTextService restTextService;

    public static RestTextService getInstance() {
        if (restTextService == null)
            restTextService = new RestTextService();

        return restTextService;
    }

    public Response makeRequestWithText(String text) {
        return getWithParams(new HashMap<String, String>() {{put("text", text);}}, 1);
    }

    public Response makeRequestWithTextAndFormat(String text, String format) {
        return getWithParams(new HashMap<String, String>() {{put("text", text);put("format", format);}}, 1);
    }

    public Response makeRequestWithTextAndOptions(String text, int options) {
        return getWithParams(new HashMap<String, String>() {{put("text", text);put("options", String.valueOf(options));}}, 1);
    }

    public Response makeRequestWithTexts(ArrayList<String> texts) {
        startNewRequest();
        for (String text : texts)
            addParams("text", text);
        return post(2);
    }

    public ResponseDto getResponseDto(Response request) {
        System.out.println(request.getBody().prettyPrint());
        ResponseDto[] responseDto = new Gson().fromJson(request.getBody().prettyPrint(), ResponseDto[].class);
        return responseDto.length != 0 ? responseDto[0] : new ResponseDto();
    }
    public ResponseDto[] getResponseDtos(Response request) {
        System.out.println(request.getBody().prettyPrint());
        ResponseDto[][] responseDto = new Gson().fromJson(request.getBody().prettyPrint(), ResponseDto[][].class);
        return responseDto.length != 0 ? responseDto[0] : new ResponseDto[0];
    }
}
