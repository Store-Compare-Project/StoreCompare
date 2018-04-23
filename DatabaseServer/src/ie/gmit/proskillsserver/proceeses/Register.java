package ie.gmit.proskillsserver.proceeses;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

/**
 * This class is used to register the user into the system.</br>
 * This class is responsible for registering the user name and password provided
 * by the user into the database.
 * 
 * @author Cian Gannon
 * @author Danielis Joniškis
 * @author Eddie Eldridge
 */
public class Register {

	/**
	 * This class attempts to register the user into the system with the user
	 * name and password provided. If the user name is taken then the user will
	 * be informed that they cannot register with that username. If the user
	 * name isin't taken the user name and password will be added to the mongo
	 * database.
	 * 
	 * @param username
	 *            The username provided by the user
	 * @param password
	 *            The password provided by the user
	 * @param clientID
	 *            Client ID used to inform the server on the users login status
	 * @return returns The register status. This tells the server what message
	 *         to relay to the user
	 */
	@SuppressWarnings("deprecation")
	public static Boolean main(String username, String password, int clientID) {

		// Status returned to the user
		Boolean registerStatus = false;

		// MongoDB settings
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		DB db = mongoClient.getDB("loginproject");
		DBCollection coll = db.getCollection("login");

		// Gets all DB collections
		DBCursor cursor = coll.find();

		// Command used to send the mongoDB the new username and password
		BasicDBObject command = new BasicDBObject();

		// Loops through cursor entry by entry.
		// Checks if the user name is already taken
		try {
			while (cursor.hasNext() && !registerStatus) {

				// Get cursor items and adds them to the DBObject
				DBObject temp = cursor.next();

				// Get current user name from temp
				String usernameTemp = temp.get("username").toString();

				// Compares current user name to user entered username
				if (usernameTemp.equals(username)) {
					// Keeps loop going
					registerStatus = true;
				}
			}

			// If loginStatus is false it means that no user with that user name
			// exists
			if (!registerStatus) {

				// Add username and password to the command
				command.put("username", username);
				command.put("password", password);

				// Add command entries to the DBObject
				coll.insert(command);
			}

		} finally {
			// Close cursor
			cursor.close();

			// Close database connection
			mongoClient.close();
		}

		// If loginStatus is true the server will display that they have been registered
		// If loginStatus is false the server will display that the user registered failed
		if (!registerStatus) {
			System.out.println("> Client ID: " + clientID + " | Registed Username - " + username);
		} else {
			System.out.println("> Client ID: " + clientID + " | Failed Register Username - " + username);
		}

		// registerStatus which 
		return registerStatus;
	}
}