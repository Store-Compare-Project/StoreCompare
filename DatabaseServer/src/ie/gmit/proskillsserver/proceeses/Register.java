package ie.gmit.proskillsserver.proceeses;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

public class Register {

	@SuppressWarnings("deprecation")
	public static Boolean main(String username, String password, int clientID) {
		
		Boolean loginStatus = false;
		
		BasicDBObject command = new BasicDBObject();
		
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		DB db = mongoClient.getDB("loginproject");
		DBCollection coll = db.getCollection("login");
		
		DBCursor cursor = coll.find();
		
		try {
		   while(cursor.hasNext() && !loginStatus) {
			   
			   DBObject temp = cursor.next();
		       
			   String usernameTemp = temp.get("username").toString();
			   
			   if(usernameTemp.equals(username)){
				   
				   loginStatus = true;
				   
			   }
			   
		   }
		   
		   if(!loginStatus){
			   command.put("username", username);
			   command.put("password", password);
			   
			   coll.insert(command);
		   }
		   
		} finally {
		   cursor.close();
		}
		
		mongoClient.close();
		
		if(!loginStatus){
			System.out.println("> Client ID: " + clientID + " | Registed Username - " + username);
		}else {
			System.out.println("> Client ID: " + clientID + " | Failed Register Username - " + username);
		}
		
		return loginStatus;
	}
}