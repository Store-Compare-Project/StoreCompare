package ie.gmit.proskills.Websites;

import java.io.IOException;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import ie.gmit.proskills.Storage.Items;

public class Adverts {

	// Run this class when we want to search amazon
	public static void run(String searchTerm, List<Items> itemList) throws IOException
	{
		// Varaibles
		String name = null;
		String priceString=null;
		String urlPart1="https://www.adverts.ie/for-sale/q_";
		String urlPart2="/";
		String completeUrl;
		double price=0.00;
		
		// Replace any spaces with a +
		searchTerm = searchTerm.replaceAll(" ", "+");
		
		// Complete the url with search terms added 
		completeUrl = urlPart1 + searchTerm + urlPart2;

		// Debug
		System.out.println(urlPart1);
		System.out.println(urlPart2);
		System.out.println(completeUrl);
		
		// Tell the user they're request is being sent to the user
		System.out.println("\nSending request..." + "\"" + completeUrl + "\"");
		
		// Create a document of the HTML of the webpage we are searching (In our case ebay)
		Document doc = Jsoup.connect(completeUrl).userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/535.2 (KHTML, like Gecko) Chrome/15.0.874.120 Safari/535.2").timeout(60000).get();
	
		// If item is a special item, Aliexpress uses div
		Elements els  = doc.getElementsByClass("sr-grid-cell quick-peek-container");		
		
		// For every element of the element we assigned above
		for(Element el : els)
		{
					try
					{
						name = (el.getElementsByClass("title").text()).replaceAll("Name: ", "");
					} 
					catch (Exception e)
					{
						System.out.println("Name not found.");
					}
					
					
					try
					{
						priceString =  ((el.getElementsByClass("price").text().replaceAll("[^0-9.]", "")));
						price = Double.parseDouble(priceString);
					} 
					catch (NumberFormatException e) 
					{
						//e.printStackTrace();
						//System.out.println("Price not found.");
					}
					
					// Add the found stuff to our list
					itemList.add(new Items(name, price));
	}
	}
	
}
