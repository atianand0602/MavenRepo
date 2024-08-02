package Mavenutility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting extends TestListenerAdapter{
 public ExtentHtmlReporter htmlReporter;
 public ExtentReports extent;
 public ExtentTest Logger;
 
 public void onStart(ITestContext testcontext) {
	 String timeStamp= new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
	 String repName= "Test_Report " + timeStamp + ".html ";
	 htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+ "/test_output/"+ repName);
	 htmlReporter.loadConfig(System.getProperty("user.dir")+ "/extent-config.html");
	 extent= new ExtentReports();
	 extent.attachReporter(htmlReporter);
	 extent.setSystemInfo("Host Name", "LocalHost");
	 extent.setSystemInfo("Environment", "QA");
	 extent.setSystemInfo("user", "Ati");
	 
	 htmlReporter.config().setDocumentTitle("Maven Project"); // title of report
	 htmlReporter.config().setReportName("functional test automation report"); // name of report
	 htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP); // location of report
	 htmlReporter.config().setTheme(Theme.DARK);
	 
 } 
 public void onTestSuccess(ITestResult tr) {
	 Logger=extent.createTest(tr.getName()); // create new entry in report
	 Logger.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN)); // send the pass information
	 	 
 }
 public void onTestFailure(ITestResult tr) {
	 Logger=extent.createTest(tr.getName()); // create new entry in report
	 Logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED)); // send the fail information
	 	 String screenshotpath=System.getProperty("user.dir") + "\\ScreenShots\\" + tr.getName()+ ".png";
	 	 File f= new File (screenshotpath);
	 	 if(f.exists()) {
	 		 try {
	 			 Logger.fail("Screenshot is below: "+ Logger.addScreenCaptureFromPath(screenshotpath));
	 		 }
	 		 catch(IOException e){
	 			 e.printStackTrace();
	 		 }
	 	 }
 }
 public void onTestSkipped(ITestResult tr) {
	 Logger=extent.createTest(tr.getName());
	 Logger.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));
 }
 public void onFinish(ITestContext testcontext) {
	 extent.flush();
 }
}
