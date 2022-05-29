package wrappers;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.assertj.core.api.Assertions.assertThat;


public class ResponseWrapper<T> {
    private final Response response;
    private final Class<T> responseClass;

    public ResponseWrapper(Response response, Class<T> responseClass) {
        this.response = response;
        this.responseClass = responseClass;
    }

    public Response getResponse() {
        return response;
    }

    public T readEntity() {
        return response.getStatusCode() >= 300 ? null : response.getBody().as(responseClass);
    }

    public T readEntity(String path) {
        return response.getStatusCode() >= 300 ? null : response.getBody().jsonPath().getObject(path, responseClass);
    }

    public ResponseWrapper<T> expectingStatusCode(int statusCode) {
        assertThat(response.getStatusCode()).isEqualTo(statusCode);
        return this;
    }

    public ValidatableResponse validateSchema(String schemaPath) {
        return response.getStatusCode() >= 300 ? null : response.then().body(matchesJsonSchemaInClasspath(schemaPath));
    }

}
