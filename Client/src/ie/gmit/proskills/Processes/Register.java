package ie.gmit.proskills.Processes;

import ie.gmit.proskills.serverconn.Requester;

public class Register {

	public static boolean main(String username, String password) {
		
		String messageSend = "register " + username + " " + password;
		   
	   	Requester.main(messageSend);
	   	
		return false;
	}

}
