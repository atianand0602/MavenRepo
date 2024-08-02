package MavenTestCases;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import MavenPageObjects.LoginPage;

public class TC_Login_001 extends BaseClass{

	@Test
	public void LoginTest() throws IOException {
		
		logger.info("Url is open");
		LoginPage lp = new LoginPage(driver) ;
		lp.setUserName(username);
		logger.info("Entered username");
		lp.setpassword(password);
		logger.info("Entered password");
		lp.clickSubmit();
		logger.info("click on sigin");
		if(driver.getTitle().equals("Guru99 is totally new kind of learning experience.")) {
		Assert.assertTrue(true);
		logger.info("login test pass");
		}
		else {
			captureScreenshot(driver, "LoginPage");
			Assert.assertFalse(false);
			logger.info("login test fail");
		}
		
	}
}
