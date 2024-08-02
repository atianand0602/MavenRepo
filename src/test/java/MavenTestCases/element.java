package MavenTestCases;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;



public class element {
@Test
	public  void Table() {
		System.setProperty("Webdriver.chrome.driver", "C:\\browserdrivers\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		//driver.get("https://www.w3schools.com/html/html_tables.asp");
	  /*List<WebElement> allheaders= driver.findElements(By.xpath("//table[contains(@id ,'customers')]//th"));
				System.out.println(allheaders.size());
				Assert.assertEquals(allheaders.size(), 3);
				boolean status=false;
				for(WebElement ele : allheaders) {
					String value=ele.getText();
					System.out.println(value);
					if(value.contains("country")) {
						status=true;
						break;
					}
				}
				Assert.assertTrue(status, "Header is not present");*/
				/*System.out.println("-----------------------");
			List<WebElement> Noofrows=	driver.findElements(By.xpath("//table[contains(@id ,'customers')]//tr"));
			Assert.assertEquals(Noofrows.size(),7,"Table counts are mismatched");
			for(WebElement ele1 :Noofrows) {
				String value1= ele1.getText();
				System.out.println(value1);
			}
			System.out.println("-----------------------");*/
			/*List<WebElement> alldata=	driver.findElements(By.xpath("//table[contains(@id ,'customers')]//td"));
			boolean dataStatus=false;
			for(WebElement ele : alldata) {
				String value=ele.getText();
				System.out.println(value);
				if(value.contains("Germany1")) {
					dataStatus=true;
					break;
				}
			}
			Assert.assertTrue(dataStatus, "Data did not match");*/
	//List<WebElement> countryName=	driver.findElements(By.xpath("//table[contains(@id ,'customers')]//tr//td[3]"));
		//boolean dataStatus=false;
		//for(WebElement ele : countryName) {
			//String value=ele.getText();
			//System.out.println(value);
			/*if(value.contains("Italy")) {
				dataStatus=true;
				break;
			}*/
		//}
		//Assert.assertTrue(dataStatus, "Data did not match");
			//driver.quit();	
		
			//driver.get("https://datatables.net/extensions/select/examples/initialisation/checkbox.html");
			//driver.findElement(By.xpath("//td[text()='Bruno Nash']//preceding-sibling::td")).click();
			
		driver.get("http://www.techlistic.com/2017/02/automate-demo-web-table-with-selenium.html");
		List<WebElement> headerdata= driver.findElements(By.xpath("//table[@id='customers']//tr//td[2]"));
		for(WebElement hd:headerdata) {
			String hrd=hd.getText();
			System.out.println(hrd);
		}

	}

}
