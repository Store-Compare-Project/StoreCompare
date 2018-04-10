package ie.gmit.proskills.Menu;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ie.gmit.proskills.Storage.Items;
import ie.gmit.proskills.Websites.Amazon;
import ie.gmit.proskills.Websites.Ebay;

public class MainPage 
{

	@SuppressWarnings("deprecation")
	public static void run() throws InterruptedException 
	{
		
		// Threads
		EbayThread EbayThread;
		AmazonThread AmazonThread;
							
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
		System.out.println("2: Amazon");
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
			
			// Amazon
			case 2:
				AmazonThread = new AmazonThread(searchTerm, itemList);
				AmazonThread.start();
				AmazonThread.join();
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
			Ebay.run(searchTerm, itemList);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
}

// Amazon Thread
class AmazonThread extends Thread 
{
	// Variables
	String searchTerm;
	List<Items> itemList;
	
	// Constructor
	AmazonThread(String g, List<Items> i)
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
			Amazon.run(searchTerm, itemList);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
}
