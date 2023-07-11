package org.example.testjava8;

import udemy.java.predicate.Rules;
import udemy.java.supplier.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import java.util.List;
import java.util.function.Predicate;

public class DriverTest {

    private WebDriver driver;

    @BeforeTest
    @Parameters("browser")
    public void setDriver(@Optional("chrome") String browser) {
        this.driver = DriverFactory.getDriver(browser);
    }

    // https://the-internet.herokuapp.com/broken_images

    @Test
    public void googleTest() {
        this.driver.get("https://google.com/");
        this.driver.findElements(By.tagName("a"))
                .stream()
                .map(WebElement::getText)
                .map(String::trim)
                .filter(e -> e.length() > 0)
                .filter(e -> !e.toLowerCase().contains("s"))
                .map(String::toUpperCase)
                .forEach(System.out::println);

        //without rule class
        List<WebElement> elements = driver.findElements((By.tagName("a")));
        Predicate<WebElement> isBlank = (e) -> e.getText().trim().length() == 0;
        Predicate<WebElement> hasS = (e) -> e.getText().toLowerCase().contains("s");
        elements.removeIf(isBlank);
        elements.removeIf(hasS);
        elements.forEach(System.out::println);
        //the same but with rule class
        Rules.get().forEach(elements::removeIf);//for each element remove if rule is satisfied
    }

    @AfterTest
    public void quitDriver() {
        this.driver.quit();
    }

}
