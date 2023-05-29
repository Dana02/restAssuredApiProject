package org.example.steps.ui;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import org.assertj.core.api.Assertions;
import org.example.pages.ArtBoardPage;

import java.io.File;

import static com.codeborne.selenide.Selenide.$x;

public class ArtBoardSteps extends BaseSteps {

    private final ArtBoardPage artBoard = new ArtBoardPage();

    @Step
    public void open() {
        String url = "/artboard/?width=1080&height=1080&group=SM&format=Instagram&measureUnits=px";
        Selenide.open(url);
    }

    @Step
    public void clickOnUploadsButton() {
        waitAndClick($x("//button[@data-value='closeModal']"));
        waitAndClick(artBoard.getUploadsButton());
    }

    @Step
    public void uploadImage(String pathToImage) {
        artBoard.getImageUploadsButton().uploadFile(new File(pathToImage));
    }

    @Step
    public void clickOnRemoveButton() {
        waitAndClick(artBoard.getRemoveIcon());
    }

    @Step
    public void assertCountOfUploadedFiles(int expectedCount) {
        int actualCountOfItems = artBoard.getUploadedItems().size();
        Assertions.assertThat(actualCountOfItems).as("Count of uploaded items is unexpected on ArtBoard page.").isEqualTo(expectedCount);
    }
}
