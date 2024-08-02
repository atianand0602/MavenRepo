To automate this test scenario using Java, I will use Selenium WebDriver for browser automation and TestNG as the test framework. The focus will be on maintainability and reusability of the test code by following good practices like page object model (POM), separating test data, and using utility methods.

Here’s a step-by-step guide and the necessary code to achieve the task:

Step 1: Project Setup
Create a new Maven project.
Add dependencies for Selenium, TestNG, and WebDriverManager to the pom.xml.
xml
 
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <groupId>com.betterroaming</groupId>
    <artifactId>betterroaming-automation</artifactId>
    <version>1.0-SNAPSHOT</version>
    <dependencies>
        <!-- Selenium -->
        <dependency>
            <groupId>org.seleniumhq.selenium</groupId>
            <artifactId>selenium-java</artifactId>
            <version>4.5.0</version>
        </dependency>
        <!-- TestNG -->
        <dependency>
            <groupId>org.testng</groupId>
            <artifactId>testng</artifactId>
            <version>7.4.0</version>
            <scope>test</scope>
        </dependency>
        <!-- WebDriverManager -->
        <dependency>
            <groupId>io.github.bonigarcia</groupId>
            <artifactId>webdrivermanager</artifactId>
            <version>5.3.0</version>
        </dependency>
    </dependencies>
    <build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-surefire-plugin</artifactId>
                <version>2.22.2</version>
                <configuration>
                    <suiteXmlFiles>
                        <suiteXmlFile>testng.xml</suiteXmlFile>
                    </suiteXmlFiles>
                </configuration>
            </plugin>
        </plugins>
    </build>
</project>
Step 2: Create Page Object Model (POM)
Create a package com.betterroaming.pages and add the necessary page classes.

BasePage.java
java

package com.betterroaming.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
HomePage.java
java
 
package com.betterroaming.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(id = "currency-selector")
    private WebElement currencySelector;

    @FindBy(xpath = "//a[text()='Thailand']")
    private WebElement thailandLink;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void selectCurrency(String currency) {
        currencySelector.click();
        currencySelector.findElement(By.xpath("//option[text()='" + currency + "']")).click();
    }

    public void clickOnThailand() {
        thailandLink.click();
    }
}
PlanPage.java
java
 
package com.betterroaming.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PlanPage extends BasePage {

    @FindBy(xpath = "(//div[@class='plan'])[2]//div[@class='country']")
    private WebElement secondPlanCountry;

    @FindBy(xpath = "(//div[@class='plan'])[2]//div[@class='data']")
    private WebElement secondPlanData;

    @FindBy(xpath = "(//div[@class='plan'])[2]//div[@class='validity']")
    private WebElement secondPlanValidity;

    @FindBy(xpath = "(//div[@class='plan'])[2]//div[@class='plan-type']")
    private WebElement secondPlanType;

    @FindBy(xpath = "(//div[@class='plan'])[2]//div[@class='price']")
    private WebElement secondPlanPrice;

    public PlanPage(WebDriver driver) {
        super(driver);
    }

    public String getSecondPlanCountry() {
        return secondPlanCountry.getText();
    }

    public String getSecondPlanData() {
        return secondPlanData.getText();
    }

    public String getSecondPlanValidity() {
        return secondPlanValidity.getText();
    }

    public String getSecondPlanType() {
        return secondPlanType.getText();
    }

    public String getSecondPlanPrice() {
        return secondPlanPrice.getText();
    }
}
Step 3: Create the Test
Create a package com.betterroaming.tests and add the test class.

BetterRoamingTest.java
java
 
package com.betterroaming.tests;

import com.betterroaming.pages.HomePage;
import com.betterroaming.pages.PlanPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BetterRoamingTest {

    private WebDriver driver;
    private HomePage homePage;
    private PlanPage planPage;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.betterroaming.com/");
        homePage = new HomePage(driver);
        planPage = new PlanPage(driver);
    }

    @Test
    public void validateSecondPlanDetails() {
        homePage.selectCurrency("Euro");
        homePage.clickOnThailand();

        String expectedCountry = "Thailand";
        String expectedData = "5GB";
        String expectedValidity = "30 days";
        String expectedPlanType = "data only";
        String expectedPrice = "9,29 €";  // Update the expected price dynamically if needed

        Assert.assertEquals(planPage.getSecondPlanCountry(), expectedCountry, "Country mismatch");
        Assert.assertEquals(planPage.getSecondPlanData(), expectedData, "Data mismatch");
        Assert.assertEquals(planPage.getSecondPlanValidity(), expectedValidity, "Validity mismatch");
        Assert.assertEquals(planPage.getSecondPlanType(), expectedPlanType, "Plan type mismatch");
        Assert.assertEquals(planPage.getSecondPlanPrice(), expectedPrice, "Price mismatch");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
Step 4: Create TestNG XML Suite
Create a testng.xml file in the root directory.

xml
 
<!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd">
<suite name="BetterRoamingSuite">
    <test name="BetterRoamingTests">
        <classes>
            <class name="com.betterroaming.tests.BetterRoamingTest"/>
        </classes>
    </test>
</suite>
Step 5: Run the Tests
You can run the tests using Maven with the following command:

sh
 
mvn clean test
