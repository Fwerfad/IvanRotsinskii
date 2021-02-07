package hw9.speller.service;

import hw9.speller.dto.ResponseDto;
import io.restassured.response.Response;

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

    public Response makeRequestWithTextAndFormat(String text, int endpoint, String format) {
        return requestFlow(new HashMap<String, String>() {{put("text", text);put("format", format);}}, endpoint);
    }

    public Response makeRequestWithTextAndOptions(String text, int endpoint, int options) {
        return requestFlow(new HashMap<String, String>() {{put("text", text);put("options", String.valueOf(options));}}, endpoint);
    }

    public Response makeRequestWithTexts(ArrayList<String> texts, int endpoint) {
        startNewRequest();
        for (String text : texts)
            addParams("text", text);
        return post(endpoint);
    }

    public ResponseDto getPrettyText(Response request) {
        return new ResponseDto().setTexts(new ArrayList<String>(Arrays.asList(request.getBody().jsonPath().get("s").toString()
                .replaceAll("\\[", "")
                .replaceAll("]", "")
                .split(", "))));
    }
}
