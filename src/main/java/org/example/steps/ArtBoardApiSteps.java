package org.example.steps;

import com.google.gson.JsonObject;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.example.api.BaseRequests;
import org.example.utils.JsonUtils;

import java.util.HashMap;
import java.util.Map;

import static org.example.api.BasePath.API_V2_PROJECTS;
import static org.example.api.BasePath.API_V2_PROJECT_BY_ID;
import static org.example.utils.JsonUtils.convertToJson;

public class ArtBoardApiSteps extends BaseRequests {

    public Response createProjectFromFile(String pathToJsonFile, int expectedStatusCode) {
        JsonObject body = JsonUtils.parseJsonFromFile(pathToJsonFile);
        RequestSpecification requestSpecification = buildApiSpec(API_V2_PROJECTS.getPath())
                .header("token", getToken())
                .contentType(ContentType.JSON)
                .body(body.toString());

        Response response = sendPostRequest(requestSpecification, expectedStatusCode);
        logger().info("Create project with id: " + response.getBody().jsonPath().get("id"));
        logger().info("Project name " + response.getBody().jsonPath().get("name"));
        return response;
    }

    public Response renameProject(String projectId, String newProjectName, int expectedStatusCode) {
        Map<String, String> body = new HashMap<>();
        body.put("id", projectId);
        body.put("name", newProjectName);

        RequestSpecification requestSpecification = buildApiSpec(API_V2_PROJECT_BY_ID.getPath())
                .pathParams("id", projectId)
                .header("token", getToken())
                .contentType(ContentType.JSON)
                .body(convertToJson(body));

        Response response = sendPatchRequest(requestSpecification, expectedStatusCode);
        logger().info("Rename project with id: " + projectId);
        logger().info("New project name " + newProjectName);
        return response;
    }
}
