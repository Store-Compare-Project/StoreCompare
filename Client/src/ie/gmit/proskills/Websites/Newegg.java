package ie.gmit.proskills.Websites;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import ie.gmit.proskills.Storage.Items;
import ie.gmit.proskills.object.StoreInfo;
/**
 * This class is responsible for parsing and extracing data from the Newegg.ie website. <br>
 * From here the DOM is broken down into elements which we can loop through and extract data from <br>
 * 
 * @author Cian Gannon
 * @author Danielis Joniškis
 * @author Eddie Eldridge
 */
public class Newegg {

	// Run this class when we want to search Newegg
	public static void run(String searchTerm, DefaultTableModel dtm) throws IOException
	{
		DecimalFormat df = new DecimalFormat("#.00");

		// Variables
		String name = null;
		String priceString=null;
		String urlPart1="https://www.newegg.com/global/ie/Product/ProductList.aspx?Submit=ENE&DEPA=0&Order=BESTMATCH&Description=";
		String urlPart2="&N=-1&isNodeId=1";
		String completeUrl;
		double postage = 7.50;
		double total =0.00;
		double price=0.00;
		int totalQueries = 0;
		double allPrices = 0;
		
		// Replace any spaces with a +
		searchTerm = searchTerm.replaceAll(" ", "+");
		
		// Complete the url with search terms added 
		completeUrl = urlPart1 + searchTerm + urlPart2;
		
		// Tell the user they're request is being sent to the user
		System.out.println("\nSending request..." + "\"" + completeUrl + "\"");
		
		// Create a document of the HTML of the webpage we are searching (In our case ebay)
		Document doc =  Jsoup.connect(completeUrl)
			      .userAgent("Mozilla/5.0 (Windows; U; WindowsNT 5.1; en-US; rv1.8.1.6) Gecko/20070725 Firefox/2.0.0.6")
			      .referrer("http://www.google.com")
			      .get();
	
		// Get all html of this class
		Elements els  = doc.getElementsByClass("item-container");
				
		// For every element of the element we assigned above
		for(Element el : els)
		{
			totalQueries++;
				
			name = (el.getElementsByClass("item-title").text()).replaceAll("Name: ", "");					
												
		    priceString =  ((el.getElementsByClass("price-current").text().replaceAll("[^0-9,]", "")));
			String newString = priceString.replaceAll(",",".");
			String subbedPriceString = newString.substring(0, newString.length() - 1);
			price = Double.parseDouble(subbedPriceString);				
					
			total = price + postage;
			
			allPrices += total;
			totalQueries++;
			
			// Add the found stuff to our list
			dtm.addRow(new Object [] { name, "€" + df.format(price), "€" + df.format(postage), "€" + df.format(total), "Newegg"});
		}
		
		StoreInfo.setNeweggAvg(df.format(allPrices/totalQueries));
	}
	
}
