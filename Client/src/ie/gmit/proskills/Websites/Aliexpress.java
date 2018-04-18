package ie.gmit.proskills.Websites;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.util.List;

import org.jsoup.Connection;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.helper.HttpConnection;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import ie.gmit.proskills.Storage.Items;

public class Aliexpress {

	// Run this class when we want to search amazon
	public static void run(String searchTerm, List<Items> itemList) throws IOException
	{
		// Varaibles
		String name = null;
		String priceString=null;
		String urlPart1="https://www.aliexpress.com/wholesale?catId=0&initiative_id=SB_20180418114634&SearchText=";
		String urlPart2="";
		String completeUrl;
		double price=0.00;
		
		// Replace any spaces with a +
		searchTerm = searchTerm.replaceAll(" ", "+");
		
		// Complete the url with search terms added 
		completeUrl = urlPart1 + searchTerm;

		// Debug
		System.out.println(urlPart1);
		System.out.println(urlPart2);
		System.out.println(completeUrl);
		
		// Tell the user they're request is being sent to the user
		System.out.println("\nSending request..." + "\"" + completeUrl + "\"");
		
		// Create a document of the HTML of the webpage we are searching (In our case ebay)
		Document doc = Jsoup.connect(completeUrl).userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/535.2 (KHTML, like Gecko) Chrome/15.0.874.120 Safari/535.2").timeout(60000).get();

		//System.out.println(doc);
	
		// If item is a special item, Aliexpress uses div
		Elements els  = doc.select("div#hs-below-list-items");
		
		// If not a special item, Aliexpress uses ul
		// Element els  = doc.select("ul#hs-below-list-items");
		

		//System.out.println(els);
		
		// For every element of the element we assigned above
		for(Element el : els)
		{
					try
					{
						name = (el.getElementsByClass("history-item.product").text()).replaceAll("Name: ", "");
					} 
					catch (Exception e)
					{
						System.out.println("Name not found.");
					}
					
					
					try
					{
						priceString =  ((el.getElementsByClass("price price-m").text().replaceAll("[^0-9.]", "")));
						System.out.println(priceString);
						price = Double.parseDouble(priceString);
						//System.out.println(price);
						//price = Double.parseDouble(priceString);
						//System.out.println(price);
						//Elements itemPrice = doc.select("span[itemprop]"); //Get address
						//name = itemPrice.text().replaceAll("Price: ", "");


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
