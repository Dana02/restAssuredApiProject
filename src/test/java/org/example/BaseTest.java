package org.example;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest extends InitDriver {

    @BeforeClass
    public static void beforeAll() {
        setUpWebDriver();
        setupAllureListener();
        Selenide.clearBrowserCookies();
    }

    @AfterClass
    public void afterAll() {
        tearDown();
    }

    public static void setupAllureListener() {
        SelenideLogger.addListener("AllureSelenide",
                new AllureSelenide()
                        .screenshots(true)
                        .savePageSource(false)
                        .includeSelenideSteps(true));
    }


    //    @AfterSuite
    public void sendEmailReport() {
        String toEmail = "totek71712@youke1.com";
        String subject = "Test Results Report";
        String message = "Please find attached the test results report.";
        String filePath = "target/surefire-reports/emailable-report.html";
        //EmailReport.sendReportByEmail(toEmail, subject, message, filePath);
    }
}


