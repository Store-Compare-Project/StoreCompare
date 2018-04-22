package ie.gmit.proskillsserver.runner;


import ie.gmit.proskillsserver.server.EchoServer;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Runner {

	public static void main(String[] args) throws Exception {
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		
		System.out.println("> (" + dateFormat.format(date) + ") Starting Server...");
		
		System.err.close();
		
		EchoServer.main(args);
	}
	
}
