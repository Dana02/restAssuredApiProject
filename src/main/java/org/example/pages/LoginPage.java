package org.example.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$x;

public class LoginPage extends AbstractBasePage {

    private final SelenideElement pageWrapper = $x("//div[starts-with(@class,'authPageDecoratorWrapper')]");
    private final By loginFormTitle = By.xpath(".//p[contains(@class,'formTitle')]");
    private final By vistaLogo = By.xpath(".//a[@data-value='logo']");
    private final By cimpressIcon = By.xpath(".//*[contains(@data-src,'https://static.create.vista.com/images/logoVista.svg')]");
    private final By loginButton = By.xpath(".//button[@data-test='cimpress']");

    public SelenideElement getLoginButton() {
        return getPage().find(loginButton).as("Login button on Login page");
    }

    public SelenideElement getLoginFormTitle() {
        return getPage().find(loginFormTitle).as("login form title on Login page");
    }

    public SelenideElement getCimpressIcon() {
        return getPage().find(loginButton).find(cimpressIcon).as("Cimpress icon on login button");
    }

    public SelenideElement getVistaLogo() {
        return getPage().find(vistaLogo).as("Vista logo on Login page");
    }

    @Override
    public SelenideElement getPage() {
        return pageWrapper.as("Login page");
    }
}
