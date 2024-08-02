package MavenAutomation;




import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;


public class GoogleSearch {
@Test
	public void GoogleSeatchTest() {
		System.setProperty("Webdriver.edge.driver", "C:\\browserdrivers\\edgedriver_win64\\msedgedriver.exe");
		EdgeDriver driver= new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.Google.com");
		driver.findElement(By.name("q")).sendKeys("Automation",Keys.ENTER);
		driver.close();
	}
}
