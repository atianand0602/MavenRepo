package MavenTestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class checkCssSelector {

	public static void main(String[] args) {
		System.setProperty("Webdriver.chrome.driver", "C:\\browserdrivers\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver =new ChromeDriver();
		//driver.get("https://www.Google.com");
		driver.get("https://www.facebook.com/login/");
		By ref2= new By.ByCssSelector("input");
		//WebElement element = driver.findElement(By.cssSelector("input"));
		//WebElement element = driver.findElement(By.cssSelector("textarea#APjFqb")); //Using the # symbol for id
		//WebElement element = driver.findElement(By.cssSelector("img.lnXdpd"));// using the .symbol for class
		//WebElement element = driver.findElement(By.cssSelector("input[type=password]")); //using type for facebook
		//WebElement element = driver.findElement(By.cssSelector("input[placeholder='Email address or phone number']")); // using placeholder for facebook login 
		//WebElement element = driver.findElement(By.cssSelector("input[name='email']")); // using name for facebook login 
		//WebElement element = driver.findElement(By.cssSelector(""));
		//element.sendKeys("Java");
	    driver.close();		
		}

	}


