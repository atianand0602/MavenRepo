package MavenTestCases;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class TestSeleCode {

@Test
	public static  void webTable()  {
	System.setProperty("WebDriver.Edge.driver", "C:\\browserdrivers\\edgedriver_win64\\msedgedriver.exe");
	EdgeDriver driver = new EdgeDriver();
	driver.manage().window().maximize();
//	driver.get("https://www.Google.com/");
//	driver.findElement(By.xpath("//div[text()='Accept all']")).click();
//	driver.findElement(By.xpath("//textarea[@class='gLFyf']"));
	//sendKeys("Berlin services",Keys.ENTER);
	//HOW TO RESIZE THE WINDOWS
//	int w= 400;
//	int l= 200;
//	Dimension d = new Dimension(w,l);
//	driver.manage().window().setSize(d);
	
	//How to send alt/shift/control key at once
	//	Actions a = new Actions(driver);	
  //   a.keyDown(Keys.ALT).keyDown(Keys.SHIFT).keyDown(Keys.CONTROL).sendKeys("test").build().perform();
	
	//How to upload file
	driver.get("https://www.adesso.de/de/jobs-karriere/unsere-stellenangebote/Senior-Software-Tester-QS-Spezialist-all-genders-fuer-die--de-f774.html?sid=ccebc6aeeac0fcc9e01c2344796ec449");
	driver.findElement(By.xpath("//button[text()='Accept all']")).click();
	driver.findElement(By.xpath("//input[@name='cv_lebenslauf']")).click();
	//.sendKeys("D:\\Ati\\Ati\\Presonal Doc\\Presonal Doc\\Basic doc\\Basic doc\\CVs\\6 plus years of Experiance in QA_5.pdf");
	
	//File scrshot= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	 
		
		
	}

private static void Actions() {
	// TODO Auto-generated method stub
	
}

}
