package org.example.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class HomePage extends AbstractBasePage {

    private final SelenideElement pageWrapper = $x("//div[starts-with(@class,'homeWrapper')]");

    @Override
    public SelenideElement getPage() {
        return pageWrapper.as("Home page");
    }
}
