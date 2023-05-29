package org.example.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.example.enums.Config;
import org.example.pages.objects.MyProjectsLeftSidebar;
import org.example.pages.objects.Project;
import org.openqa.selenium.By;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static org.example.utils.ListUtils.getSingleElementOfList;
import static org.example.utils.PropertyReader.getPropertyInt;

public class MyProjectsPage extends AbstractBasePage {

    private final SelenideElement pageWrapper = $x("//div[starts-with(@class,'myProjectsWrapper')]");
    private final By projectItems = By.xpath(".//div[starts-with(@class,'projectListItem')]");
    private final By notification = By.xpath("//div[starts-with(@class,'headerNotificationWrapper')]");

    @Override
    public SelenideElement getPage() {
        return pageWrapper.as("My projects page").shouldBe(Condition.visible, Duration.ofSeconds(getPropertyInt(Config.TIMEOUT)));
    }

    public MyProjectsLeftSidebar getLeftSideBar() {
        return new MyProjectsLeftSidebar(pageWrapper);
    }

    public List<Project> getProjects() {
        return getPage().findAll(projectItems).stream().map(Project::new).collect(Collectors.toList());
    }

    public Project getProjectByName(String projectName) {
        return getSingleElementOfList(getProjects().stream().filter(project -> project.getNameValue().equals(projectName)).collect(Collectors.toList()));
    }

    public Project getProjectById(String projectId) {
        return getSingleElementOfList(getProjects().stream().filter(project -> project.getId().equals(projectId)).collect(Collectors.toList()));
    }

    public SelenideElement getNotification() {
        return $(notification).as("Notification on My projects page");
    }
}