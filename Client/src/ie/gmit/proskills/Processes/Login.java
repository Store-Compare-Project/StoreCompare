package ie.gmit.proskills.Processes;

import com.mongodb.*;

import ie.gmit.proskills.serverconn.Requester;

public class Login {

	@SuppressWarnings("deprecation")
	public static Boolean main(String username, String password) {
		
		Boolean loginStatus = false;
		
		MongoClient mongoClient = new MongoClient("35.197.218.124", 27017);
		DB db = mongoClient.getDB("loginproject");
		DBCollection coll = db.getCollection("login");
		
		
		DBCursor cursor = coll.find();
		//BasicDBObject query = new BasicDBObject("username", "Cian");

		
		try {
		   while(cursor.hasNext() && !loginStatus) {
			   
			   DBObject temp = cursor.next();
		       
			   String usernameTemp = temp.get("username").toString();
			   String passwordTemp = temp.get("password").toString();
			   
			   if(usernameTemp.equals(username) && passwordTemp.equals(password)){
				   loginStatus = true;
			   }
			   
			   String messageSend = "login " + username + " " + password;
			   
			   Requester.main(messageSend);
			   
			   System.out.println(loginStatus);
			   
		   }
		} finally {
		   cursor.close();
		}
		
		mongoClient.close();
		
		return loginStatus;
	}
}
