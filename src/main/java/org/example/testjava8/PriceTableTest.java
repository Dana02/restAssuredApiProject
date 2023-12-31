package org.example.testjava8;

import com.google.common.util.concurrent.Uninterruptibles;
import udemy.java.assignment.PriceTable;
import udemy.java.supplier.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class PriceTableTest {

    private WebDriver driver;

    @BeforeTest
    @Parameters("browser")
    public void setDriver(@Optional("chrome") String browser){
        this.driver = DriverFactory.getDriver(browser);
    }

    @Test
    public void minPriceTest(){
        PriceTable p = new PriceTable(driver);
        p.selectMinPriceRow();
        String status = p.getStatus();

        Assert.assertEquals("PASS", status);

        Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
    }

    @AfterTest
    public void quitDriver(){
        this.driver.quit();
    }

}
