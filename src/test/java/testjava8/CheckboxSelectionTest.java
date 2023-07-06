package test;

import com.google.common.util.concurrent.Uninterruptibles;
import udemy.java.pages.TableDemoPage;
import udemy.java.supplier.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;

public class CheckboxSelectionTest {

    private WebDriver driver;
    private TableDemoPage tableDemoPage;

    @BeforeTest
    @Parameters("browser")
    public void setDriver(@Optional("chrome") String browser) {
        this.driver = DriverFactory.getDriver(browser);
        this.tableDemoPage = new TableDemoPage(driver);
    }

    @Test(dataProvider = "criteriaProvider")
    public void tableRowTest(Predicate<List<WebElement>> searchCriteria) {
        tableDemoPage.goTo();
        tableDemoPage.selectRows(searchCriteria);
        Uninterruptibles.sleepUninterruptibly(1, TimeUnit.SECONDS);

//        driver.findElements(By.tagName("tr"))
//                .stream()
//                .skip(1) //skip 1 el
//                .map(tr -> tr.findElements(By.tagName("td")))
//                .filter(tdList -> tdList.size() == 4) //continue only when size is 4
//                .filter(tdList -> tdList.get(1).getText().equalsIgnoreCase("male"))
//                .map(tdList -> tdList.get(3))
//                .map(td -> td.findElement(By.tagName("input")))
//                .forEach(WebElement::click);

    }

    @DataProvider(name = "criteriaProvider")
    public Object[] testdata() {
        return new Object[]{
                SearchCriteriaFactory.getCriteria("allMale"),
                SearchCriteriaFactory.getCriteria("allFemale"),
                SearchCriteriaFactory.getCriteria("allGender"),
                SearchCriteriaFactory.getCriteria("allAU"),
                SearchCriteriaFactory.getCriteria("allFemaleAU")
        };
    }

    @AfterTest
    public void quitDriver() {
        this.driver.quit();
    }
}
