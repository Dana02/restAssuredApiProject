package org.example.api;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Optional;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class BaseRequests extends RequestSpec {

    public Response sendGetRequest(RequestSpecification requestSpecification, int expectedStatusCode) {
        Response response = given().spec(requestSpecification).when().get()
                .then().extract().response();
        validateStatusCode(response, expectedStatusCode);
        return response;
    }

    public Response sendPutRequest(RequestSpecification requestSpecification, int expectedStatusCode) {
        Response response = given().spec(requestSpecification).when().log().all().put()
                .then().log().all().extract().response();
        validateStatusCode(response, expectedStatusCode);
        return response;
    }

    public Response sendPostRequest(RequestSpecification requestSpecification, int expectedStatusCode) {
        Response response = given().spec(requestSpecification).when().post()
                .then().extract().response();
        validateStatusCode(response, expectedStatusCode);
        return response;
    }

    public Response sendPatchRequest(RequestSpecification requestSpecification, int expectedStatusCode) {
        Response response = given().spec(requestSpecification).when().patch()
                .then().extract().response();
        validateStatusCode(response, expectedStatusCode);
        return response;
    }

    public Response sendDeleteRequest(RequestSpecification requestSpecification, int expectedStatusCode) {
        Response response = given().spec(requestSpecification).when().delete()
                .then().extract().response();
        validateStatusCode(response, expectedStatusCode);
        return response;
    }

    public void validateStatusCode(Response response, int expectedStatusCode) {
        try {
            response.then().statusCode(expectedStatusCode);
        } catch (AssertionError e) {
            String bodyAsString = Optional.ofNullable(response.getBody().asString()).orElse("Response body is empty");
            throw new AssertionError(String.format("\n Status Code is unexpected. " + "\n Expected: %s" + "\n Actual: %s " + "\n See Response body: %s", expectedStatusCode, response.getStatusCode(), bodyAsString));
        }
    }

    public void validateJsonSchema(Response resp, String pathToSchema) {
        resp.then().body(matchesJsonSchemaInClasspath(pathToSchema));
        logger().info("Validating JSON schema from the response");
    }
}
