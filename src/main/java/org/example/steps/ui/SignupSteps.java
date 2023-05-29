package org.example.steps.ui;

import io.qameta.allure.Step;
import org.example.pages.SignupPage;

public class SignupSteps extends BaseSteps {

    private final SignupPage signupPage = new SignupPage();

    @Step
    public void clickOnCreateAccountButton() {
        waitAndClick(signupPage.getCreateAccountButton());
    }

}
