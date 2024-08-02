package MavenAutomation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class GetwindowHandleandHandles {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.opencart.com/");
		//getwindowhandle()
		 //String windowID=driver.getWindowHandle();
		//System.out.println("Window is is " +windowID);
		driver.findElement(By.xpath("//a[text()='Linkedin']")).click();
		//getwindowhandles
		
		
		Set<String> windowIDs=driver.getWindowHandles();
		
		//first method iterator
		
		/*Iterator<String> it=windowIDs.iterator();
		String parentID=it.next();
		String childID= it.next();
		System.out.println("Window is is " +parentID);
		System.out.println("Window is is " +childID);*/
		
		//2nd method list/ArrayList
		
		List<String> windowIDsList = new ArrayList(windowIDs); //converting set into list
		/*String parentID=windowIDsList.get(0);
		String childID=windowIDsList.get(1);
		System.out.println("Parent Window is  " +parentID);
		System.out.println("child Window is  " +childID);
		
		//how to use window ID'f for switching
		
		driver.switchTo().window(parentID);
		System.out.println("parent window's title is" +driver.getTitle());
		driver.switchTo().window(childID);		
		System.out.println("child windows title is" +driver.getTitle());*/
		//for each loop
		/*for(String wind:windowIDsList) {
			String title=driver.switchTo().window(wind).getTitle();
			System.out.println(title);			
		}	*/
		
		//driver.close(); //will close only current window
		//driver.quit(); // will close entire window
		for(String wind:windowIDsList) {
			String title=driver.switchTo().window(wind).getTitle();
			if(title.equals("OpenCart - Open Source Shopping Cart Solution")|| title.equals("LinkedIn Login, Sign in | LinkedIn")) {
				driver.close();
			}
		}
			}

}
