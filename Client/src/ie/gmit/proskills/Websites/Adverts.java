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
 * This class is responsible for parsing and extracing data from the Adverts.ie website. <br>
 * From here the DOM is broken down into elements which we can loop through and extract data from <br>
 * 
 * @author Cian Gannon
 * @author Danielis Joniškis
 * @author Eddie Eldridge
 */
public class Adverts {

	// Run this class when we want to search Adverts
	public static void run(String searchTerm, DefaultTableModel dtm) throws IOException {

		DecimalFormat df = new DecimalFormat("#.00");

		// Variables
		String name = null;
		String price = null;
		double total = 0.00;
		int totalQueries = 0;
		double allPrices = 0;
		String url = "https://www.adverts.ie/for-sale/q_";

		// Replace any spaces with a +
		searchTerm = searchTerm.replaceAll(" ", "+");

		// Complete the url with search terms added
		url += searchTerm;

		// Create a document of the HTML of the webpage we are searching
		Document doc = Jsoup.connect(url)
				.userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/535.2 (KHTML, like Gecko) Chrome/15.0.874.120 Safari/535.2")
				.timeout(60000)
				.get();

		// Get all html of this class
		Elements els = doc.getElementsByClass("sr-grid-cell quick-peek-container");

		// For every element of the element we assigned above
		for (Element el : els) {
			
			
			try {
			name = (el.getElementsByClass("title").text()).replaceAll("Name: ", "");

			price = "€" + ((el.getElementsByClass("price").text().replaceAll("[^0-9.]", "")));

			total = Double.parseDouble(price.replaceAll("[^0-9.]", ""));
			} catch (NumberFormatException NumberFormatException){
				continue;
			}
			
			allPrices += total;
			totalQueries++;

			// Add the found stuff to our table
			dtm.addRow(new Object[] { name, price, "Contact Seller", "€" + df.format(total), "DoneDeal" });
		}
		
		StoreInfo.setDoneDealAVG(df.format(allPrices/totalQueries));
	}

}
