package org.example.pages.objects;

import com.codeborne.selenide.SelenideElement;

public abstract class AbstractUiObject {

    private final SelenideElement container;

    public AbstractUiObject(SelenideElement container) {
        this.container = container;
    }

    public SelenideElement getContainer() {
        return container;
    }
}