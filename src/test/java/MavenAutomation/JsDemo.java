package MavenAutomation;

import org.apache.xmlbeans.soap.SOAPArrayType;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class JsDemo {

	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		System.setProperty("Webdriver.chrome.driver", "C:\\browserdrivers\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver= new ChromeDriver(options);
        driver.get("https://classic.freecrm.com/");
        driver.manage().window().maximize();
        
        //flashing
       driver.findElement(By.name("username")).sendKeys("ati0602");
       driver.findElement(By.name("password")).sendKeys("Riya@0602");
       //driver.findElement(By.xpath("//input[@value='Login']")).click();
       WebElement loginbtn =driver.findElement(By.xpath("//input[@value='Login']"));  
       System.out.println(loginbtn.isDisplayed());
       flash(loginbtn, driver);
       
        
        //Drowning boarder
        //JScriptutil.drawboarder(Joinnowforfree, driver);

	}

	public static void flash(WebElement element,WebDriver driver) {
		JavascriptExecutor js= ((JavascriptExecutor)driver);
		String bgcolor=	element.getCssValue("backgroundcolor");
		for(int i=0;i<100;i++) {
			changeColor("rgb(255, 0, 0)",element,driver);
			changeColor(bgcolor,element,driver);
			
		}
		}
		
		public static void changeColor(String color,WebElement element, WebDriver driver) {
			JavascriptExecutor js= ((JavascriptExecutor)driver);
			js.executeScript("arguments[0].style.backgroundcolor=  '" +color + "'", element);
			try {
				Thread.sleep(20);
			}catch(InterruptedException e) {
				
			}
}
}
