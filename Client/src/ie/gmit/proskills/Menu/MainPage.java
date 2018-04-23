package ie.gmit.proskills.Menu;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ie.gmit.proskills.Storage.Items;
import ie.gmit.proskills.Websites.Adverts;
import ie.gmit.proskills.Websites.Ebay;
import ie.gmit.proskills.Websites.Newegg;

public class MainPage 
{

	@SuppressWarnings("deprecation")
	public static void run() throws InterruptedException 
	{
		
		// Threads
		EbayThread EbayThread;
		AdvertsThread AdvertsThread;
		NeweggThread NeweggThread;
							
		// Variables
		boolean menuKeeper = true;
		String searchTerm = null;
		int menuChoice = 0;
		
		// Items Object list array
		List<Items> itemList = new ArrayList<Items>();
				
		// Declarations
		Scanner reader = new Scanner(System.in);

		// Debug
		System.out.println("YOU ARE IN THE MAINPAGE CLASS!");
		
		// Prompt user for input
		System.out.println("Enter item to search: ");
		searchTerm = reader.nextLine();
		
		// Menu display
		System.out.println("1: Ebay");
		System.out.println("2: Aliexpress");
		System.out.println("3: Newegg");

		menuChoice = reader.nextInt();

		// Switch statement for menu choice
		switch (menuChoice)
		{
			// Ebay
			case 1:
				EbayThread = new EbayThread(searchTerm, itemList);
				EbayThread.start();
				EbayThread.join();
				break;
			
			// Aliexpress
			case 2:
				AdvertsThread = new AdvertsThread(searchTerm, itemList);
				AdvertsThread.start();
				AdvertsThread.join();
			break;
			
			// Newegg
			case 3:
				NeweggThread = new NeweggThread(searchTerm, itemList);
				NeweggThread.start();
				NeweggThread.join();
			break;
				
		}

		
		// Basic output of object list array
		System.out.println(itemList);
		
		
		// Close reader
		reader.close();
		
	}

}

// Declare threads
// Ebay Thread
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
			Ebay.main(searchTerm, null);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}

//Newegg Thread
class NeweggThread extends Thread 
{
	// Variables
	String searchTerm;
	List<Items> itemList;
	
	// Constructor
	NeweggThread(String g, List<Items> i)
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
			Newegg.run(searchTerm, itemList);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
}

//Adverts Thread
class AdvertsThread extends Thread 
{
	// Variables
	String searchTerm;
	List<Items> itemList;
	
	// Constructor
	AdvertsThread(String g, List<Items> i)
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
			Adverts.run(searchTerm, null);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
}
