package MavenTestCases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Xpaths {
@Test
	public void webTable() {
		System.setProperty("Webdriver.chrome.driver", "C:\\browserdrivers\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		/*int rowcou= driver.findElements(By.xpath("//table[@id='customers']//tr")).size();
		int colcou= driver.findElements(By.xpath("//table[@id='customers']//th")).size();
		List<WebElement> ele1 = driver.findElements(By.xpath("//table[@id='customers']//tr[3]//td[3]"));
		Boolean ststus= false;
		for(WebElement res :ele1 ) {
			String result=res.getText();
			System.out.println(result);
			Assert.assertEquals(res.getText(), "Mexico","Element didn't matched");
			}*/
		/*List<WebElement> colvalue= driver.findElements(By.xpath("//table[@id='customers']//tr//td"));
		for(WebElement Actalcol : colvalue) {
			System.out.println(Actalcol.getText());*/
		
		}
		
		
		//driver.quit();
		//for(int i=1; i<rowcou; i++) {
		//for(int j=1; j<colcou; j++)	{
			
		//}
		//}
	}

