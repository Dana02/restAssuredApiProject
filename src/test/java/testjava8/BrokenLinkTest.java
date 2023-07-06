package test;

import udemy.java.supplier.DriverFactory;
import udemy.java.util.LinkUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class BrokenLinkTest {

    private WebDriver driver;

    @BeforeTest
    @Parameters("browser")
    public void setDriver(@Optional("chrome") String browser) {
        this.driver = DriverFactory.getDriver(browser);
    }

    // https://the-internet.herokuapp.com/broken_images

    @Test
    public void linkTest() {
        this.driver.get("https://www.google.com");

        System.out.println("Before :: " + LocalDateTime.now());

        List<String> list = this.driver.findElements(By.xpath("//*[@href]"))
                .stream()
                .parallel()
                .map(e -> e.getAttribute("href"))
                .filter(src -> LinkUtil.getResponseCode(src) != 200)
                .collect(Collectors.toList());

        System.out.println("After :: " + LocalDateTime.now());


//        this.driver.findElements(By.xpath("//*[@src]"))
//                .stream()
//                .parallel()
//                .map(e -> e.getAttribute("src"))
//                .map(LinkUtil::getResponseCode)
//                .anyMatch(response -> response != 200);
    }

    @AfterTest
    public void quitDriver() {
        this.driver.quit();
    }
}
