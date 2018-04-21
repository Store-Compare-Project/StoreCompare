package ie.gmit.proskills.Processes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import ie.gmit.proskills.Storage.Items;
import ie.gmit.proskills.Websites.Ebay;

public class StoreSearch {

public static void main(String[] args) throws InterruptedException {
		
		// Threads
		EbayThread EbayThread;
		
		// Items Object list array
		List<Items> itemList = new ArrayList<Items>();
		
		// Variables
		String gameName = null;
			
		EbayThread = new EbayThread(gameName, itemList);
		EbayThread.start();
		EbayThread.join();
	}
}

class EbayThread extends Thread {
 	String gameName;
 	List<Items> itemList;
	
 	EbayThread(String g, List<Items> i) {
		gameName = g;
		itemList = i;
	}
	
	public void run() {

		try {
			Ebay.main(gameName, itemList);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}