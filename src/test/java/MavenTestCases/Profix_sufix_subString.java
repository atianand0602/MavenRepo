package MavenTestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Profix_sufix_subString {

	public static void main(String[] args) {
		System.setProperty("Webdriver.chrome.driver", "C:\\browserdrivers\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver =new ChromeDriver();
		//driver.get("https://www.Google.com");
		driver.get("https://www.facebook.com/login/");
		//driver.get("https://www.Google.com");
		By ref2= new By.ByCssSelector("input");
		//WebElement element = driver.findElement(By.cssSelector("input[name$=ail]")); //matches suffix =>last
		//WebElement element = driver.findElement(By.cssSelector("input[name^=ema]")); //matches prefix => 1st char
		WebElement element = driver.findElement(By.cssSelector("input[class*=_55r1][id^=em]")); //matches substring => middle char
		//WebElement element = driver.findElement(By.cssSelector("input[class^='inputtext'][name$=ail]")); 
		element.sendKeys("Java");
	    //driver.close();	
	}

}
