package org.example.steps;

import com.google.common.collect.ImmutableMap;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.assertj.core.api.Assertions;
import org.example.api.BaseRequests;
import org.example.dto.FolderLombokDTO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.example.api.BasePath.API_FOLDERS;
import static org.example.api.BasePath.API_FOLDERS_BY_ID;
import static org.example.api.BasePath.API_PROJECTS_FILTER_NO_TRASH;
import static org.example.api.BasePath.API_PROJECTS_MULTI;
import static org.example.utils.JsonUtils.convertToJson;
import static org.example.utils.ListUtils.getSingleElementOfList;

public class MyProjectApiSteps extends BaseRequests {

    public Response getAllFolders() {
        RequestSpecification requestSpecification = buildApiSpec(API_FOLDERS.getPath())
                .queryParam("folderType", "project")
                .header("token", getToken())
                .contentType(ContentType.JSON);
        return sendGetRequest(requestSpecification, HttpStatus.SC_OK);
    }

    public List<FolderLombokDTO> getAllFoldersDto() {
        return getAllFolders().jsonPath().getList("", FolderLombokDTO.class);
    }

    public FolderLombokDTO getFolderById(String folderId) {
        List<FolderLombokDTO> expectedFolderList =
                getAllFoldersDto().stream().filter(folder -> folder.getId().equals(folderId)).collect(Collectors.toList());
        return getSingleElementOfList(expectedFolderList, "Folder list contains folders with the same id");
    }

    public Response getAllProjects() {
        RequestSpecification requestSpecification = buildApiSpec(API_PROJECTS_FILTER_NO_TRASH.getPath())
                .queryParam("sort", "updatedAt")
                .header("token", getToken())
                .contentType(ContentType.JSON);
        return sendGetRequest(requestSpecification, HttpStatus.SC_OK);
    }

    public HashMap<String, Object> getProjectById(String projectId) {
        List<HashMap<String, Object>> objectList = getAllProjects().getBody().jsonPath().getList("items");
        List<HashMap<String, Object>> expectedProject = objectList.stream().filter(project -> project.get("id").equals(projectId)).collect(Collectors.toList());
        return getSingleElementOfList(expectedProject, "Project list contains projects with the same id");
    }

    public FolderLombokDTO getFolderByName(String folderName) {
        List<FolderLombokDTO> expectedFolderList =
                getAllFoldersDto().stream().filter(folder -> folder.getName().equals(folderName)).collect(Collectors.toList());
        return getSingleElementOfList(expectedFolderList, "Folder list contains unexpected folder");
    }

    public void verifyFolderVisibilityByName(String folderName, boolean expectedVisibility) {
        boolean actualVisibility;
        try {
            actualVisibility = Optional.ofNullable(getFolderByName(folderName)).isPresent();
        } catch (AssertionError ignore) {
            actualVisibility = false;
        }
        Assertions.assertThat(actualVisibility).as("Folder visibility is unexpected").isEqualTo(expectedVisibility);
    }

    public Response createNewFolder(String folderName) {
        Map<String, String> body = new HashMap<>();
        body.put("folderType", "project");
        body.put("name", folderName);

        Map<String, String> bodyMapJava11 = Map.of(
                "folderType", "project",
                "name", folderName);

        RequestSpecification requestSpecification = buildApiSpec(API_FOLDERS.getPath())
                .header("token", getToken())
                .contentType(ContentType.JSON)
                .body(convertToJson(body));
//                .body(convertToJson(Map.of(
//                        "folderType", "project",
//                        "name", folderName)));
        //.body("{\"folderType\":\"project\",\"name\":\"" + folderName + "\"}");

        return sendPostRequest(requestSpecification, HttpStatus.SC_OK);
    }

    public Response deleteFolderById(String folderId) {
        RequestSpecification requestSpecification = buildApiSpec(API_FOLDERS_BY_ID.getPath())
                .pathParams("id", folderId)
                .header("token", getToken())
                .contentType(ContentType.JSON);
        return sendDeleteRequest(requestSpecification, HttpStatus.SC_OK);
    }

    public void deleteAllFolders() {
        getAllFoldersDto().forEach(folder -> {
            if (Objects.isNull(folder.getTrash()))
                deleteFolderById(folder.getId());
        });
    }

//    public Response deleteProjectById(String projectId) {
//        Map<String, String> body = new HashMap<>();
//        body.put("folderId", projectId);
//
//        RequestSpecification requestSpecification = buildApiSpec(API_PROJECTS_MULTI_IDS.getPath())
//                .pathParams("id", projectId)
//                .header("token", getToken())
//                .contentType(ContentType.JSON)
//                .body(convertToJson(body));
//        return sendPutRequest(requestSpecification, HttpStatus.SC_OK);
//    }

    public Response deleteProjectById(String projectId, String folderID) {
        RequestSpecification spec = buildApiSpec(API_PROJECTS_MULTI.getPath())
                .queryParam("ids", projectId)
                .header("token", getToken())
                .contentType(ContentType.JSON)
                .body(convertToJson(ImmutableMap.of("folderId", folderID)));
        logger().info(String.format("Delete a '%s' project from '%s' folder.", projectId, folderID));
        return sendPutRequest(spec, HttpStatus.SC_OK);
    }
}