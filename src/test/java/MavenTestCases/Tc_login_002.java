package MavenTestCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import MavenPageObjects.LoginPage;
import Mavenutility.XLUtils;


public class Tc_login_002 extends BaseClass {
	@Test(dataProvider="Logindata")
	
	public void LoginDDT(String user, String psw) throws InterruptedException {
		LoginPage lp= new LoginPage(driver);
		lp.setUserName(user);
		logger.info("user name provided");
		lp.setpassword(psw);
		logger.info("password provided");
		lp.clickSubmit();
		Thread.sleep(3000);
		if(isAlertPresent()==true) {
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warn("login failed");
		}
		else {
			Assert.assertTrue(true);
			logger.warn("login passed");
			
			lp.clickLogout();
			Thread.sleep(3000);
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		}
		
	}
	 public boolean isAlertPresent() {  // user define method to check alert
		 try {
			 driver.switchTo().alert();
			 return true;
		 }
		 catch(NoAlertPresentException e){
			 return false;
		 }
	 }
	
	
	@DataProvider(name="Logindata")
	String[][] getData() throws IOException{
		String path= System.getProperty("user.dir") +"/src/test/java/MavenTestData/XLtestdata.xlsx";
		int rownum= XLUtils.getRowCount(path, "Sheet1");
		int colnum= XLUtils.getCellCount(path, "sheet1", 1);
		String Logindata[][]= new String[rownum][colnum];
		for(int i=1;i<=rownum;i++) {
			for(int j=0;j<colnum;j++) {
				Logindata[i-1][j]=XLUtils.getCelldata(path, "Sheet1", i, j);
			}
		}
		return Logindata;
	}

}
