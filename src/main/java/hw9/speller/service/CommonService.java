package hw9.speller.service;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.apache.http.HttpStatus.SC_OK;

public class CommonService {

    private Properties properties = new Properties();

    private RequestSpecification request;
    private Response response;

    private void post(int endpoint) {
        response = request.when().post(properties.getProperties().get("BaseUrl").toString() +
                (properties.getProperties().get(properties.getEndpoint(endpoint)).toString()));
    }

    private RequestSpecification addParams(String name, String value) {
        return request.formParam(name, value);
    }

    private Response getResponse() {
        return response.then()
                .statusCode(SC_OK)
                .and()
                .extract().response();
    }

    private void startNewRequest() {
        request = RestAssured.given();
    }

    private Response requestFlow(Map<String, String> params, int endpoint) {
        startNewRequest();
        for (String key : params.keySet())
            addParams(key, params.get(key));
        post(endpoint);
        return getResponse();
    }

    public Response getResponse(String text, int endpoint) {
        return requestFlow(new HashMap<String, String>() {{put("text", text);}}, endpoint);
    }

    public Response getResponse(String text, int endpoint, String format) {
        return requestFlow(new HashMap<String, String>() {{put("text", text);put("format", format);}}, endpoint);
    }

    public Response getResponse(String text, int endpoint, int options) {
        return requestFlow(new HashMap<String, String>() {{put("text", text);put("options", String.valueOf(options));}}, endpoint);
    }

    public Response getResponse(ArrayList<String> texts, int endpoint) {
        startNewRequest();
        for (String text : texts)
            addParams("text", text);
        post(endpoint);
        return getResponse();
    }
}
