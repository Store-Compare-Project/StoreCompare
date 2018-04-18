package ie.gmit.proskillsserver.runner;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import ie.gmit.proskillsserver.server.EchoServer;

public class Runner {

	public static void main(String[] args) throws Exception {
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		System.out.println(); //2016/11/16 12:08:43
		
		System.out.println("> (" + dateFormat.format(date) + ") Starting Server...");
		
		System.err.close();
		
		EchoServer.main(args);
		
		
		
	}
	
}
