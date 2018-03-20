package ie.gmit.proskills.Processes;

import ie.gmit.proskills.object.LoginObject;
import ie.gmit.proskills.serverconn.Requester;

public class Login {

	public static Boolean main(String username, String password) {
			   
		String messageSend = "login " + username + " " + password;
	   
	   	Requester.main(messageSend);
		
		return LoginObject.getLogin();
	}
}