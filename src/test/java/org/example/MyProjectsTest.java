package org.example;

import com.codeborne.selenide.Condition;
import org.example.steps.ArtBoardApiSteps;
import org.example.steps.MyProjectApiSteps;
import org.example.steps.ui.ArtBoardSteps;
import org.example.steps.ui.HeaderSteps;
import org.example.steps.ui.LoginSteps;
import org.example.steps.ui.MainSteps;
import org.example.steps.ui.MyProjectsSteps;
import org.example.steps.ui.VistaLoginSteps;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class MyProjectsTest extends BaseTest {

    private final MainSteps mainPage = new MainSteps();
    private final LoginSteps loginPage = new LoginSteps();
    private final VistaLoginSteps vistaLoginPage = new VistaLoginSteps();
    private final ArtBoardApiSteps artBoardApi = new ArtBoardApiSteps();
    private final MyProjectApiSteps myProjectsApi = new MyProjectApiSteps();
    private final MyProjectsSteps myProjectsPage = new MyProjectsSteps();
    private final ArtBoardSteps artBoard = new ArtBoardSteps();
    private final HeaderSteps header = new HeaderSteps();
    private String projectId;

    @BeforeClass
    private void authorizeUser() {
        mainPage.open();
        header.clickOnLogInButton();
        loginPage.clickOnLoginButton();
        loginPage.switchToNewTab();
        vistaLoginPage.setEmail("loxir35724@gpipes.com");
        vistaLoginPage.setPassword("KCf.yA.r4R6g$m!");
        vistaLoginPage.clickOnLoginButton();
        vistaLoginPage.switchToParentTab();
        header.assertUserMenu(Condition.visible);
        vistaLoginPage.storeUserTokenFromCookiesToProperty();
    }

    @BeforeMethod
    private void createDefaultProjectByAPI() {
        String facebookPostPathFile = "src/test/resources/bodyJsons/DefaultFacebookPostProject.json";
        projectId = artBoardApi.createProjectFromFile(facebookPostPathFile, org.apache.http.HttpStatus.SC_OK).getBody().jsonPath().get("id");
        List<String> projectList = myProjectsApi.getAllProjects().getBody().jsonPath().get("items.id");
        assertThat(projectList).as("My project list does not contain expected project.").contains(projectId);
    }

    @Test
    public void verifyProjectVisibility() {
        myProjectsPage.open();
        //перевірити що проект створений
        //видалити проект
        //перевірити що проекту нема
    }

    @AfterTest
    public void deleteCreatedProject() {
        if (Optional.ofNullable(projectId).isPresent()) {
            String trashFolderId = "63f6838b733d8df722f22969";
            myProjectsApi.deleteProjectById(projectId, trashFolderId);
        }
    }

}
