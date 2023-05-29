package org.example.steps.ui;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.assertj.core.api.Assertions;
import org.example.pages.LoginPage;

public class LoginSteps extends BaseSteps {

    private final LoginPage loginPage = new LoginPage();

    @Step
    public void clickOnLoginButton() {
        waitAndClick(loginPage.getLoginButton());
    }

    @Step
    public void assertLoginFormTitle(String expectedTitle) {
        String actualTitle = loginPage.getLoginFormTitle().getText();
        Assertions.assertThat(actualTitle).as("Verify login form title").isEqualTo(expectedTitle);
    }

    @Step
    public void asserCimpressIconOnLoginButton(Condition expectedCondition) {
        loginPage.getCimpressIcon().shouldBe(expectedCondition);
    }

    @Step
    public void asserVistaLogo(Condition expectedCondition) {
        loginPage.getVistaLogo().shouldBe(expectedCondition);
    }
}
