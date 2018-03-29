package ie.gmit.proskillsserver.proceeses;

import com.mongodb.*;

public class Login {

	@SuppressWarnings("deprecation")
	public static Boolean main(String username, String password, int clientID) {
		
		Boolean loginStatus = false;
		
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		DB db = mongoClient.getDB("loginproject");
		DBCollection coll = db.getCollection("login");
		
		DBCursor cursor = coll.find();
		
		try {
		   while(cursor.hasNext() && !loginStatus) {
			   
			   DBObject temp = cursor.next();
		       
			   String usernameTemp = temp.get("username").toString();
			   String passwordTemp = temp.get("password").toString();
			   
			   if(usernameTemp.equals(username) && passwordTemp.equals(password)){
				   
				   loginStatus = true;
				   
			   }  
		   }
		} finally {
		   cursor.close();
		}
		
		mongoClient.close();
		
		if(loginStatus){
			System.out.println("> Client ID: " + clientID + " | Logged-in - " + username);
		}else {
			System.out.println("> Client ID: " + clientID + " | Failed Login - " + username);
		}
		
		return loginStatus;
	}
}
