package ie.gmit.proskills.Processes;

import ie.gmit.proskills.object.LoginObject;
import ie.gmit.proskills.serverconn.Requester;

/**
 * This class is responsible for logging the user into the system. <br>
 * 
 * @author Cian Gannon
 * @author Danielis Joniškis
 * @author Eddie Eldridge
 */

public class Login {
	
	/**
	 * Method sends the username and password to the Requester.
	 * 
	 * @param username
	 *            The username provided by the user
	 * @param password
	 *            The password provided by the user
	 * @return returns the login details
	 */
	

	public static Boolean main(String username, String password) {
			   
		String messageSend = "login " + username + " " + password;
	   
	   	Requester.main(messageSend);
		
		return LoginObject.getLogin();
	}
}