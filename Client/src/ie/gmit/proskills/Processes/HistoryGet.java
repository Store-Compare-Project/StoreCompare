package ie.gmit.proskills.Processes;

import ie.gmit.proskills.object.History;
import ie.gmit.proskills.serverconn.Requester;

public class HistoryGet {

	public static String main(String username) {
		
		String messageSend = "historyGet?" + username;

		Requester.main(messageSend);
		
		return History.getHistory();
	}

}
