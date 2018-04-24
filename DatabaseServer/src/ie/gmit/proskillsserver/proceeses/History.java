package ie.gmit.proskillsserver.proceeses;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;

public class History {

	public static void main(String[] history) {
		
		String[] newHistory = history;
		
		System.out.println(newHistory[0]);
		
		// MongoDB settings
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		DB db = mongoClient.getDB("history");
		DBCollection coll = db.getCollection(history[1]);
		
		// Command used to send the mongoDB the new username and password
		BasicDBObject command = new BasicDBObject();
		
		command.put("item", history[2]);
		command.put("price", history[3]);
		command.put("date", history[4]);
		
		coll.insert(command);

	}

}