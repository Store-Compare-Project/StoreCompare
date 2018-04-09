package ie.gmit.proskills.Menu;

import java.io.IOException;
import java.util.Scanner;

import ie.gmit.proskills.Websites.Discogs;

public class MainPage 
{

	public static void mainPage() throws InterruptedException
	{
		
		// Threads
		//DiscogsThread DiscogsThread;
							
		// Variables
		boolean menuKeeper = true;
		String searchTerm = null;
		
		// Decelerations
		Scanner reader = new Scanner(System.in);

		// Debug
		System.out.println("YOU ARE IN THE MAINPAGE CLASS!");
		
		// Prompt user for input
		searchTerm = reader.nextLine();
		
	}

}
