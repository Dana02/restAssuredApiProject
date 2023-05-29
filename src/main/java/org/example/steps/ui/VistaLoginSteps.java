package org.example.steps.ui;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.example.pages.VistaLoginPage;

public class VistaLoginSteps extends BaseSteps {

    private final VistaLoginPage vistaLoginPage = new VistaLoginPage();

    @Step
    public void setEmail(String email) {
        vistaLoginPage.getEmailInput().shouldBe(Condition.enabled).setValue(email);
    }

    @Step
    public void setPassword(String password) {
        vistaLoginPage.getPasswordInput().setValue(password);
    }

    @Step
    public void clickOnLoginButton() {
        vistaLoginPage.getLoginButton().click();
    }

    @Step
    public void assertSignInFailedAlert(Condition expectedVCondition) {
        vistaLoginPage.getAlertEmailFieldValidation().shouldBe(expectedVCondition);
    }

    @Step
    public void assertGoogleButton(Condition expectedConditions) {
        vistaLoginPage.getGoogleButton().shouldBe(expectedConditions);
    }
}
