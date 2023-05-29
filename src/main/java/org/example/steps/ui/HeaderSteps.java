package org.example.steps.ui;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.example.pages.objects.Header;

public class HeaderSteps extends BaseSteps {

    private final Header header = new Header();

    @Step
    public void clickOnLogInButton() {
        waitAndClick(header.getLoginButton());
    }

    @Step
    public void clickOnSignUpButton() {
        waitAndClick(header.getSignUpButton());
    }

    @Step
    public void clickOnMyProjectsButton() {
        header.getMyProjectsButton().click();
    }

    @Step
    public void assertUserMenu(Condition expectedCondition) {
        header.getUserMenu().shouldBe(expectedCondition);
    }

    @Step
    public void clickOnUserMenuButton() {
        waitAndClick(header.getUserMenu());
    }
}
