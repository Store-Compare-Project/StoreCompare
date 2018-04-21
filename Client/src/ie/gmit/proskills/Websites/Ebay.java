package ie.gmit.proskills.Websites;

import java.io.IOException;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import ie.gmit.proskills.Storage.Items;

public class Ebay {

	public static void main(String searchTerm, DefaultTableModel dtm) throws IOException {
		
		String name = null;
		String priceString=null;
		double price = 0.00;
		double postage = 0.00;
		String urlPart1 = "https://www.ebay.ie/sch/i.html?_from=R40&_trksid=p2380057.m570.l1313.TR0.TRC0.H0.X";
		String urlPart2 = ".TRS0&_nkw=";
		String completeUrl;
		String store = "Ebay";

		// Replace any spaces with a +
		searchTerm = searchTerm.replaceAll(" ", "+");
		
		// Complete the url with search terms added 
		completeUrl = urlPart1 + searchTerm + urlPart2 + searchTerm;
		
		// Create a document of the HTML of the webpage we are searching (In our case ebay)
		Document doc = Jsoup.connect(completeUrl).userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/535.2 (KHTML, like Gecko) Chrome/15.0.874.120 Safari/535.2").timeout(60000).get();
		
		// Selecting the following element of 
		Elements els  = doc.select("li.sresult.lvresult");
		
		// Print out the whole DOM
		//System.out.println(doc);

		// For every element of the element we assign above
		for(Element el : els)
		{
			try
			{
				name = (el.getElementsByClass("lvtitle").text()).replaceAll("Name: ", "");
				
				priceString =  ((el.getElementsByClass("lvprice prc").text().replaceAll("[^0-9.]", "")));
				price = Double.parseDouble(priceString);
				postage =  Double.parseDouble((el.getElementsByClass("fee").text()).replaceAll("[^0-9.]", ""));
				
			} 
			catch (Exception e)
			{
				//Error
			}
			
			dtm.addRow(new Object[] { name, "€" + price, "€" + postage, store });
		}
	}
}
