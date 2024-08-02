package MavenTestCases;


import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.utils.FileUtil;

import Mavenutility.Readconfig;



public class BaseClass {
	Readconfig readconfig= new  Readconfig();
	public String BaseURL= readconfig.getApplicationurl();
	public String username=readconfig.getusername();
	public String password=readconfig.getpassword();
	public static WebDriver driver;
	public static Logger logger;
	@Parameters("browser")
	@BeforeClass
	public void setup(String br){
		logger =Logger.getLogger("BaseClass");
		PropertyConfigurator.configure("log4j.properties");
		if(br.equals("chrome")) {
		System.setProperty("WebDriver.driver.chromeDriver",readconfig.getchromepath());
		driver=new ChromeDriver();		
	}
	    else if(br.equals("msedge"))
	{
		System.setProperty("WebDriver.driver.msedgeriver",readconfig.getmsedgepath());
		driver=new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
		driver.get(BaseURL);
}
	
	@AfterClass
	public void tesrdown() {
		driver.quit();
	}
	public void captureScreenshot(WebDriver driver, String tname) throws IOException{
		TakesScreenshot ts= (TakesScreenshot)driver;
		File source= ts.getScreenshotAs(OutputType.FILE);
		File target= new File(System.getProperty("user.dir") + "/screenshot/" +tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("screenshot taken");
		
	}

	private TakesScreenshot driver() {
		// TODO Auto-generated method stub
		return null;
	}
	}

