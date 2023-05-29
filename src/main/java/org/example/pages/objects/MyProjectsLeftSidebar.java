package org.example.pages.objects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.List;

public class MyProjectsLeftSidebar extends AbstractUiObject {

    private final By folders = By.xpath(".//ul[starts-with(@class,'listFolders')]//div[contains(@class,'mainWrapper')]");
    private final By trashFolder = By.xpath(".//div[@data-test='createdFolder'][./button[@data-value='trash']]");

    public MyProjectsLeftSidebar(SelenideElement container) {
        super(container);
    }

    public SelenideElement getTrashFolder() {
        return getContainer().find(trashFolder);
    }

    public List<SelenideElement> getFolders() {
        return getContainer().findAll(folders);
    }
}