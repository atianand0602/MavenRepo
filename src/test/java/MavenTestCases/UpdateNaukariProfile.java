package MavenTestCases;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class UpdateNaukariProfile {

	@Test
	
	public void updateNaukari() throws InterruptedException {
		System.setProperty("WebDriver.Edge.driver", "C:\\browserdrivers\\edgedriver_win64\\msedgedriver.exe");
		EdgeDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.naukri.com/nlogin/login");		 
		driver.findElement(By.id("usernameField")).sendKeys("atianand0602@gmail.com");
		driver.findElement(By.id("passwordField")).sendKeys("Riya@0602");
		driver.findElement(By.xpath("//button[text ()='Login']")).click();
		driver.findElement(By.xpath("//div[@class='view-profile-wrapper']")).click();
		driver.findElement(By.xpath("//em[text()='editOneTheme']")).click();
		driver.findElement(By.xpath("//input[@id='name']")).click();
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys(Keys.CONTROL,"a");	
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys(Keys.DELETE);	
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Ati Anand");
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		 //driver.findElement(By.xpath("//span[@class='ni-gnb-icn ni-gnb-icn-bell']")).click();
		 //driver.findElement(By.xpath("//div[text()='Recommended jobs' and @class='nI-gNb-nc__menu-item-lbl']")).click();
		 
		//driver.close();
		
		
		
		
	}
	
}
