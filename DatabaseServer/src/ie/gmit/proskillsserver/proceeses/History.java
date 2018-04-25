package ie.gmit.proskillsserver.proceeses;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;

/**
 * This class is responsible for adding a history entry in the history
 * collection
 * 
 * @author Cian Gannon
 * @author Danielis Joniškis
 * @author Eddie Eldridge
 */
public class History {

	/**
	 * Uses history string variable to add to a users search result in the
	 * history database
	 * 
	 * @param history
	 *            Contains username and 4 item elements
	 */
	@SuppressWarnings("deprecation")
	public static void main(String[] history) {

		// MongoDB settings
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		DB db = mongoClient.getDB("history");
		DBCollection coll = db.getCollection(history[1]);

		// Command used to send the mongoDB the new username and password
		BasicDBObject command = new BasicDBObject();

		// Add item name, ebay average price, donedeal average price and date
		command.put("item", history[2]);
		command.put("ebayAVG", history[3]);
		command.put("doneDealAVG", history[4]);
		command.put("date", history[5]);

		// Insert collection into database
		coll.insert(command);

		// Close mongoDB connection
		mongoClient.close();
	}
}