package org.example.pages;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.example.enums.Config;

import java.time.Duration;

import static org.example.utils.PropertyReader.getPropertyInt;

public abstract class AbstractBasePage {

    public AbstractBasePage() {
        Configuration.timeout = Duration.ofSeconds(getPropertyInt(Config.TIMEOUT)).toMillis();
    }

    public abstract SelenideElement getPage();
}
