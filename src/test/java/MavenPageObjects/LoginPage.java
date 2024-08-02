package MavenPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
 WebDriver ldriver;
 public LoginPage(WebDriver rdriver){
	 ldriver=rdriver;
	 PageFactory.initElements(rdriver, this);
 }
 @FindBy(name="uid")
 @CacheLookup
 WebElement txtusername;
 
 @FindBy(name="password")
 @CacheLookup
 WebElement txtpassword;
 
 @FindBy(name="btnLogin")
 @CacheLookup
 WebElement SubmitLogin;
 
 @FindBy(xpath="/html/body/div[3]/div/ul/li[15]/a")
 @CacheLookup
 WebElement lnkLogout;
 
 public void setUserName(String uname) {
	 txtusername.sendKeys(uname);
 }
 public void setpassword(String pwd) {
	 txtpassword.sendKeys(pwd);
 }
 public void clickSubmit() {
	 SubmitLogin.click();
 }
 public void clickLogout() {
	 lnkLogout.click();
 }
}
