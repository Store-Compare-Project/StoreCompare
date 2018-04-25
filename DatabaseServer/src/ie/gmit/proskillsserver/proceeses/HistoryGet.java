package ie.gmit.proskillsserver.proceeses;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

/**
 * This class retrieves all history from the users history database collection
 * 
 * @author Cian Gannon
 * @author Danielis Joniškis
 * @author Eddie Eldridge
 */
public class HistoryGet {

	/**
	 * 
	 * @param username
	 *            username used to search history collection
	 * @return Returns a string of all the history collection elements
	 */
	@SuppressWarnings("deprecation")
	public static String main(String username) {

		int i = -1;

		StringBuilder builder = new StringBuilder();

		// MongoDB settings
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		DB db = mongoClient.getDB("history");
		DBCollection coll = db.getCollection(username);

		// Gets all DB collections
		DBCursor cursor = coll.find();

		while (cursor.hasNext()) {
			i++;
			// Get cursor items and adds them to the DBObject
			DBObject temp = cursor.next();

			// Gets username and password
			String itemTemp = temp.get("item").toString();
			String price1Temp = temp.get("ebayAVG").toString();
			String price2Temp = temp.get("doneDealAVG").toString();
			String price3Temp = temp.get("neweggAVG").toString();
			String dateTemp = temp.get("date").toString();

			// Builder separates items with '?' Used later to differentiate data
			// with a string array split
			builder.append("?" + itemTemp + "?" + price1Temp + "?" + price2Temp + "?" + price3Temp + "?" + dateTemp);
		}

		// Close cursor
		cursor.close();

		// Close database connection
		mongoClient.close();

		// Return String
		return builder.toString();
	}

}
