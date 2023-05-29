package org.example.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$x;

public class VistaSignupPage extends AbstractBasePage {

    private final SelenideElement pageWrapper = $x("//div[@id='root']");
    private final By googleButton = By.xpath(".//button[@data-testid='google-signUp']");

    public SelenideElement getGoogleButton() {
        return getPage().find(googleButton).as("Google button on VistaSignup page");
    }

    @Override
    public SelenideElement getPage() {
        return pageWrapper.as("Vista auth page");
    }
}
