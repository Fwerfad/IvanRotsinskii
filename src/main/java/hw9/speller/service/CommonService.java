package hw9.speller.service;

import hw9.speller.dto.TextDto;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.Validatable;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.Properties;

public class CommonService {
    @SneakyThrows
    private Properties getProperties() {
        Properties props = new Properties();
        String propFileName = "hw9/test.properties";
        props.load(getClass().getClassLoader().getResourceAsStream(propFileName));
        return props;
    }

    public Response getResponse(String text, int endpoint) {
        Response request = RestAssured.given()
                .formParam("text", text)
                .when()
                .post(getProperties().get("BaseUrl").toString() +
                        (endpoint==1?
                                getProperties().get("textEndpoint").toString() :
                                getProperties().get("textsEndpoint").toString()))
                .then()
                .statusCode(200)
                .and()
                .extract().response();
        return request;
    }

    public Response getResponse(String text, int endpoint, String format) {
        Response request = RestAssured.given()
                .formParam("text", text)
                .formParam("format", format)
                .when()
                .post(getProperties().get("BaseUrl").toString() +
                        (endpoint==1?
                                getProperties().get("textEndpoint").toString() :
                                getProperties().get("textsEndpoint").toString()))
                .then()
                .statusCode(200)
                .and()
                .extract().response();
        return request;
    }

    public Response getResponse(String text, int endpoint, int options) {
        Response request = RestAssured.given()
                .formParam("text", text)
                .formParam("options", options)
                .when()
                .post(getProperties().get("BaseUrl").toString() +
                        (endpoint==1?
                                getProperties().get("textEndpoint").toString() :
                                getProperties().get("textsEndpoint").toString()))
                .then()
                .statusCode(200)
                .and()
                .extract().response();
        return request;
    }

    public Response getResponse(ArrayList<String> texts, int endpoint) {
        Response request;
        RequestSpecification partlyDoneRequest = RestAssured.given();
        for (String text : texts) {
            partlyDoneRequest.formParam("text", text);
        }
        request = partlyDoneRequest
                .post(getProperties().get("BaseUrl").toString() +
                        (endpoint==1?
                                getProperties().get("textEndpoint").toString() :
                                getProperties().get("textsEndpoint").toString()))
                .then()
                .statusCode(200)
                .and()
                .extract().response();
        return request;
    }
}
