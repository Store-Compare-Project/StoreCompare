package ie.gmit.proskills.Processes;

import com.mongodb.*;

import ie.gmit.proskills.object.LoginObject;
import ie.gmit.proskills.serverconn.Requester;

public class Login {
	
	public static Boolean loginStatus = false;

	@SuppressWarnings("deprecation")
	public static Boolean main(String username, String password) {
			   
	   String messageSend = "login " + username + " " + password;
	   
	   Requester.main(messageSend);
	   
	   System.out.println(loginStatus);
			   
		
		
		
		return LoginObject.getLogin();
	}
}
