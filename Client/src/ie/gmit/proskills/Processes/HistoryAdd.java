package ie.gmit.proskills.Processes;

import ie.gmit.proskills.serverconn.Requester;

/**
 * This class is responsible for sending a message to the database with the user's search so it can be saved to the history. <br>
 * 
 * @author Cian Gannon
 * @author Danielis Joniškis
 * @author Eddie Eldridge
 */
public class HistoryAdd {

	public static void main(String username, String item, String ebayAVG, String doneDealAVG, String neweggAVG, String date) {
			   
		String messageSend = "history?" + username + "?" + item + "?" + ebayAVG + "?"  + doneDealAVG + "?" +  neweggAVG + "?"  + date;
		
	   	Requester.main(messageSend);
	}
}