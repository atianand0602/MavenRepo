package mavenAutomation;

import java.util.ResourceBundle;

public class App {

	public int userLogin(String in_user, String in_psw) {
		ResourceBundle rb=ResourceBundle.getBundle("config");
		String userName=rb.getString("username");
		String password=rb.getString("password");
		if(in_user.equals(userName) && in_psw.equals(password))
			return 1;
			else 
				return 0;
			
	}
}
