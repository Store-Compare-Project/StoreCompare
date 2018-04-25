package ie.gmit.proskills.Processes;

import ie.gmit.proskills.Websites.Adverts;
import ie.gmit.proskills.Websites.Ebay;

import java.io.IOException;

import javax.swing.JCheckBox;
import javax.swing.table.DefaultTableModel;

public class StoreSearch {

	public static void main(String item, DefaultTableModel dtm, JCheckBox chckbxEbay, JCheckBox chckbxDonedeal)
			throws InterruptedException {

		// Threads
		EbayThread EbayThread;
		AdvertsThread AdvertsThread;

		if (chckbxEbay.isSelected()) {
			EbayThread = new EbayThread(item, dtm);
			EbayThread.start();
			EbayThread.join();
		}

		if (chckbxDonedeal.isSelected()) {
			AdvertsThread = new AdvertsThread(item, dtm);
			AdvertsThread.start();
			AdvertsThread.join();
		}
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