package ie.StoreCompare.core;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ie.StoreCompare.storage.Items;
import ie.StoreCompare.store.cex.Cex;
import ie.StoreCompare.store.gamestop.Gamestop;
import ie.StoreCompare.store.musicmagpie.MusicMagPieEbayStore;

public class Menu {

	public static void main(String[] args) throws InterruptedException {
		
		// Threads
		CexThread CexThread;
		MusicMagPieThread MusicMagPieThread;
		GamestopThread GamestopThread;
		
		// User Input
		Scanner reader = new Scanner(System.in);
		
		// Items Object list array
		List<Items> itemList = new ArrayList<Items>();
		
		// Variables
		String gameName = null;
		int menu = -1;
		
		while(menu != 0){
			
			// Menu Prompt
			System.out.println("=========== Menu ===========");
			System.out.println(") 1. Search MusicMagPie");
			System.out.println(") 2. Search Cex");
			System.out.println(") 3. Search GameStop");
			System.out.println(") 4. Search MusicMagPie/Cex");
			System.out.println(") 0. Exit");
			menu = reader.nextInt();
			reader.nextLine();
			
			if(menu >= 1 && menu <= 4){
				System.out.println("> Game to Search: ");
				gameName = reader.nextLine();
				
				if(menu == 1){
					MusicMagPieThread = new MusicMagPieThread(gameName, itemList);
					MusicMagPieThread.start();
					menu = 0;
					MusicMagPieThread.join();
				}
				else if(menu == 2){
					CexThread = new CexThread(gameName, itemList);
					CexThread.start();
					menu = 0;
					
					CexThread.join();
				}
				else if(menu == 3){
					GamestopThread = new GamestopThread(gameName, itemList);
					GamestopThread.start();
					menu = 0;
					
					GamestopThread.join();
				}
				else if(menu == 4){
					MusicMagPieThread = new MusicMagPieThread(gameName, itemList);
					CexThread = new CexThread(gameName, itemList);
					MusicMagPieThread.start();
					CexThread.start();
					menu = 0;
					
					MusicMagPieThread.join();
					CexThread.join();
				}
			}else if(menu == 0){
				System.out.println("Goodbye!");
			}
			else{
				System.out.println("\nPlease select a valid option");
			}
		}
		
		// Basic output of object list array
		System.out.println(itemList);
		
		reader.close();
	}
}

class CexThread extends Thread {
 	String gameName;
 	List<Items> itemList;
	
	CexThread(String g, List<Items> i) {
		gameName = g;
		itemList = i;
	}
	
	public void run() {

		try {
			Cex.main(gameName, itemList);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class MusicMagPieThread extends Thread {
 	String gameName;
 	List<Items> itemList;
	
 	MusicMagPieThread(String g, List<Items> i) {
		gameName = g;
		itemList = i;
	}
	
	public void run() {

		try {
			MusicMagPieEbayStore.main(gameName, itemList);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class GamestopThread extends Thread {
 	String gameName;
 	List<Items> itemList;
	
 	GamestopThread(String g, List<Items> i) {
		gameName = g;
		itemList = i;
	}
	
	public void run() {
		try {
			Gamestop.main(gameName, itemList);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}