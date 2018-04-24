package ie.gmit.proskillsserver.proceeses;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

public class HistoryGet {

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
				String dateTemp = temp.get("date").toString();
				
				 builder.append("?" +itemTemp + "?" + price1Temp + "?" + price2Temp + "?" + dateTemp);
		}

		// Close cursor
		cursor.close();

		// Close database connection
		mongoClient.close();
		
		String history = builder.toString();

		return history;
	}

}

