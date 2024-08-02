package MavenTestCases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Xpath2 {
@Test
	public void webTable1() {
		System.setProperty("Webdriver.chrome.driver", "C:\\browserdrivers\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		List<WebElement> col= driver.findElements(By.xpath("//table[@id='customers']/tbody//tr"));	
		 List<WebElement> row = driver.findElements(By.xpath("//table[@id='customers']/tbody//tr//th"));
		System.out.println("The column size is" + col.size());
		System.out.println("The ROW size is" + row.size());
		
		/*String beforexpath = "//table[@id='customers']/tbody//tr[";
		String afterxpath= "]/td[1]";
		for (int i=2; i<=7; i++) {
		String actualxpath = beforexpath +i+ afterxpath;	
		WebElement element= driver.findElement(By.xpath(actualxpath));
		System.out.println(element.getText());
		
		}*/
		for(int i=2; i<=7;i++) {
		for (int j=1;j<=3;j++)	{
		String actualval=	driver.findElement(By.xpath("//table[@id='customers']/tbody//tr[" + i + "]/td[" + j + "]")).getText();
		System.out.println(actualval);
		if(actualval.equals("Italy")) {
			System.out.println(i+ " :"+j);
			break;
		}
		
		//driver.close();		
}
		}
		}
		
}

