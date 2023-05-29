package org.example.steps.ui;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.assertj.core.api.Assertions;
import org.example.enums.Config;
import org.example.enums.UrlPath;
import org.example.pages.MyProjectsPage;
import org.example.pages.objects.Project;
import org.example.utils.PropertyReader;
import org.testng.Assert;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MyProjectsSteps extends BaseSteps {

    private final MyProjectsPage myProjectsPage = new MyProjectsPage();
    private final String pageUrl = PropertyReader.getProperty(Config.BASE_URL) + UrlPath.MY_PROJECTS_PAGE.getPath();

    @Step
    public void open() {
        Selenide.open(pageUrl);
    }

    @Step
    public void assertPageIsShown() {
        String actualUrl = getWebDriver().getCurrentUrl();
        Assert.assertEquals(actualUrl, pageUrl, "My project's page URL is unexpected");
    }

    @Step
    public void clickOnProjectByName(String projectName) {
        waitAndClick(myProjectsPage.getProjectByName(projectName).getName());
    }

    //    @Step
//    public void dragProjects() {
//        WebElement trash = getLeftSideBar().getTrashElement();
//        Actions actions = new Actions(getDriver());
//        for (int i=0; i< getProjectItems().size();i++) {
//            actions
//                    .moveToElement(getProjectItems().get(i))
//                    .clickAndHold(getProjectItems().get(i))
//                    .moveToElement(trash)
//                    .release()
//                    .build()
//                    .perform();
//        }
//    // or:
//        // actions
//        // .dragAndDrop(getProjectItems().get(i),trash )
//        // .build()
//        // .perform();
//    }//TODO: just to show

    @Step
    public void dragProjectByIdToTrash(String projectId) {
        Project project = myProjectsPage.getProjectById(projectId);
        SelenideElement trashFolder = myProjectsPage.getLeftSideBar().getTrashFolder();
        Selenide.actions().dragAndDrop(project.getPreview(), trashFolder).build().perform();
    }

    @Step
    public void assertProjectByIdIsVisibleWithRefreshPage(String projectId) {
        try {
            myProjectsPage.getProjectById(projectId).getContainer().shouldBe(Condition.visible);
        } catch (AssertionError ignore) {
            refreshPage();
            myProjectsPage.getProjectById(projectId).getContainer().shouldBe(Condition.visible);
        }
    }

    @Step
    public void clickOnDeleteButtonForProjectById(String projectId) {
        waitAndClick(myProjectsPage.getProjectById(projectId).getMenu().getDeleteButton());
    }

    @Step
    public void assertProjectByIdIsNotVisible(String projectId) {
        boolean actualResult;
        try {
            actualResult = myProjectsPage.getProjectById(projectId).getContainer().is(Condition.visible);
        } catch (AssertionError ignore) {
            actualResult = false;
        }
        Assertions.assertThat(actualResult).as("User project has unexpected visibility on My project page").isFalse();
    }

    @Step
    public void assertNotification(Condition expectedCondition){
        myProjectsPage.getNotification().as("Notification on My project page has unexpected condition.").shouldBe(expectedCondition);
    }
}