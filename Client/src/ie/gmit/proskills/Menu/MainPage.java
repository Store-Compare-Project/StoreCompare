package ie.gmit.proskills.Menu;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ie.gmit.proskills.Storage.Items;
import ie.gmit.proskills.Websites.Ebay;

public class MainPage 
{

	@SuppressWarnings("deprecation")
	public static void run() throws InterruptedException 
	{
		
		// Threads
		EbayThread EbayThread;
							
		// Variables
		boolean menuKeeper = true;
		String searchTerm = null;
		
		// Items Object list array
		List<Items> itemList = new ArrayList<Items>();
				
		// Declarations
		Scanner reader = new Scanner(System.in);

		// Debug
		System.out.println("YOU ARE IN THE MAINPAGE CLASS!");
		
		// Prompt user for input
		System.out.println("Enter item to search: ");
		searchTerm = reader.nextLine();
		
		EbayThread = new EbayThread(searchTerm, itemList);
		EbayThread.start();
		EbayThread.join();
		
		// Basic output of object list array
		System.out.println(itemList);
		
		
		// Close reader
		reader.close();
		
	}

}

// Declare threads
class EbayThread extends Thread 
{
	// Variables
	String searchTerm;
	List<Items> itemList;
	
	// Constructor
	EbayThread(String g, List<Items> i)
	{
		searchTerm = g;
		itemList = i;
	}
	
	// Run method for thread
	public void run()
	{
		// Try catch
		try
		{
			Ebay.run(searchTerm, itemList);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
}
