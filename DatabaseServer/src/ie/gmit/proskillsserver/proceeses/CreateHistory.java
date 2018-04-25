package ie.gmit.proskillsserver.proceeses;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.MongoClient;

// used to create a history collection for the user
/**
 * Class is responsible for creating a collection inside the history database
 * 
 * @author Cian Gannon
 * @author Danielis Joniškis
 * @author Eddie Eldridge
 */
public class CreateHistory {

	/**
	 * Uses username to create a collection unique to the user
	 * 
	 * @param username
	 *            Gotten from user login/register
	 */
	@SuppressWarnings("deprecation")
	public static void main(String username) {

		// MongoDB settings
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		DB db = mongoClient.getDB("history");
		
		// Create collection using username
		db.createCollection(username, new BasicDBObject("capped", false));

		// Close DB connection
		mongoClient.close();
	}
}
