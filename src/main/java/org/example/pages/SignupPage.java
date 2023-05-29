package org.example.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$x;

public class SignupPage extends AbstractBasePage {

    private final SelenideElement pageWrapper = $x("//div[starts-with(@class,'authPageDecoratorWrapper')][//button[@data-categ='signUpPage']]");
    private final By createAccountButton = By.xpath(".//button[@data-categ='signUpPage']");

    @Override
    public SelenideElement getPage() {
        return pageWrapper;
    }

    public SelenideElement getCreateAccountButton() {
        return getPage().find(createAccountButton).as("Create account button on SignUp page");
    }
}
