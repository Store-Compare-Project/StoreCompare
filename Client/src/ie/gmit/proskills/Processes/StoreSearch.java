package ie.gmit.proskills.Processes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import ie.gmit.proskills.Storage.Items;
import ie.gmit.proskills.Websites.Ebay;

public class StoreSearch {

	public static void main(String username, DefaultTableModel dtm) throws InterruptedException {
		
		// Threads
		EbayThread EbayThread;
		
		// Items Object list array
		List<Items> itemList = new ArrayList<Items>();
			
		EbayThread = new EbayThread(username, itemList, dtm);
		EbayThread.start();
		EbayThread.join();
	}
}

class EbayThread extends Thread {
 	String gameName;
 	List<Items> itemList;
 	DefaultTableModel dtm;
	
 	EbayThread(String g, List<Items> i, DefaultTableModel d) {
		gameName = g;
		itemList = i;
		dtm = d;
		
	}
	
	public void run() {

		try {
			Ebay.main(gameName, itemList, dtm);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}