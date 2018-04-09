package ie.gmit.proskills.Menu;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ie.StoreCompare.storage.Items;
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
		
		// Items Object list array
		List<Items> itemList = new ArrayList<Items>();
				
		// Decelerations
		Scanner reader = new Scanner(System.in);

		// Debug
		System.out.println("YOU ARE IN THE MAINPAGE CLASS!");
		
		// Prompt user for input
		System.out.println("Enter item to search: ");
		searchTerm = reader.nextLine();
		
	}

}
