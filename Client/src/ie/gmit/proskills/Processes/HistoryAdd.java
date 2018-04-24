package ie.gmit.proskills.Processes;

import ie.gmit.proskills.serverconn.Requester;

public class HistoryAdd {

	public static void main(String username, String item, String totalAVG, String date) {
			   
		String messageSend = "history?" + username + "?" + item + "?" + totalAVG + "?"  +  date;
	   
	   	Requester.main(messageSend);
	}
}