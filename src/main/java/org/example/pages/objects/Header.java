package org.example.pages.objects;

import com.codeborne.selenide.SelenideElement;
import org.example.pages.AbstractBasePage;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$x;

public class Header extends AbstractBasePage {

    private final SelenideElement headerWrapper = $x("//div[@class='header-container'] | //div[starts-with(@class,'headerWrapper')]");
    private final By myProjectsButton = By.xpath(".//a[@data-value='link_myDesigns']");
    private final By userMenu = By.xpath(".//div[@data-tooltip='userMenu']");
    private final By loginButton = By.xpath(".//button[@data-value='signIn']");
    private final By signUpButton = By.xpath(".//button[@data-value='signUp']");

    public SelenideElement getSignUpButton() {
        return getPage().find(signUpButton).as("Signup button on Header");
    }

    public SelenideElement getLoginButton() {
        return getPage().find(loginButton).as("Login button on on Header");
    }

    public SelenideElement getUserMenu() {
        return getPage().find(userMenu).as("User menu on Header");
    }

    public SelenideElement getMyProjectsButton() {
        return getPage().find(myProjectsButton).as("My projects button on Header");
    }

    @Override
    public SelenideElement getPage() {
        return headerWrapper;
    }
}
