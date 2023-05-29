package org.example.steps.ui;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.example.pages.VistaSignupPage;

public class VistaSignupSteps extends BaseSteps {

    private final VistaSignupPage vistaSignupPage = new VistaSignupPage();

    @Step
    public void assertGoogleButton(Condition expectedConditions) {
        vistaSignupPage.getGoogleButton().shouldBe(expectedConditions);
    }
}
