package mavenAutomation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
	protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

	public BasePage(WebDriver driver2) {
		// TODO Auto-generated constructor stub
	}
}
