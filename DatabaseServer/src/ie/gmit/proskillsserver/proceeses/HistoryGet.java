package ie.gmit.proskillsserver.proceeses;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

public class HistoryGet {

	@SuppressWarnings("deprecation")
	public static String main(String username) {

		String history = "";

		// MongoDB settings
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		DB db = mongoClient.getDB("history");
		DBCollection coll = db.getCollection(username);

		// Gets all DB collections
		DBCursor cursor = coll.find();

		try {
			while (cursor.hasNext()) {

				// Get cursor items and adds them to the DBObject
				DBObject temp = cursor.next();

				// Gets username and password
				String itemTemp = temp.get("item").toString();
				String priceTemp = temp.get("price").toString();
				String dateTemp = temp.get("price").toString();

				history +=  itemTemp + " " + priceTemp + " " + dateTemp + " ";
			}
		} finally {
			// Close cursor
			cursor.close();

			// Close database connection
			mongoClient.close();
		}

		return history;
	}

}
