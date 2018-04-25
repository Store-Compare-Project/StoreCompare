package ie.gmit.proskills.Processes;

import ie.gmit.proskills.serverconn.Requester;

public class HistoryAdd {

	public static void main(String username, String item, String ebayAVG, String doneDealAVG, String date) {
			   
		String messageSend = "history?" + username + "?" + item + "?" + ebayAVG + "?"  + doneDealAVG + "?" +  date;
	   
	   	Requester.main(messageSend);
	}
}