package ie.gmit.proskillsserver.runner;

import ie.gmit.proskillsserver.server.EchoServer;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This class is dedicated to running the program.
 * This class 'kick-starts' the server that is used to connect to a mongoDB.
 * The server accepts user input on one of the many threads and parses whether the data is login or register.
 * 
 * @author Cian Gannon
 * @author Danielis Joniškis
 * @author Eddie Eldridge
 */

public class Runner {

	/**
	 * 
	 * 
	 * @param args Default function values
	 * @throws Exception Ignores any errors that occur
	 * 
	 * @param dateFormat Used to set date/time format
	 * @param date Used to generate a date/time for the current date/time
	 * 
	 * @param EchoServer.main() Calls the main server component
	 * 
	 */
	public static void main(String[] args) throws Exception {

		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();

		System.out.println("> (" + dateFormat.format(date) + ") Starting Server...");

		System.err.close();

		EchoServer.main(args);
	}
}
