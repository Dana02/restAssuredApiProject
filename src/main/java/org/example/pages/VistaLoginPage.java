package org.example.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$x;

public class VistaLoginPage extends AbstractBasePage {

    private final SelenideElement pageWrapper = $x("//div[@id='root']");
    private final By emailInput = By.id("sign-in-email");
    private final By passwordInput = By.id("signInPassword");
    private final By loginButton = By.name("submit");
    private final By alertEmailFieldValidation = By.cssSelector(".swan-form .swan-input-group-error-text");
    private final By googleButton = By.xpath(".//button[@data-testid='google-signIn']");

    public SelenideElement getGoogleButton() {
        return getPage().find(googleButton).as("Google button on VistaLogin page");
    }

    public SelenideElement getEmailInput() {
        return getPage().find(emailInput).as("Email input on VistaLogin page");
    }

    public SelenideElement getPasswordInput() {
        return getPage().find(passwordInput).as("Password input on VistaLogin page");
    }

    public SelenideElement getLoginButton() {
        return getPage().find(loginButton).as("Login button VistaLogin page");
    }

    public SelenideElement getAlertEmailFieldValidation() {
        return getPage().find(alertEmailFieldValidation).as("Sign in failed alert on Vista login page");
    }

    @Override
    public SelenideElement getPage() {
        return pageWrapper.as("Vista auth page");
    }
}
