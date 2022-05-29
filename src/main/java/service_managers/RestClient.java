package service_managers;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import wrappers.ResponseWrapper;

import static io.restassured.RestAssured.given;

public class RestClient {
    private RequestSpecification requestSpecification;

    public void configure(RequestSpecification requestSpecification) {
        this.requestSpecification = given().spec(requestSpecification);
    }

    @Step("Get /{path} without query parameters")
    public <T> ResponseWrapper<T> get(String path) {
        Response response = requestSpecification.get(path);
        return new ResponseWrapper<>(response, null);
    }

    @Step("Get /{path} without query parameters")
    public <T> ResponseWrapper<T> get(String path, Class<T> responseClass) {
        Response response = requestSpecification.get(path);
        return new ResponseWrapper<>(response, responseClass);
    }
}
