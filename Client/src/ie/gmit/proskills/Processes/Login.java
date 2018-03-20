package ie.gmit.proskills.Processes;

import com.mongodb.*;

import ie.gmit.proskills.serverconn.Requester;

public class Login {
	
	Boolean loginStatus;

	@SuppressWarnings("deprecation")
	public static Boolean main(String username, String password) {
		
		Boolean loginStatus = false;
		
		try {
			   
		   String messageSend = "login " + username + " " + password;
		   
		   
		   
		   Requester.main(messageSend);
		   
		   System.out.println(loginStatus);
			   
		} finally {
		   cursor.close();
		}
		
		
		return loginStatus;
	}
}
