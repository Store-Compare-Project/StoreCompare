package ie.gmit.proskillsserver.runner;

import ie.gmit.proskillsserver.server.EchoServer;

public class Runner {

	public static void main(String[] args) throws Exception {
		
		System.out.println("> Starting Server...");
		
		EchoServer.main(args);
		
	}
	
}
