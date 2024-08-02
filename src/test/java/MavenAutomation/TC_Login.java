package MavenAutomation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class TC_Login {
@Test
	public void login_Test() {
	    System.setProperty("Webdriver.chrome.driver", "C:\\browserdrivers\\chromedriver_win32\\chromedriver.exe");
	    ChromeOptions opt = new ChromeOptions();
	    opt.addArguments("--remote-allow-origins=*");
	    ChromeDriver driver= new ChromeDriver(opt);
	    driver.manage().window().maximize();
		driver.get("https://www.Google.com");
		driver.findElement(By.partialLinkText("Gmail")).click();	
		driver.findElement(By.xpath("//a[text()='Sign in']")).click();
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("ati.anand0602@gmail.com");
	    driver.findElement(By.xpath("//span[text()='Next']")).click();
	    WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5000));
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Riyayadav@0602");
		driver.findElement(By.xpath("//span[text()='Next']")).click();
		driver.close();
		}
}
