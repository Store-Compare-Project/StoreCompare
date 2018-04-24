package ie.gmit.proskillsserver.proceeses;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

public class CreateHistory {

	@SuppressWarnings("deprecation")
	public static void main(String username) {

		MongoClient mongoClient = new MongoClient("localhost", 27017);
		DB db = mongoClient.getDB("history");
		db.createCollection(username, new BasicDBObject("capped", false));

		mongoClient.close();
	}
}
