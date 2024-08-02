package Mavenutility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class Readconfig {
  Properties pro;
  public Readconfig() {
	  File src = new File("./Configuration/config.properties");
	  try {
		  FileInputStream frs = new FileInputStream(src);
		  pro = new Properties();
		  pro.load(frs);
	  }catch(Exception e){
		  System.out.println("exception is " + e.getMessage());
		  
	  }
	  
  }
  public String  getApplicationurl() {
	 String url= pro.getProperty("BaseURL");
	 return url;	  
  }
  public String  getusername() {
		 String username= pro.getProperty("username");
		 return username;	  
	  }
  public String  getpassword() {
		 String password= pro.getProperty("password");
		 return password;	  
	  }
  public String  getchromepath() {
		 String chromepath= pro.getProperty("chromepath");
		 return chromepath;	  
	  }
  public String  getmsedgepath() {
		 String msedgepath= pro.getProperty("msedgepath");
		 return msedgepath;	  
	  }
}
