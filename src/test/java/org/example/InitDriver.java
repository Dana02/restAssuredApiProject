package org.example;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.apache.commons.lang3.BooleanUtils;
import org.example.enums.Config;

import static com.codeborne.selenide.AssertionMode.STRICT;
import static com.codeborne.selenide.TextCheck.FULL_TEXT;
import static org.example.utils.PropertyReader.getProperty;
import static org.example.utils.PropertyReader.getPropertyBoolean;

public class InitDriver {

    public static void setUpWebDriver() {
        System.setProperty("webdriver.chrome.silentOutput", BooleanUtils.TRUE);  //to hide warnings in the console
        Configuration.baseUrl = getProperty(Config.BASE_URL);
        Configuration.browser = getProperty(Config.BROWSER);
        Configuration.headless = getPropertyBoolean(Config.HEADLESS_MODE);
        Configuration.driverManagerEnabled = true;
        Configuration.assertionMode = STRICT;
        Configuration.textCheck = FULL_TEXT;
    }

    protected void tearDown() {
        Selenide.closeWebDriver();
    }
}


