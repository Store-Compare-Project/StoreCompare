package ie.gmit.proskills.Processes;

import ie.gmit.proskills.object.History;
import ie.gmit.proskills.serverconn.Requester;

/**
 * This class is responsible for retrieving the user's search history from the database. <br>
 * 
 * @author Cian Gannon
 * @author Danielis Joniškis
 * @author Eddie Eldridge
 */
public class HistoryGet {

	public static String main(String username) {
		
		String messageSend = "historyGet?" + username;

		Requester.main(messageSend);
		
		return History.getHistory();
	}

}
