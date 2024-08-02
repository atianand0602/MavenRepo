package MavenTestCases;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class WaitsSample {

	public static void main(String[] args) {
			System.setProperty("Webdriver.chrome.driver", "C:\\browserdrivers\\chromedriver_win32\\chromedriver.exe");
			ChromeDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			driver.get("https://www.Google.com");
			WebElement element= driver.findElement(By.xpath("By.name(\"q\")"));
			element.sendKeys("Testing");
			element.submit();
			WebDriverWait wait = new WebDriverWait(driver, null, null);
			List<WebElement> element1 =wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.partialLinkText("Software testing - Wikipedia")));
			((WebElement) element1).click();
	
			

	}

}
