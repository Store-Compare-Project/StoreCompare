package ie.gmit.proskills.Processes;

import ie.gmit.proskills.object.LoginObject;
import ie.gmit.proskills.serverconn.Requester;

public class HistoryAdd {

	public static String main(String username) {
			   
		String messageSend = "login " + username + " " + password;
	   
	   	Requester.main(messageSend);
		
		return LoginObject.getLogin();
	}
}