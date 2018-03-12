package ie.gmit.proskills.Processes;

import com.mongodb.*;
import com.mongodb.client.MongoDatabase;

public class Login {

	public static void main(String username, String password) {
		
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		
		
		
		MongoDatabase db = mongoClient.getDatabase("login");
		
		System.out.print(db);
	}
}
