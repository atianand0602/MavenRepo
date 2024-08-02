package MavenTestCases;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Practice {
	@Test
	public static void ExpliciteWait() throws InterruptedException  {
	System.setProperty("Webdriver.Edge.driver", "C:\\browserdrivers\\edgedriver_win64\\msedgedriver.exe");
	EdgeDriver driver= new EdgeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.flipkart.com/");
	WebElement placetaext=driver.findElement(By.name("q"));
	System.out.println(placetaext.getAttribute("placeholder"));
	
	
	
	
		
	}
}

