package org.example.steps.ui;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import org.example.pages.MainPage;

public class MainSteps extends BaseSteps {

    private final MainPage mainPage = new MainPage();

    @Step
    public void open() {
        Selenide.open("/");
    }
}
