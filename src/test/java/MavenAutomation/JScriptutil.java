package MavenAutomation;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JScriptutil {
	public static void flash(WebElement element,WebDriver driver) {
		JavascriptExecutor js= ((JavascriptExecutor)driver);
		String bgcolor=	element.getCssValue("backgroundcolor");
		for(int i=0;i<500;i++) {
			changeColor("rgb(0,200,0)",element,driver);
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
		public static void drawboarder(WebElement element, WebDriver driver) {
			JavascriptExecutor js= ((JavascriptExecutor)driver);
			js.executeScript("arguments[0].style.boarder='3px solid red'", element);
		}
}
