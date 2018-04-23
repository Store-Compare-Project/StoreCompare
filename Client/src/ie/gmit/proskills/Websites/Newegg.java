package ie.gmit.proskills.Websites;

import java.io.IOException;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import ie.gmit.proskills.Storage.Items;

public class Newegg {

	// Run this class when we want to search amazon
	public static void run(String searchTerm, List<Items> itemList) throws IOException
	{
		// Varaibles
		String name = null;
		String priceString=null;
		String urlPart1="https://www.newegg.com/global/ie/Product/ProductList.aspx?Submit=ENE&DEPA=0&Order=BESTMATCH&Description=";
		String urlPart2="&N=-1&isNodeId=1";
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
		Document doc =  Jsoup.connect(completeUrl)
			      .userAgent("Mozilla/5.0 (Windows; U; WindowsNT 5.1; en-US; rv1.8.1.6) Gecko/20070725 Firefox/2.0.0.6")
			      .referrer("http://www.google.com")
			      .get();
		//System.out.println(doc);
	
		// If item is a special item, Aliexpress uses div
		Elements els  = doc.getElementsByClass("item-container");
		
		// If not a special item, Aliexpress uses ul
		// Element els  = doc.select("ul#hs-below-list-items");
		

		//System.out.println(els);
		
		// For every element of the element we assigned above
		for(Element el : els)
		{
					try
					{
						name = (el.getElementsByClass("item-title").text()).replaceAll("Name: ", "");
						//System.out.println(name);
					} 
					catch (Exception e)
					{
						System.out.println("Name not found.");
					}
					
					
					try
					{
						priceString =  ((el.getElementsByClass("price-current").text().replaceAll("[^0-9,]", "")));
						String newString = priceString.replaceAll(",",".");
						String subbedPriceString = newString.substring(0, newString.length() - 1);
						price = Double.parseDouble(subbedPriceString);
					} 
					catch (NumberFormatException e) 
					{
						System.out.println("Price not found.");
					}
					
					// Add the found stuff to our list
					itemList.add(new Items(name, price));
	}
	}
	
}
