package ie.gmit.proskillsserver.runner;

import java.io.OutputStream;
import java.io.PrintStream;

import ie.gmit.proskillsserver.server.EchoServer;

public class Runner {

	public static void main(String[] args) throws Exception {
		
		System.out.println("> Starting Server...");
		
		System.err.close();
		
		EchoServer.main(args);
		
		
		
	}
	
}
