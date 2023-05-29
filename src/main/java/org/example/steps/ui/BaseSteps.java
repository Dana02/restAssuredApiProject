package org.example.steps.ui;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.example.enums.Config;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.refresh;
import static com.codeborne.selenide.Selenide.switchTo;
import static org.example.utils.PropertyReader.setProperty;

public class BaseSteps {

    public void waitAndClick(SelenideElement element) {
        element.shouldBe(Condition.enabled, Duration.ofSeconds(20)).click();
    }

    public SelenideElement waitForVisible(SelenideElement element) {
        return element.shouldBe(Condition.visible);
    }

    @Step
    public void refreshPage() {
        refresh();
    }

    @Step
    public void switchToNewTab() {
        switchTo().window(1);
    }

    @Step
    public void switchToParentTab() {
        switchTo().window(0);
    }

    public String getUserTokenFromCookies() {
        return Selenide.webdriver().driver().getWebDriver().manage().getCookieNamed("token").getValue();
    }

    public void storeUserTokenFromCookiesToProperty() {
        String userToken = getUserTokenFromCookies();
        setProperty(Config.TOKEN, userToken);
    }
}
