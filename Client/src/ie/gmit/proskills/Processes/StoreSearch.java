package ie.gmit.proskills.Processes;

import ie.gmit.proskills.Websites.Ebay;

import java.io.IOException;
import javax.swing.table.DefaultTableModel;

public class StoreSearch {

	public static void main(String username, DefaultTableModel dtm) throws InterruptedException {
		
		// Threads
		EbayThread EbayThread;
			
		EbayThread = new EbayThread(username, dtm);
		EbayThread.start();
		EbayThread.join();
	}
}

class EbayThread extends Thread {
 	String gameName;
 	DefaultTableModel dtm;
	
 	EbayThread(String g, DefaultTableModel d) {
		gameName = g;
		dtm = d;
		
	}
	
	public void run() {

		try {
			Ebay.main(gameName, dtm);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}