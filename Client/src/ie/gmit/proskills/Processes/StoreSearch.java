package ie.gmit.proskills.Processes;

import ie.gmit.proskills.Storage.Items;
import ie.gmit.proskills.Websites.Adverts;
import ie.gmit.proskills.Websites.Ebay;

import java.io.IOException;
import java.util.List;

import javax.swing.table.DefaultTableModel;

public class StoreSearch {

	public static void main(String item, DefaultTableModel dtm) throws InterruptedException {

		// Threads
		EbayThread EbayThread;
		AdvertsThread AdvertsThread;

		EbayThread = new EbayThread(item, dtm);
		EbayThread.start();
		EbayThread.join();

		AdvertsThread = new AdvertsThread(item, dtm);
		AdvertsThread.start();
		AdvertsThread.join();
	}
}

class EbayThread extends Thread {
	String item;
	DefaultTableModel dtm;

	EbayThread(String i, DefaultTableModel d) {
		item = i;
		dtm = d;

	}

	public void run() {

		try {
			Ebay.main(item, dtm);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

// Adverts Thread
class AdvertsThread extends Thread {
	// Variables
	String item;
	DefaultTableModel dtm;

	// Constructor
	AdvertsThread(String i, DefaultTableModel d) {
		item = i;
		dtm = d;
	}

	// Run method for thread
	public void run() {
		// Try catch
		try {
			Adverts.run(item, dtm);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}