package org.example;


import io.restassured.response.Response;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.http.HttpStatus;
import org.assertj.core.api.Assertions;
import org.example.dto.FolderLombokDTO;
import org.example.steps.ArtBoardApiSteps;
import org.example.steps.MyProjectApiSteps;
import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Unit test for simple App.
 */
public class AppTest {
    MyProjectApiSteps myProjectApi = new MyProjectApiSteps();
    ArtBoardApiSteps artBoardApi = new ArtBoardApiSteps();

    @Test
    public void verifyFolderSize() {
        List<FolderLombokDTO> actualFolderList = myProjectApi.getAllFolders().jsonPath().getList("", FolderLombokDTO.class);

        Assertions.assertThat(actualFolderList).as("Folder size is unexpected").hasSize(3);
        Assertions.assertThat(actualFolderList.get(0).getName()).as("Name is unexpected for first folder")
                .isEqualTo("Test2");
    }

    @Test
    public void verifyExpectedFolder() {
        List<FolderLombokDTO> actualFolderList = myProjectApi.getAllFolders().jsonPath().getList("", FolderLombokDTO.class);

        FolderLombokDTO folder = actualFolderList.stream().filter(folderDTO -> folderDTO.getName().equals("Test2")).collect(Collectors.toList()).get(0);

        Assertions.assertThat(folder.getName()).as("Folder name is unexpected").isEqualTo("Test2");
    }

    @Test
    public void createAndDeleteFolder() {
        String folderName = "Test_".concat(RandomStringUtils.random(3));
        int expectedFolderListSize = 1;
        boolean folderIsPresent = true;
        boolean folderIsNotPresent = false;
        String pathToJsonSchema = "testData/jsonSchemas/CreateFolderJsonSchema.json";

        Response createFolderResponse = myProjectApi.createNewFolder(folderName);
        FolderLombokDTO newFolder = createFolderResponse.as(FolderLombokDTO.class);

        Assertions.assertThat(newFolder.getCreatedAt()).as("Created At is not present").isNotNull();
        myProjectApi.validateJsonSchema(createFolderResponse, pathToJsonSchema);

        myProjectApi.verifyFolderVisibilityByName(folderName, folderIsPresent);

        myProjectApi.deleteFolderById(newFolder.getId());

        myProjectApi.verifyFolderVisibilityByName(folderName, folderIsNotPresent);

        myProjectApi.deleteAllFolders();

        Assertions.assertThat(myProjectApi.getAllFoldersDto()).as("Folder list has unexpected size").hasSize(expectedFolderListSize);
    }

    @Test
    public void createProject() {
        String facebookPostPathFile = "src/test/resources/bodyJsons/DefaultFacebookPostProject.json";
        String facebookPostJsonSchemaPathFile = "testData/jsonSchemas/FacebookPostJsonSchema.json";
        String projectName = "Test_".concat(RandomStringUtils.random(3));

        Response createProjectResponse = artBoardApi.createProjectFromFile(facebookPostPathFile, HttpStatus.SC_OK);

        artBoardApi.validateJsonSchema(createProjectResponse, facebookPostJsonSchemaPathFile);

        String projectId = createProjectResponse.getBody().jsonPath().getString("id");
        artBoardApi.renameProject(projectId, projectName, HttpStatus.SC_NO_CONTENT);

        String actualNewProjectName = myProjectApi.getProjectById(projectId).get("name").toString();
        Assertions.assertThat(actualNewProjectName).as("New project name is unexpected on 'my projects' page").isEqualTo(projectName);

        //TODO add deleteProjectById
        //and verify it was deleted
        //myProjectApi.deleteProjectById(projectId);
        Response allProjectsIds = myProjectApi.getAllProjects();

        Assertions.assertThat(allProjectsIds.getBody().jsonPath().getList("id")).as("Project was not deleted").contains(projectId);


        //TODO - перейменувати створений проект в табі мої проекти
        //перевірити на юайці чи перейменований проект (ui test)
    }

}
