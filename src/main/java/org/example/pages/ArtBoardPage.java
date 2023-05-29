package org.example.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Selenide.$x;
import static org.example.utils.ListUtils.getFirstElementOfList;

public class ArtBoardPage extends AbstractBasePage {

    private final SelenideElement pageWrapper = $x("//div[starts-with(@class,'mainView')]");
    private final By uploadsButton = By.xpath(".//button[@data-test='library']");
    private final By imageUploads = By.xpath(".//input[@type='file'][@autocomplete]");
    private final By uploadedItems = By.xpath(".//li[starts-with(@class,'resultContentItem')]");
    private final By removeFileButton = By.xpath(".//button[@data-value='imageRemoveButton']");

    @Override
    public SelenideElement getPage() {
        return pageWrapper;
    }

    public SelenideElement getUploadsButton() {
        return getPage().find(uploadsButton).as("Upload button on left side bar");
    }

    public SelenideElement getImageUploadsButton() {
        return getPage().find(imageUploads).as("Image uploads button on left side bar");
    }

    public List<SelenideElement> getUploadedItems() {
        return getPage().findAll(uploadedItems).as("uploaded items");
    }

    public SelenideElement getRemoveIcon() {
        return getFirstElementOfList(getUploadedItems()).find(removeFileButton).as("Remove file button");
    }
}
