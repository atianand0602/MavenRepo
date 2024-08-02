package MavenTestCases;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class waitsample {
@Test

public static void impleciteWait() throws InterruptedException{
	System.setProperty("Webdriver.chrome.driver", "C:\\browserdrivers\\chromedriver_win32\\chromedriver.exe");
	ChromeDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	driver.get("https://www.irctc.co.in/nget/train-search");
	driver.findElement(By.partialLinkText("PNR STATUS")).click();
    Thread.sleep(2000);
    //Handling windows
	Set<String> windowshandls= driver.getWindowHandles();
	System.out.println(windowshandls);
	Iterator<String> iterator= windowshandls.iterator();
	String parentwindow= iterator.next();
	System.out.println(parentwindow);
	String childwindow= iterator.next();
	System.out.println(childwindow);
	driver.switchTo().window(childwindow);	
	driver.findElement(By.xpath("//a[text()= 'Indian Railways Enquiry']")).isDisplayed();
    driver.quit();
	
	}
}
