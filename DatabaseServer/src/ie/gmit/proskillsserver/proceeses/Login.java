package ie.gmit.proskillsserver.proceeses;

import com.mongodb.*;

/**
 * This class is responisble for logging the user into the system. </br>
 * The class checks if the user provided username and password match any users
 * in the system and then are told if they have provided correct information
 * client-side.
 * 
 * @author Cian Gannon
 * @author Danielis Joniškis
 * @author Eddie Eldridge
 */
public class Login {

	/**
	 * Method revives the login details from the user trying to access the
	 * system and checks if they are a valid user.
	 * 
	 * @param username
	 *            The username provided by the user
	 * @param password
	 *            The password provided by the user
	 * @param clientID
	 *            Client ID used to inform the server on the users login status
	 * @return returns the login status so the server can send a success or
	 *         failure to the user
	 */
	@SuppressWarnings("deprecation")
	public static Boolean main(String username, String password, int clientID) {

		// Status returned to the user
		Boolean loginStatus = false;

		// MongoDB settings
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		DB db = mongoClient.getDB("loginproject");
		DBCollection coll = db.getCollection("login");

		// Gets all DB collections
		DBCursor cursor = coll.find();

		// Loops through cursor entry by entry.
		// Stops if there is no more entry's or the user name has been found
		try {
			while (cursor.hasNext() && !loginStatus) {

				// Get cursor items and adds them to the DBObject
				DBObject temp = cursor.next();

				// Gets username and password
				String usernameTemp = temp.get("username").toString();
				String passwordTemp = temp.get("password").toString();

				// Checks if entered username/password equals the current username/password iteration
				if (usernameTemp.equals(username) && passwordTemp.equals(password)) {

					// Makes login status true.
					// This allows the user to procceed to the next page on the client
					loginStatus = true;

				}
			}
		} finally {
			// Close cursor
			cursor.close();

			// Close database connection
			mongoClient.close();
		}

		// If loginStatus is true the server will display that they have been logged in
		// If loginStatus is false the server will display that the user login failed
		if (loginStatus) {
			System.out.println("> Client ID: " + clientID + " | Logged-in Username - " + username);
		} else {
			System.out.println("> Client ID: " + clientID + " | Failed Login Username - " + username);
		}

		// Return login status to be sent to user
		return loginStatus;
	}
}
