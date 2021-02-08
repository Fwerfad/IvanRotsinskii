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

    void startNewRequest() {
        request = RestAssured.given();
    }

    RequestSpecification addParams(String name, String value) {
        return request.formParam(name, value);
    }

    Response post(int endpoint) {
        String url = properties.getProperties().get("BaseUrl").toString() +
                properties.getProperties().get(properties.getEndpoint(endpoint)).toString();
        Response response = request.when()
                .post(url);
        return response.then()
                .statusCode(SC_OK)
                .and()
                .extract().response();
    }

    Response getWithParams(Map<String, String> params, int endpoint) {
        startNewRequest();
        for (String key : params.keySet())
            addParams(key, params.get(key));
        return post(endpoint);
    }

    Response getNoParams() {
        startNewRequest();
        return post(1);
    }
}
