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
	 * This class attempts to register the user into the system with the user name and password provided.
	 * If the user name is taken then the user will be informed that they cannot register with that username.
	 * If the user name isin't taken the user name and password will be added to the mongo database.
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

		Boolean loginStatus = false;

		BasicDBObject command = new BasicDBObject();

		MongoClient mongoClient = new MongoClient("localhost", 27017);
		DB db = mongoClient.getDB("loginproject");
		DBCollection coll = db.getCollection("login");

		DBCursor cursor = coll.find();

		try {
			while (cursor.hasNext() && !loginStatus) {

				DBObject temp = cursor.next();

				String usernameTemp = temp.get("username").toString();

				if (usernameTemp.equals(username)) {

					loginStatus = true;

				}
			}

			if (!loginStatus) {
				command.put("username", username);
				command.put("password", password);

				coll.insert(command);
			}

		} finally {
			cursor.close();
		}

		mongoClient.close();

		if (!loginStatus) {
			System.out.println("> Client ID: " + clientID + " | Registed Username - " + username);
		} else {
			System.out.println("> Client ID: " + clientID + " | Failed Register Username - " + username);
		}

		return loginStatus;
	}
}