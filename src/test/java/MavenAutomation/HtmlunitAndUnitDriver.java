package MavenAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class HtmlunitAndUnitDriver {

	/*@Test
	public void homePage() throws Exception {
	    try (final WebClient webClient = new WebClient()) {
	        final HtmlPage page = webClient.getPage("https://htmlunit.sourceforge.io/");
	        Assert.assertEquals("HtmlUnit – Welcome to HtmlUnit", page.getTitleText());

	        final String pageAsXml = page.asXml();
	        Assert.assertTrue(pageAsXml.contains("<body class=\"topBarDisabled\">"));
      
	    }
	}*/
	@Test
 public void GoogleTest() {
		WebDriver driver = new HtmlUnitDriver();
		driver.get("https://www.google.com/");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		driver.findElement(By.className("gLFyf")).sendKeys("Germany", Keys.ENTER);
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		
	}
	@Test
	public void htmlUnitDriverTest(){
		
		//Instantiating HtmlUnitDriver
		WebDriver driver = new HtmlUnitDriver(BrowserVersion.getDefault());
					      
		//Navigate to ArtOfTesting.com		
		driver.get("https://artoftesting.com");
		
		//Printing page title
		System.out.println(driver.getTitle());
	}
	
}
	

